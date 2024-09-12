package com.ctpantoja.ecommerce.product

import com.ctpantoja.ecommerce.exception.BusinessException
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.*
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class ProductClient(

    @Value("\${application.config.product-service-url}")
    val productUrl: String,

    val restTemplate: RestTemplate
) {

    fun purchaseProducts(requestBody: List<PurchaseRequest>): List<PurchaseResponse>? {
        val headers = HttpHeaders().apply {
            contentType = MediaType.APPLICATION_JSON
        }

        val requestEntity = HttpEntity(requestBody, headers)
        val responseType = object : ParameterizedTypeReference<List<PurchaseResponse>>() {}

        val responseEntity: ResponseEntity<List<PurchaseResponse>> = restTemplate.exchange(
            "$productUrl/purchase",
            HttpMethod.POST,
            requestEntity,
            responseType
        )

        if (responseEntity.statusCode.isError) {
            throw BusinessException("An error occurred while processing the products purchase: ${responseEntity.statusCode}")
        }

        return responseEntity.body
    }
}
