package com.ctpantoja.ecommerce.customer

import com.ctpantoja.ecommerce.exception.CustomerNotFoundException
import org.apache.commons.lang.StringUtils
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) {
    fun createCustomer(request: CustomerRequest): String {
        val customer = customerRepository.save(request.toCustomer())
        return customer.id
    }

    fun updateCustomer(request: CustomerRequest) {
        val customer = customerRepository.findById(request.id)
            .orElseThrow {
                CustomerNotFoundException(
                    "Cannot update customer:: No customer found with the provided ID:: ${request.id}"
                )
            }

        mergerCustomer(customer, request)
        customerRepository.save(customer)
    }

    fun mergerCustomer(customer: Customer, request: CustomerRequest) {
        if (StringUtils.isNotBlank(request.firstName)) {
            customer.firstName = request.firstName
        }

        if (StringUtils.isNotBlank(request.lastName)) {
            customer.lastName = request.lastName
        }

        if (StringUtils.isNotBlank(request.email)) {
            customer.email = request.email
        }

        customer.address = request.address!!
    }

    fun findAllCustomers(): List<CustomerResponse>? {
        return customerRepository.findAll().map { it.toCustomerResponse() }
    }

    fun findCustomerById(customerId: String): CustomerResponse? {
        return customerRepository.findById(customerId).map { it.toCustomerResponse() }
            .orElseThrow {
                CustomerNotFoundException(
                    "Cannot update customer:: No customer found with the provided ID:: $customerId"
                )
            }
    }

    fun deleteCustomer(customerId: String) {
        customerRepository.deleteById(customerId)
    }
}
