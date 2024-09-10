package com.ctpantoja.ecommerce.product

import com.ctpantoja.ecommerce.category.Category
import java.math.BigDecimal

data class ProductResponse(

    val id: Int,

    val name: String,

    val description: String,

    val availableQuantity: Double,

    val price: BigDecimal,

    val categoryId: Int,

    val categoryName: String,

    val categoryDescription: String
) {
}