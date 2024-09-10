package com.ctpantoja.ecommerce.product

import jakarta.validation.constraints.NotNull

data class ProductPurchaseRequest(

    @NotNull(message = "Product ID is required")
    val productId: Int,

    @NotNull(message = "Quantity is required")
    val quantity: Double
) {

}
