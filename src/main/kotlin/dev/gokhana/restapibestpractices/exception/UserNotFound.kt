package dev.gokhana.restapibestpractices.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such a Order")  // 404
class UserNotFound(override val message:String?) : RuntimeException()