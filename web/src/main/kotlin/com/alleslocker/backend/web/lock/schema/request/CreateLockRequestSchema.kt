package com.alleslocker.backend.web.lock.schema.request

data class CreateLockRequestSchema (
    val name: String,
    val description: String?,
)