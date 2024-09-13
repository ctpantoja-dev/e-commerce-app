package com.ctpantoja.ecommerce.payment

import org.springframework.stereotype.Service

@Service
class PaymentMapper {

    fun toPayment(paymentRequest: PaymentRequest): Payment
            = Payment(
                id = paymentRequest.id,
                orderId = paymentRequest.orderId,
                paymentMethod = paymentRequest.paymentMethod,
                amount = paymentRequest.amount
            )
}
