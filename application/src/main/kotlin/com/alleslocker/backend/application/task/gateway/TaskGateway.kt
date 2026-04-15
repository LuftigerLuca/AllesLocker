package com.alleslocker.backend.application.task.gateway

import com.alleslocker.backend.application.common.gateway.ReadWriteGateway
import com.alleslocker.backend.domain.task.Task
import com.alleslocker.backend.domain.task.TaskId

interface TaskGateway : com.alleslocker.backend.application.common.gateway.ReadWriteGateway<Task, TaskId>