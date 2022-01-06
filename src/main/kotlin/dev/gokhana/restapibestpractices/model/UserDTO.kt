package dev.gokhana.restapibestpractices.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import org.jetbrains.annotations.NotNull

@ApiModel("A user object")
data class UserDTO(
    @ApiModelProperty(notes = "Provided id", hidden = true)
    var id: Int,

    @ApiModelProperty(notes = "user name of user, it can be nickname", required = true)
    @field:NotNull var name: String,

    @ApiModelProperty(notes = "personal blog or website of user", required = true)
    @field:NotNull var website: String
)