package dev.gokhana.restapibestpractices.controller

import dev.gokhana.restapibestpractices.exception.UserNotFoundException
import dev.gokhana.restapibestpractices.model.BaseResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.stream.Collectors


@ControllerAdvice
internal class GlobalControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleNotValidException(exception: MethodArgumentNotValidException): ResponseEntity<BaseResponse<Any>> {
        val message = exception.bindingResult.fieldErrors.stream().map { it.defaultMessage }.collect(Collectors.joining(", "))
        return ResponseEntity.badRequest().body(BaseResponse.fail(message = message))
    }

    @ExceptionHandler(UserNotFoundException::class)
    fun handleUserNotFoundException(exception: UserNotFoundException): ResponseEntity<BaseResponse<Any>> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(BaseResponse.fail(message = exception.message))
    }
}