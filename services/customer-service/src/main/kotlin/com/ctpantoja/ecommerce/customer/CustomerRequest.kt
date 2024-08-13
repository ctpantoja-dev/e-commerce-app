package com.ctpantoja.ecommerce.customer

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotNull


data class CustomerRequest(

    val id: String,

    @NotNull(message = "Customer firstname is required")
    val firstName: String,

    @NotNull(message = "Customer lastname is required")
    val lastName: String,

    @NotNull(message = "Customer email is required")
    @Email(message = "Customer email is invalid")
    val email: String,

    val address: Address?
)

fun CustomerRequest.toCustomer() = Customer(
    id = id,
    firstName = firstName,
    lastName = lastName,
    email = email,
    address = address
)
