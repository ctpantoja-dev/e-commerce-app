package com.ctpantoja.ecommerce.customer

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    name = "customer-service",
    url = "\${application.config.customer-service-url}"
)
interface CustomerClient {

    @GetMapping("/{customerId}")
    fun findCustomerById(@PathVariable("customerId") customerId: String): CustomerResponse?
}
