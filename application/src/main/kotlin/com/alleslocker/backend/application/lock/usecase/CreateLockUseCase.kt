package com.alleslocker.backend.application.lock.usecase

import com.alleslocker.backend.application.common.InputBoundary
import com.alleslocker.backend.application.lock.dto.request.CreateLockRequestDto
import com.alleslocker.backend.application.lock.dto.response.CreateLockResponseDto

interface CreateLockUseCase : InputBoundary<CreateLockRequestDto, CreateLockResponseDto>