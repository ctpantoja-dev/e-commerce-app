package com.ctpantoja.ecommerce.payment

import com.ctpantoja.ecommerce.notification.NotificationProducer
import com.ctpantoja.ecommerce.notification.PaymentNotification
import org.springframework.stereotype.Service

@Service
class PaymentService(
    val paymentRepository: PaymentRepository,
    val paymentMapper: PaymentMapper,
    val notificationProducer: NotificationProducer
) {

    fun createPayment(paymentRequest: PaymentRequest): Int? {

        val payment = paymentRepository.save(paymentMapper.toPayment(paymentRequest))

        notificationProducer.sendPaymentNotification(
            PaymentNotification(
                orderReference = paymentRequest.orderReference,
                amount = paymentRequest.amount,
                paymentMethod = paymentRequest.paymentMethod,
                customerFirstName = paymentRequest.customer.firstName,
                customerLastName = paymentRequest.customer.lastName,
                customerEmail = paymentRequest.customer.email
            )
        )

        return payment.id
    }
}
