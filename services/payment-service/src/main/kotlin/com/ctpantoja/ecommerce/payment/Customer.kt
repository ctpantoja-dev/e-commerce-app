package com.ctpantoja.ecommerce.payment

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotNull
import org.springframework.validation.annotation.Validated

@Validated
data class Customer(

    val id: String,

    @NotNull(message = "First name is required")
    val firstName: String,

    @NotNull(message = "Last name is required")
    val lastName: String,

    @NotNull(message = "Email is required")
    @Email(message = "Email is invalid")
    val email: String
) {

}
