package com.alleslocker.backend.application.task.dto

data class TaskDTO(
    val id: String,
    val title: String,
    val description: String,
    val isCompleted: Boolean
)