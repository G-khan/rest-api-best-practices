package dev.gokhana.restapibestpractices.controller

import dev.gokhana.restapibestpractices.model.UserDTO
import dev.gokhana.restapibestpractices.service.UserService
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.*


@Api(value = "users", description = "user management api v1")
@RestController
@RequestMapping("v1/api/users")
class UserController(
    private val userService: UserService
) {

    @GetMapping("/{id}")
    fun retrieveUser(@PathVariable("id") id: Int): UserDTO {
        return userService.getById(id)
    }

    @GetMapping
    fun retrieveAllUsers(@RequestParam(required = false) page: Int?, @RequestParam(required = false) maxRecords: Int?): List<UserDTO> {
        return userService.getUsers(page,maxRecords)
    }

    @PostMapping
    fun createUser(@RequestBody userDTO: UserDTO): UserDTO {
        return userService.createUser(userDTO)
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable("id") id: Int,@RequestBody userDTO: UserDTO): UserDTO {
        return userService.updateUser(id, userDTO)
    }

    @PatchMapping("/{id}")
    fun patchUpdateUser(@PathVariable("id") id: Int,@RequestBody userDTO: UserDTO): UserDTO {
        return userService.patchUser(id, userDTO)
    }

    @DeleteMapping("/{id}")
    fun removeUser(@PathVariable("id") id: Int,@RequestBody userDTO: UserDTO) {
        return userService.deleteUserById(id)
    }
}