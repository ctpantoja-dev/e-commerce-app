package com.ctpantoja.ecommerce.customer

import org.springframework.data.mongodb.repository.MongoRepository

interface CustomerRepository: MongoRepository<Customer, String> {
}