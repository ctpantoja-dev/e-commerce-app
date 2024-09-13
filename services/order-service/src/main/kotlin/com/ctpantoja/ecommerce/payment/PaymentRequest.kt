package com.ctpantoja.ecommerce.payment

import com.ctpantoja.ecommerce.customer.CustomerResponse
import com.ctpantoja.ecommerce.order.PaymentMethod
import java.math.BigDecimal

data class PaymentRequest(
    val id: Int? = null,
    val amount: BigDecimal,
    val paymentMethod: PaymentMethod,
    val orderId: Int,
    val orderReference: String,
    val customer: CustomerResponse
) {

}
