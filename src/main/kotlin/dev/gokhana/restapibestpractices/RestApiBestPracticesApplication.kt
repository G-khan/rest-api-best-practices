package dev.gokhana.restapibestpractices

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
class RestApiBestPracticesApplication

fun main(args: Array<String>) {
    runApplication<RestApiBestPracticesApplication>(*args)
}
