package com.ctpantoja.ecommerce.product

import com.ctpantoja.ecommerce.category.Category
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
data class Product(

    @Id
    @GeneratedValue
    val id: Int,
    val name: String,
    val description: String,
    var availableQuantity: Double,
    val price: BigDecimal,
    @ManyToOne
    @JoinColumn(name = "category_id")
    val category: Category
) {}