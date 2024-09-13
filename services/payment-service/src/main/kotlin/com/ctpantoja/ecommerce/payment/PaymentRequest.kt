package com.ctpantoja.ecommerce.payment

import java.math.BigDecimal

data class PaymentRequest(

    val id: Int,
    val amount: BigDecimal,
    val paymentMethod: PaymentMethod,
    val orderId: Int,
    val orderReference: String,
    val customer: Customer
) {

}
