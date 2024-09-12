package com.ctpantoja.ecommerce.orderline

import com.ctpantoja.ecommerce.order.Order
import org.springframework.stereotype.Service

@Service
class OrderLineMapper {

    fun toOrderLine(orderLineRequest: OrderLineRequest): OrderLine
        = OrderLine(
            id = orderLineRequest.id!!,
            quantity = orderLineRequest.quantity,
            order = Order(
                id = orderLineRequest.orderId
            ),
            productId = orderLineRequest.productId
        )

    fun toOrderLineResponse(orderLine: OrderLine): OrderLineResponse
        = OrderLineResponse(
            id = orderLine.id,
            quantity = orderLine.quantity
        )

}
