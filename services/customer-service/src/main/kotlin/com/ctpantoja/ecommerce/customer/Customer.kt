package com.ctpantoja.ecommerce.customer

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.validation.annotation.Validated

@Document
@Validated
data class Customer(

    @Id
    val id: String,

    var firstName: String,

    var lastName: String,

    var email: String,

    var address: Address?
)

@Validated
data class Address(
    private val street: String,
    private val houseNumber: String,
    private val zipCode: String
)

fun Customer.toCustomerResponse() = CustomerResponse(
    id = id,
    firstName = firstName,
    lastName = lastName,
    email = email,
    address = address
)