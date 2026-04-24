package com.alleslocker.backend.application.lock.dto.request

data class CreateLockRequestDto (
    val id: String,
    val name: String,
    val description: String?,
)