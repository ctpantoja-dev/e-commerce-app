package com.ctpantoja.ecommerce.product

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import java.math.BigDecimal

class ProductRequest(
    val id: Int,

    @NotNull(message = "Product name is required")
    val name: String,

    @NotNull(message = "Product description name is required")
    val description: String,

    @Positive(message = "Available quantity should be positive")
    val availableQuantity: Double,

    @Positive(message = "Price should be positive")
    val price: BigDecimal,

    @NotNull(message = "Category is required")
    val categoryId: Int
) {

}
