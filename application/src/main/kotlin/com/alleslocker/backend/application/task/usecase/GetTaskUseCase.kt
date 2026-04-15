package com.alleslocker.backend.application.task.usecase

import com.alleslocker.backend.application.common.InputBoundary

interface GetTaskUseCase :
    com.alleslocker.backend.application.common.InputBoundary<com.alleslocker.backend.application.task.usecase.GetTaskRequest, com.alleslocker.backend.application.task.usecase.GetTaskResponse> {
}