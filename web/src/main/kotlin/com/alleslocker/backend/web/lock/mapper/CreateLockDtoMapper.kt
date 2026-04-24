package com.alleslocker.backend.web.lock.mapper

import com.alleslocker.backend.application.lock.dto.request.CreateLockRequestDto
import com.alleslocker.backend.web.lock.schema.request.CreateLockRequestSchema

fun CreateLockRequestSchema.toDto() = CreateLockRequestDto(
    name = this.name,
    description = this.description,
)