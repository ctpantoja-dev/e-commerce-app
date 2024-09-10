package com.ctpantoja.ecommerce.product

import com.ctpantoja.ecommerce.category.Category
import org.springframework.stereotype.Service

@Service
class ProductMapper {

    fun toProduct(productRequest: ProductRequest): Product
        = Product(
            id = productRequest.id,
            name = productRequest.name,
            description = productRequest.description,
            availableQuantity = productRequest.availableQuantity,
            price = productRequest.price,
            category = Category(
                id = productRequest.categoryId,
                name = null,
                description = null,
                products = null
            )
        )

    fun toProductResponse(product: Product): ProductResponse
        = ProductResponse(
        id = product.id,
        name = product.name,
        description = product.description,
        availableQuantity = product.availableQuantity,
        price = product.price,
        categoryId = product.category.id,
        categoryName = product.category.name!!,
        categoryDescription = product.category.description!!
    )

    fun toProductPurchaseResponse(product: Product, quantity: Double): ProductPurchaseResponse
        = ProductPurchaseResponse(
            productId = product.id,
            name = product.name,
            description = product.description,
            price = product.price,
            quantity = quantity
        )
}
