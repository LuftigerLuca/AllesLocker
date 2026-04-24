package com.alleslocker.backend.application.lock.dto.request

data class CreateLockRequestDto (
    val name: String,
    val description: String?,
)