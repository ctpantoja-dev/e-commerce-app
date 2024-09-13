package com.ctpantoja.ecommerce.notification

import com.ctpantoja.ecommerce.payment.PaymentMethod
import java.math.BigDecimal

data class PaymentNotification(

    val orderReference: String,
    val amount: BigDecimal,
    val paymentMethod: PaymentMethod,
    val customerFirstName: String,
    val customerLastName: String,
    val customerEmail: String
) {

}
