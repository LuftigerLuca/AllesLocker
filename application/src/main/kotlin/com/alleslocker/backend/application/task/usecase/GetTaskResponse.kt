package com.alleslocker.backend.application.task.usecase

import com.alleslocker.backend.application.task.dto.TaskDTO

data class GetTaskResponse(
    val task: com.alleslocker.backend.application.task.dto.TaskDTO
)