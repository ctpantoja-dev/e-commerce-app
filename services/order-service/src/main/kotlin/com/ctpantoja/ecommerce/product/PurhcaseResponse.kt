package com.ctpantoja.ecommerce.product

data class PurchaseResponse(

    val productId: Int,

    val name: String,

    val description: String,

    val quantity: Double
) {

}
