package com.ctpantoja.ecommerce.order

import com.fasterxml.jackson.annotation.JsonInclude
import java.math.BigDecimal

@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class OrderResponse(

    val id: Int,

    val reference: String,

    val amount: BigDecimal,

    val paymentMethod: PaymentMethod,

    val customerId: String
) {

}
