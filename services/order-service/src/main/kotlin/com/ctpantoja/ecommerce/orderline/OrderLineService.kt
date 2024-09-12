package com.ctpantoja.ecommerce.orderline

import org.springframework.stereotype.Service

@Service
class OrderLineService(

    val orderLineRepository: OrderLineRepository,

    val orderLineMapper: OrderLineMapper
) {

    fun saveOrderLine(orderLineRequest: OrderLineRequest): Int {
        val orderLine = orderLineMapper.toOrderLine(orderLineRequest)

        return orderLineRepository.save(orderLine).id
    }

    fun findAllByOrderId(orderId: Int): List<OrderLineResponse>?
        = orderLineRepository.findAllByOrderId(orderId)?.map { orderLineMapper.toOrderLineResponse(it) }?.toList()
}
