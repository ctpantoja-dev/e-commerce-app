package com.ctpantoja.ecommerce.config

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class KafkaPaymentTopicConfig {

    @Bean
    fun paymentTopic(): NewTopic
        = TopicBuilder.name("payment-topic").build()
}