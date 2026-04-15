package com.alleslocker.backend.application.task.usecase

import com.alleslocker.backend.application.common.ErrorResponse
import com.alleslocker.backend.application.common.OutputBoundary
import com.alleslocker.backend.application.task.mapper.toDTO
import com.alleslocker.backend.domain.task.Task
import com.alleslocker.backend.domain.task.TaskDescription
import com.alleslocker.backend.domain.task.TaskId
import com.alleslocker.backend.domain.task.TaskTitle

class GetTaskUseCaseImpl : com.alleslocker.backend.application.task.usecase.GetTaskUseCase {
    override fun execute(
        request: com.alleslocker.backend.application.task.usecase.GetTaskRequest,
        presenter: com.alleslocker.backend.application.common.OutputBoundary<com.alleslocker.backend.application.task.usecase.GetTaskResponse>
    ) {
        val tasks = setOf(
            Task(
                id = TaskId("1"),
                title = TaskTitle("Sample Task 1"),
                description = TaskDescription("This is a sample task description"),
                isCompleted = false
            ),
            Task(
                id = TaskId("2"),
                title = TaskTitle("Sample Task 2"),
                description = TaskDescription("This is another sample task description."),
                isCompleted = true
            )
        )

        val task = tasks.find { it.id == TaskId(request.taskId) }
        if (task == null) {
            presenter.presentFailure(
                _root_ide_package_.com.alleslocker.backend.application.common.ErrorResponse.NotFound("Task with ID ${request.taskId} not found.")
            )
            return
        }

        presenter.present(
            _root_ide_package_.com.alleslocker.backend.application.task.usecase.GetTaskResponse(
                task = task.toDTO()
            )
        )
    }
}