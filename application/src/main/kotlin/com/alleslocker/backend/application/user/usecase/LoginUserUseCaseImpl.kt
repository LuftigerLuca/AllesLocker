package com.alleslocker.backend.application.user.usecase

import com.alleslocker.backend.application.common.security.PasswordHasher

internal class LoginUserUseCaseImpl(
    private val passwordHasher: PasswordHasher,
    private val userGateway: com.alleslocker.backend.application.user.gateway.UserGateway
) : com.alleslocker.backend.application.user.usecase.LoginUserUseCase {

    override fun execute(
        request: com.alleslocker.backend.application.user.dto.request.LoginUserRequestDto,
        presenter: com.alleslocker.backend.application.common.OutputBoundary<com.alleslocker.backend.application.user.dto.response.LoginUserResponseDto>
    ) {
        val user = userGateway.findByUsername(request.username)
        if (user == null) {
            presenter.presentFailure(_root_ide_package_.com.alleslocker.backend.application.common.ErrorResponse.NotFound("User doesn't exist"))
            return
        }

        if (!passwordHasher.verify(request.password, user.passwordHash.value)) {
            presenter.presentFailure(_root_ide_package_.com.alleslocker.backend.application.common.ErrorResponse.BadRequest("Invalid password"))
            return
        }

        presenter.present(
            _root_ide_package_.com.alleslocker.backend.application.user.dto.response.LoginUserResponseDto(
                user.id.value
            )
        )
    }
}