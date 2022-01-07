package dev.gokhana.restapibestpractices.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

class BaseResponse<T> @JsonCreator constructor(
    @param:JsonProperty("success")
    val isSuccess: Boolean,
    @param:JsonProperty("payload")
    val payload: T?,
    @param:JsonProperty("message")
    val message: String?,
){
    companion object {
        fun <T> success(payload: T? = null, message: String? = null): BaseResponse<T> {
            return BaseResponse(true, payload, message)
        }

        fun <T> fail(payload: T? = null, message: String? = null): BaseResponse<T> {
            return BaseResponse(false, payload, message)
        }
    }
}
