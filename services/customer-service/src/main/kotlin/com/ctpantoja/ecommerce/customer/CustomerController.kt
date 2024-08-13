package com.ctpantoja.ecommerce.customer

import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(
    private val customerService: CustomerService,
) {

    @PostMapping
    fun createCustomer(
        @RequestBody @Valid customerRequest: CustomerRequest
    ): ResponseEntity<String> {
        return ResponseEntity.ok(customerService.createCustomer(customerRequest))
    }

    @PutMapping
    fun updateCustomer(
        @RequestBody @Valid customerRequest: CustomerRequest
    ): ResponseEntity<Unit> {
        customerService.updateCustomer(customerRequest)
        return ResponseEntity.accepted().build()
    }

    @GetMapping
    fun findAllCustomers(): ResponseEntity<List<CustomerResponse>> {
        return ResponseEntity.ok(customerService.findAllCustomers())
    }

    @GetMapping("/{customerId}")
    fun findCustomerById(@PathVariable customerId: String): ResponseEntity<CustomerResponse> {
        return ResponseEntity.ok(customerService.findCustomerById(customerId))
    }

    @DeleteMapping("/{customerId}")
    fun deleteCustomer(@PathVariable customerId: String): ResponseEntity<Unit> {
        customerService.deleteCustomer(customerId)
        return ResponseEntity.accepted().build()
    }
}