package com.ctpantoja.ecommerce.orderline

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderLineRepository : JpaRepository<OrderLine, Int> {
    fun findAllByOrderId(orderId: Int): List<OrderLine>?;
}
