package dev.gokhana.restapibestpractices.controller

import org.springframework.http.HttpStatus

import org.springframework.web.bind.annotation.ControllerAdvice


@ControllerAdvice
internal class GlobalControllerExceptionHandler {
    /*
    @ResponseStatus(HttpStatus.CONFLICT) // 409
    @ExceptionHandler(DataIntegrityViolationException::class)
    fun handleConflict() {
        // Nothing to do
    }*/
}