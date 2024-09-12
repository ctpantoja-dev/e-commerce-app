package com.ctpantoja.ecommerce.handler

import com.ctpantoja.ecommerce.exception.BusinessException
import jakarta.persistence.EntityNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class OrderExceptionHandler {

    @ExceptionHandler(BusinessException::class)
    fun handle(exception: BusinessException): ResponseEntity<String> =
        ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.message)

    @ExceptionHandler(EntityNotFoundException::class)
    fun handle(exception: EntityNotFoundException): ResponseEntity<String> =
        ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.message)

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handle(exception: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {

        val errors = mutableMapOf<String, String>()
        exception.bindingResult.fieldErrors.forEach() {
            errors[it.field] = it.defaultMessage!!
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponse(errors))
    }
}

data class ErrorResponse(val errors: Map<String, String>)