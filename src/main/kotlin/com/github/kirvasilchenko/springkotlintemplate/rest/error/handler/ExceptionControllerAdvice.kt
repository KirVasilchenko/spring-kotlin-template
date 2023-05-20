package com.github.kirvasilchenko.springkotlintemplate.rest.error.handler

import com.github.kirvasilchenko.springkotlintemplate.exception.EntityNotFoundException
import com.github.kirvasilchenko.springkotlintemplate.rest.error.ErrorMessageModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionControllerAdvice {

    @ExceptionHandler
    fun handleNoSuchElementException(ex: NoSuchElementException): ResponseEntity<ErrorMessageModel> {
        return ofStatus(HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun handleEntityNotFoundException(ex: EntityNotFoundException): ResponseEntity<ErrorMessageModel> {
        return ofStatusAndMessage(HttpStatus.NOT_FOUND, ex.message!!)
    }

    private fun ofStatus(status: HttpStatus): ResponseEntity<ErrorMessageModel> {
        return ResponseEntity.status(status).body(ErrorMessageModel(status.value(), status.reasonPhrase))
    }

    private fun ofStatusAndMessage(status: HttpStatus, message: String): ResponseEntity<ErrorMessageModel> {
        return ResponseEntity.status(status).body(ErrorMessageModel(status.value(), message))
    }

}