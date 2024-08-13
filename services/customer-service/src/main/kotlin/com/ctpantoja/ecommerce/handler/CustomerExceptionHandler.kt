package com.ctpantoja.ecommerce.handler

import com.ctpantoja.ecommerce.exception.CustomerNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
class CustomerExceptionHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler(CustomerNotFoundException::class)
    fun handle(exception: CustomerNotFoundException): ProblemDetail {

        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.message)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handle(exception: MethodArgumentNotValidException): ProblemDetail {

        val problemDetails = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Invalid request")

        val errorsMap = mutableMapOf<String, Any>()
        exception.bindingResult.fieldErrors.forEach() {
            errorsMap[it.field] = it.defaultMessage!!
        }
        problemDetails.properties = errorsMap

        return problemDetails
    }
}

data class ErrorResponse(val errors: Map<String, String>)