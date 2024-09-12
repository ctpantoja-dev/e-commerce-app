package com.ctpantoja.ecommerce.order

import com.ctpantoja.ecommerce.product.PurchaseRequest
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import java.math.BigDecimal

data class OrderRequest(

    val id: Int,

    val reference: String,

    @Positive(message = "Order amount should be positive")
    val amount: BigDecimal,

    @NotNull(message = "Payment method should not be null")
    val paymentMethod: PaymentMethod,

    @NotNull(message = "Customer should be present")
    @NotEmpty(message = "Customer should be present")
    @NotBlank(message = "Customer should be present")
    val customerId: String,

    @NotEmpty(message = "Order should have at least one product")
    val products: List<PurchaseRequest>
) {

}
