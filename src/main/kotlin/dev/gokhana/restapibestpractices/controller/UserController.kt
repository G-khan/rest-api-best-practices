package dev.gokhana.restapibestpractices.controller

import dev.gokhana.restapibestpractices.model.UserDTO
import dev.gokhana.restapibestpractices.service.UserService
import io.swagger.annotations.*
import org.springframework.http.MediaType
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*


@Api(value = "users", description = "Rest api for User Management")
@RestController
@RequestMapping("v1/api/users")
@Validated
class UserController(
    private val userService: UserService
) {

    @ApiOperation(value = "Retrieve a user by id ", response = UserDTO::class)
    @ApiResponses(
        value = [
            ApiResponse(code = 200, message = "OK"),
            ApiResponse(code = 404, message = "The resource not found")
        ]
    )
    @GetMapping(
        name = "/{id}", produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun retrieveUser(@PathVariable("id") id: Int): UserDTO {
        return userService.getById(id)
    }

    @ApiOperation(value = "Retrieve users according to max records parameter")
    @ApiResponses(
        value = [
            ApiResponse(code = 200, message = "OK"),
            ApiResponse(code = 204, message = "There is not a user in list")
        ]
    )
    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun retrieveAllUsers(
        @ApiParam(value = "maxRecords", required = false, defaultValue = "5")
        @RequestParam(required = false) maxRecords: Int?
    ): List<UserDTO> {
        return userService.getUsers(maxRecords)
    }

    @ApiOperation(value = "create a user")
    @ApiResponses(
        value = [
            ApiResponse(code = 201, message = "user created"),
            ApiResponse(code = 400, message = "Invalid user object.")
        ]
    )
    @PostMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createUser(@RequestBody userDTO: UserDTO): UserDTO {
        return userService.createUser(userDTO)
    }

    @ApiOperation(value = "update a user")
    @ApiResponses(
        value = [
            ApiResponse(code = 200, message = "OK"),
            ApiResponse(code = 400, message = "Invalid user object."),
            ApiResponse(code = 404, message = "The resource not found")
        ]
    )
    @PutMapping(
        name = "/{id}", consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateUser(@PathVariable id: Int, @RequestBody userDTO: UserDTO): UserDTO {
        return userService.updateUser(id, userDTO)
    }

    @ApiOperation(value = "patch a user info")
    @ApiResponses(
        value = [
            ApiResponse(code = 200, message = "OK"),
            ApiResponse(code = 400, message = "Invalid user object."),
            ApiResponse(code = 404, message = "The resource not found")
        ]
    )
    @PatchMapping(
        name = "/{id}", consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun patchUpdateUser(@PathVariable("id") id: Int, @RequestBody userDTO: UserDTO): UserDTO {
        return userService.patchUser(id, userDTO)
    }

    @ApiOperation(value = "patch a user info")
    @ApiResponses(
        value = [
            ApiResponse(code = 204, message = "No content"),
            ApiResponse(code = 404, message = "The resource not found")
        ]
    )
    @DeleteMapping("/{id}")
    fun removeUser(@PathVariable("id") id: Int, @RequestBody userDTO: UserDTO) {
        return userService.deleteUserById(id)
    }
}