package com.ctpantoja.ecommerce.orderline

import com.ctpantoja.ecommerce.order.Order
import jakarta.persistence.*


@Entity
@Table(name = "customer_line")
data class OrderLine(

    @Id
    @GeneratedValue
    val id: Int,

    @ManyToOne
    @JoinColumn(name = "order_id")
    val order: Order,

    val productId: Int,

    val quantity: Double
) {
}
