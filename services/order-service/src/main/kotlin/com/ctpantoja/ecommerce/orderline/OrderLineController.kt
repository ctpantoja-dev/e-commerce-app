package com.ctpantoja.ecommerce.orderline

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/order-lines")
class OrderLineController(
    val orderLineService: OrderLineService
) {

    @GetMapping("/order/{orderId}")
    fun findByOrderId(@PathVariable("orderId") orderId: Int): ResponseEntity<List<OrderLineResponse>> {

        return ResponseEntity.ok(orderLineService.findAllByOrderId(orderId))
    }
}