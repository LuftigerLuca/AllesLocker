package com.alleslocker.backend.application.person.usecase

import com.alleslocker.backend.application.common.OutputBoundary
import com.alleslocker.backend.application.person.dto.request.CreatePersonRequestDto
import com.alleslocker.backend.application.person.dto.response.CreatePersonFailureResponseDto
import com.alleslocker.backend.application.person.dto.response.CreatePersonResponseDto
import com.alleslocker.backend.application.person.gateway.PersonGateway
import com.alleslocker.backend.domain.person.*

internal class CreatePersonUseCaseImpl(
    private val personGateway: PersonGateway
) : CreatePersonUseCase {

    override fun execute(
        request: CreatePersonRequestDto,
        presenter: OutputBoundary<CreatePersonResponseDto>
    ) {
        val email = try {
            PersonEmail(request.email)
        } catch (_: IllegalArgumentException) {
            presenter.present(CreatePersonFailureResponseDto.EmailInvalid(request.email))
            return
        }

        val firstname = try {
            PersonFirstname(request.firstname)
        } catch (_: IllegalArgumentException) {
            presenter.present(CreatePersonFailureResponseDto.FirstnameInvalid(request.firstname))
            return
        }

        val lastname = try {
            PersonLastname(request.lastname)
        } catch (_: IllegalArgumentException) {
            presenter.present(CreatePersonFailureResponseDto.LastnameInvalid(request.lastname))
            return
        }

        if (personGateway.existsByEmail(request.email)) {
            presenter.present(CreatePersonFailureResponseDto.EmailAlreadyExists(request.email))
            return
        }

        val person = Person(
            id = PersonId.generate(),
            firstname = firstname,
            lastname = lastname,
            email = email,
            roles = emptySet()
        )

        val saved = try {
            personGateway.save(person)
        } catch (e: Exception) {
            presenter.present(CreatePersonFailureResponseDto.InternalError(e.message ?: "Unknown error"))
            return
        }

        presenter.present(
            CreatePersonResponseDto(
                id = saved.id.value
            )
        )
    }
}