package com.alleslocker.backend.application.lock.usecase

import com.alleslocker.backend.application.common.ErrorResponse
import com.alleslocker.backend.application.common.OutputBoundary
import com.alleslocker.backend.application.lock.dto.request.CreateLockRequestDto
import com.alleslocker.backend.application.lock.dto.response.CreateLockResponseDto
import com.alleslocker.backend.application.lock.gateway.LockGateway
import com.alleslocker.backend.domain.lock.Lock
import com.alleslocker.backend.domain.lock.LockDescription
import com.alleslocker.backend.domain.lock.LockId
import com.alleslocker.backend.domain.lock.LockName

internal class CreateLockUseCaseImpl(
    private val lockGateway: LockGateway
): CreateLockUseCase {
    override fun execute(
        request: CreateLockRequestDto,
        presenter: OutputBoundary<CreateLockResponseDto>
    ) {
        val name = try {
            LockName(request.name)
        } catch (e: IllegalArgumentException) {
            presenter.presentFailure(ErrorResponse.BadRequest("Invalid name; ${e.message}"))
            return
        }
        val description = try {
            request.description?.let { LockDescription(it) }
        } catch (e: IllegalArgumentException) {
            presenter.presentFailure(ErrorResponse.BadRequest("Invalid description; ${e.message}"))
            return
        }
        val lock = Lock(
            id = LockId.generate(),
            name = name,
            description = description,
        )
        val saved = try {
            lockGateway.save(lock)
        } catch (e: Exception) {
            presenter.presentFailure(ErrorResponse.InternalServerError("Invalid lock; ${e.message}"))
            return
        }
        presenter.present(
            CreateLockResponseDto(
                id = saved.id.value,
            )
        )
    }
}