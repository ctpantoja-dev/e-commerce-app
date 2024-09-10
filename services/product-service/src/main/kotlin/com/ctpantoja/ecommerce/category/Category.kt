package com.ctpantoja.ecommerce.category

import com.ctpantoja.ecommerce.product.Product
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
data class Category(
    @Id
    @GeneratedValue
    val id: Int,
    val name: String?,
    val description: String?,
    @OneToMany(mappedBy = "category")
    val products: List<Product>?
)
