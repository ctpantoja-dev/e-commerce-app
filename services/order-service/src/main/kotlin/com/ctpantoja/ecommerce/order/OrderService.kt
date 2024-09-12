package com.ctpantoja.ecommerce.order

import com.ctpantoja.ecommerce.customer.CustomerClient
import com.ctpantoja.ecommerce.customer.CustomerResponse
import com.ctpantoja.ecommerce.exception.BusinessException
import com.ctpantoja.ecommerce.kafka.OrderConfirmation
import com.ctpantoja.ecommerce.kafka.OrderProducer
import com.ctpantoja.ecommerce.orderline.OrderLineRequest
import com.ctpantoja.ecommerce.orderline.OrderLineService
import com.ctpantoja.ecommerce.product.ProductClient
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service

@Service
class OrderService(
    val customerClient: CustomerClient,
    val productClient: ProductClient,
    val orderLineService: OrderLineService,
    val orderMapper: OrderMapper,
    val orderRepository: OrderRepository,
    val orderProducer: OrderProducer
) {

    fun createOrder(orderRequest: OrderRequest): Int {

        // check the customer
        val customer: CustomerResponse = customerClient.findCustomerById(orderRequest.customerId)
            ?: throw BusinessException("Cannot create order :: No customer exists with the provided id ${orderRequest.customerId}")

        // purchase the products --> call the product service (RestTemplate)
        val purchaseProducts = productClient.purchaseProducts(orderRequest.products)

        // persist order
        val order = orderRepository.save(orderMapper.toOrder(orderRequest))

        orderRequest.products.forEach {
            orderLineService.saveOrderLine(
                OrderLineRequest(null, order.id, it.productId, it.quantity)
            )
        }

        // TODO start payment process

        // TODO send the order confirmation --> call the notification service (kafka)
        orderProducer.sendOrderConfirmation(
            OrderConfirmation(
                orderReference = order.reference!!,
                totalAmount = order.totalAmount!!,
                paymentMethod = order.paymentMethod!!,
                customer = customer,
                products = purchaseProducts!!
            )
        )

        return order.id
    }

    fun findAll(): List<OrderResponse>?
        = orderRepository.findAll().map { orderMapper.fromOrder(it) }

    fun findById(orderId: Int): OrderResponse?
        = orderRepository.findById(orderId)
            .map { orderMapper.fromOrder(it) }
            .orElseThrow { EntityNotFoundException("No order found with the provided orderId: $orderId") }
}