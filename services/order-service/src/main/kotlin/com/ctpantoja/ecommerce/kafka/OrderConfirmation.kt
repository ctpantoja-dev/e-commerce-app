package com.ctpantoja.ecommerce.kafka

import com.ctpantoja.ecommerce.customer.CustomerResponse
import com.ctpantoja.ecommerce.order.PaymentMethod
import com.ctpantoja.ecommerce.product.PurchaseResponse
import java.math.BigDecimal

data class OrderConfirmation(

    val orderReference: String,

    val totalAmount: BigDecimal,

    val paymentMethod: PaymentMethod,

    val customer: CustomerResponse,

    val products: List<PurchaseResponse>
    ) {

}
