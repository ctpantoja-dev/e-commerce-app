package com.ctpantoja.ecommerce.product

import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/products")

class ProductController(
    private val productService: ProductService
) {

    @PostMapping
    fun createProduct(@RequestBody @Valid productRequest: ProductRequest): ResponseEntity<Int> {
        return ResponseEntity.ok(productService.createProduct(productRequest))
    }

    @PostMapping("/purchase")
    fun purchaseProduct(
        @RequestBody @Valid productPurchaseRequest: List<ProductPurchaseRequest>
    ): ResponseEntity<List<ProductPurchaseResponse>> {
        return ResponseEntity.ok(productService.purchaseProducts(productPurchaseRequest))
    }

    @GetMapping("/{productId}")
    fun findById(@PathVariable("productId") productId: Int): ResponseEntity<ProductResponse> {
        return ResponseEntity.ok(productService.findById(productId))

    }

    @GetMapping
    fun findAll(): ResponseEntity<List<ProductResponse>> {
        return ResponseEntity.ok(productService.findAll())
    }
}