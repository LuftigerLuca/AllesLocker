package com.alleslocker.backend.application.task.mapper

import com.alleslocker.backend.application.task.dto.TaskDTO
import com.alleslocker.backend.domain.task.Task
import com.alleslocker.backend.domain.task.TaskDescription
import com.alleslocker.backend.domain.task.TaskId
import com.alleslocker.backend.domain.task.TaskTitle

fun Task.toDTO() = _root_ide_package_.com.alleslocker.backend.application.task.dto.TaskDTO(
    id = this.id.value,
    title = this.title.value,
    description = this.description.value,
    isCompleted = this.isCompleted
)

fun com.alleslocker.backend.application.task.dto.TaskDTO.toDomain() = Task(
    id = TaskId(this.id),
    title = TaskTitle(this.title),
    description = TaskDescription(this.description),
    isCompleted = this.isCompleted
)