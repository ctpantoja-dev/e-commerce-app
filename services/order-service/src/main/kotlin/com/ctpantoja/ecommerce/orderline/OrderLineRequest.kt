package com.ctpantoja.ecommerce.orderline

data class OrderLineRequest(

    val id: Int?,

    val orderId: Int,

    val productId: Int,

    val quantity: Double
) {

}
