package com.ctpantoja.ecommerce.product

import com.ctpantoja.ecommerce.exception.ProductPurchaseException
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service

@Service
class ProductService(
    val productRepository: ProductRepository,
    val productMapper: ProductMapper
) {

    fun createProduct(productRequest: ProductRequest): Int {

        val product = productMapper.toProduct(productRequest)
        return productRepository.save(product).id
    }

    fun purchaseProducts(productPurchaseRequests: List<ProductPurchaseRequest>): List<ProductPurchaseResponse>? {
        val productIds = productPurchaseRequests.map { it.productId }.toList()

        val storedProducts = productRepository.findAllById(productIds)

        if (storedProducts.size != productIds.size) {
            throw ProductPurchaseException("One or more products does not exist.")
        }

        val sortedRequest = productPurchaseRequests.sortedWith(compareBy { it.productId }).toList()
        val purchasedProducts: MutableList<ProductPurchaseResponse> = mutableListOf()

        storedProducts.forEachIndexed({ i, product ->
            val productRequest = sortedRequest[i]
            if (product.availableQuantity < productRequest.quantity) {
                throw ProductPurchaseException(
                    "Insufficient stock quantity for product with ID:: ${productRequest.productId}")
            }

            val newAvailableQuantity = product.availableQuantity - productRequest.quantity
            product.availableQuantity = newAvailableQuantity


            productRepository.save(product)

            purchasedProducts.add(productMapper.toProductPurchaseResponse(product, productRequest.quantity))
        })

        return purchasedProducts
    }

    fun findById(productId: Int): ProductResponse
        = productRepository.findById(productId)
            .map { productMapper.toProductResponse(it) }
            .orElseThrow{ throw EntityNotFoundException("Product not found with the ID:: $productId") }

    fun findAll(): List<ProductResponse>?
        = productRepository.findAll().map { productMapper.toProductResponse(it) }.toList()
}