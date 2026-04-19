package com.alleslocker.backend.application.person.dto.response

import com.alleslocker.backend.application.common.Failure
import com.alleslocker.backend.application.common.Response

data class CreatePersonResponseDto(
    val id: String
) : Response<CreatePersonResponseDto>

sealed class CreatePersonFailureResponseDto : Failure {
    data class EmailAlreadyExists(val email: String) : CreatePersonFailureResponseDto()
    data class EmailInvalid(val email: String) : CreatePersonFailureResponseDto()
    data class FirstnameInvalid(val firstname: String) : CreatePersonFailureResponseDto()
    data class LastnameInvalid(val lastname: String) : CreatePersonFailureResponseDto()
    data class InternalError(val message: String) : CreatePersonFailureResponseDto()
}