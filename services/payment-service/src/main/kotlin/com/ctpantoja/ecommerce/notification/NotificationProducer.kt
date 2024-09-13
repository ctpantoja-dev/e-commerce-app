package com.ctpantoja.ecommerce.notification

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service

@Service
class NotificationProducer(
    val kafkaTemplate: KafkaTemplate<String, PaymentNotification>
) {

    fun sendPaymentNotification(paymentNotification: PaymentNotification) {

        logger.info("Sending payment notification for order reference: ${paymentNotification.orderReference}")

        val paymentNotificationMessage: Message<PaymentNotification>
            = MessageBuilder
                .withPayload(paymentNotification)
                .setHeader(KafkaHeaders.TOPIC, "payment-topic")
                .build()

        kafkaTemplate.send(paymentNotificationMessage)
    }

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(this::class.java)
    }
}