package com.alleslocker.backend.application.common.factory

import com.alleslocker.backend.application.common.InputBoundary
import com.alleslocker.backend.application.security.PasswordHasher
import com.alleslocker.backend.application.task.usecase.GetTaskUseCase
import com.alleslocker.backend.application.task.usecase.GetTaskUseCaseImpl
import com.alleslocker.backend.application.user.gateway.UserGateway
import com.alleslocker.backend.application.user.usecase.LoginUserUseCase
import com.alleslocker.backend.application.user.usecase.LoginUserUseCaseImpl
import com.alleslocker.backend.application.user.usecase.RegisterUserUseCase
import com.alleslocker.backend.application.user.usecase.RegisterUserUseCaseImpl
import kotlin.reflect.KClass

class UseCaseFactoryImpl(
    private val gatewayFactory: com.alleslocker.backend.application.common.factory.GatewayFactory,
    private val passwordHasher: com.alleslocker.backend.application.security.PasswordHasher,
) : com.alleslocker.backend.application.common.factory.UseCaseFactory {

    private val useCases: Map<KClass<out com.alleslocker.backend.application.common.InputBoundary<*, *>>, com.alleslocker.backend.application.common.InputBoundary<*, *>> =
        mapOf(
            _root_ide_package_.com.alleslocker.backend.application.task.usecase.GetTaskUseCase::class to _root_ide_package_.com.alleslocker.backend.application.task.usecase.GetTaskUseCaseImpl(),
            _root_ide_package_.com.alleslocker.backend.application.user.usecase.RegisterUserUseCase::class to _root_ide_package_.com.alleslocker.backend.application.user.usecase.RegisterUserUseCaseImpl(
                passwordHasher = passwordHasher,
                userGateway = gatewayFactory[_root_ide_package_.com.alleslocker.backend.application.user.gateway.UserGateway::class]
            ),
            _root_ide_package_.com.alleslocker.backend.application.user.usecase.LoginUserUseCase::class to _root_ide_package_.com.alleslocker.backend.application.user.usecase.LoginUserUseCaseImpl(
                passwordHasher = passwordHasher,
                userGateway = gatewayFactory[_root_ide_package_.com.alleslocker.backend.application.user.gateway.UserGateway::class]
            )
        )

    override fun <RQ, RS, I : com.alleslocker.backend.application.common.InputBoundary<RQ, RS>> make(inputBoundary: KClass<out I>): I {
        @Suppress("UNCHECKED_CAST")
        return useCases[inputBoundary] as I
    }
}