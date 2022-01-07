package dev.gokhana.restapibestpractices.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@ApiModel("A user object")
data class UserDTO(
    @ApiModelProperty(notes = "Provided id", hidden = true)
    var id: Int,

    @ApiModelProperty(notes = "user name of user, it can be nickname", value = "nick", required = true)
    @field:NotBlank(message = "Name cannot blank.")
    var name: String?,

    @ApiModelProperty(notes = "personal email of user", value = "gokhana@mail.com", required = true)
    @field:Email(regexp = "^(.+)@(.+)\$", message = "Email is not valid. Please follow the example: gokhana@mail.com")
    @field:NotBlank
    var email: String?,

    @ApiModelProperty(notes = "any personal detail of user", value = "Nothing special.", required = false)
    var detail: String? = null,

)