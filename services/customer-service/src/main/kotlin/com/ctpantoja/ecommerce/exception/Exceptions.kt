package com.ctpantoja.ecommerce.exception

data class CustomerNotFoundException(override val message: String) : RuntimeException(message)