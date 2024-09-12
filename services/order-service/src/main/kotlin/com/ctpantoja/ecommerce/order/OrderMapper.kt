package com.ctpantoja.ecommerce.order

import org.springframework.stereotype.Service

@Service
class OrderMapper {

    fun toOrder(orderRequest: OrderRequest): Order
        = Order(
            id = orderRequest.id,
            customerId = orderRequest.customerId,
            reference = orderRequest.reference,
            totalAmount = orderRequest.amount,
            paymentMethod = orderRequest.paymentMethod
        )

    fun fromOrder(order: Order): OrderResponse
        = OrderResponse(
            id = order.id,
            customerId = order.customerId!!,
            reference = order.reference!!,
            amount = order.totalAmount!!,
            paymentMethod = order.paymentMethod!!
        )
}
