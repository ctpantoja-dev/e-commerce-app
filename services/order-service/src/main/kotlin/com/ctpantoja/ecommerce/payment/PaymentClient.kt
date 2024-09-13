package com.ctpantoja.ecommerce.payment

import jakarta.validation.Valid
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(
    name = "payment-service",
    url = "\${application.config.payment-service-url}"
)
interface PaymentClient {

    @PostMapping
    fun requestOrderPayment(@RequestBody @Valid paymentRequest: PaymentRequest) : Int
}