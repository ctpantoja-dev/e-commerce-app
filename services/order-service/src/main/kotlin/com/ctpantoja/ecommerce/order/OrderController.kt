package com.ctpantoja.ecommerce.order

import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/api/v1/orders")
class OrderController(
    val orderService: OrderService
) {

    @PostMapping
    fun createOrder(@RequestBody @Valid orderRequest: OrderRequest): ResponseEntity<Int> {

        return ResponseEntity.ok(orderService.createOrder(orderRequest))
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<OrderResponse>>
        = ResponseEntity.ok(orderService.findAll())

    @GetMapping("/{orderId}")
    fun findById(@PathVariable("orderId") orderId: Int): ResponseEntity<OrderResponse>
        = ResponseEntity.ok(orderService.findById(orderId))
}