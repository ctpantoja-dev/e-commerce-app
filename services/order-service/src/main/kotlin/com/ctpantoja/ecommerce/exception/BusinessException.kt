package com.ctpantoja.ecommerce.exception

data class BusinessException(override val message: String) : RuntimeException(message) {

}
