package com.ctpantoja.ecommerce.product

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive

data class PurchaseRequest(

    @NotNull(message = "Product id is required")
    val productId: Int,

    @Positive(message = "Quantity is required")
    val quantity: Double

) {

}
