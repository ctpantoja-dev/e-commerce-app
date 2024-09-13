package com.ctpantoja.ecommerce.payment

import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/payment")
class PaymentController(
    val paymentService: PaymentService
) {

    @PostMapping
    fun createPayment(@RequestBody @Valid paymentRequest: PaymentRequest): ResponseEntity<Int> {
        return ResponseEntity.ok(paymentService.createPayment(paymentRequest))
    }
}