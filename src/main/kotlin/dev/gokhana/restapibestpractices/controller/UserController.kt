package dev.gokhana.restapibestpractices.controller

import dev.gokhana.restapibestpractices.model.BaseResponse
import dev.gokhana.restapibestpractices.model.UserDTO
import dev.gokhana.restapibestpractices.service.UserService
import io.swagger.annotations.*
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@Api(value = "users", description = "Rest api for User Management")
@RestController
@RequestMapping("v1/api/users")
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
        path = ["/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun retrieveUser(@PathVariable("id") id: Int): BaseResponse<UserDTO> {
        val user = userService.getById(id)
        return BaseResponse.success(payload = user)
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
    ): BaseResponse<List<UserDTO>> {
        val users = userService.getUsers(maxRecords)
        return BaseResponse.success(payload = users)
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
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@Valid @RequestBody userDTO: UserDTO): BaseResponse<UserDTO> {
        val user = userService.createUser(userDTO)
        return BaseResponse.success(payload = user)
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
        path = ["/{id}"], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE]
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
        path = ["/{id}"], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun patchUpdateUser(
        @PathVariable(name = "id", required = true) id: Int,
        @RequestBody userDTO: UserDTO
    ): BaseResponse<UserDTO> {
        val user = userService.patchUser(id, userDTO)
        return BaseResponse.success(user, "Partial update is succesfully completed via patch.")
    }

    @ApiOperation(value = "patch a user info")
    @ApiResponses(
        value = [
            ApiResponse(code = 204, message = "No content"),
            ApiResponse(code = 404, message = "The resource not found")
        ]
    )
    @DeleteMapping(path = ["/{id}"])
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun removeUser(@PathVariable id: Int, @RequestBody userDTO: UserDTO) {
        userService.deleteUserById(id)
    }
}