package com.ctpantoja.ecommerce.kafka

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service

@Service
class OrderProducer(
    val kafkaTemplate: KafkaTemplate<String, OrderConfirmation>
) {

    fun sendOrderConfirmation(orderConfirmation: OrderConfirmation) {

        logger.info("Sending order confirmation for order reference: ${orderConfirmation.orderReference}")

        val orderConfirmationMessage: Message<OrderConfirmation> = MessageBuilder
            .withPayload(orderConfirmation)
            .setHeader(KafkaHeaders.TOPIC, "order-topic")
            .build()

        kafkaTemplate.send(orderConfirmationMessage)
    }

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(this::class.java)
    }

}