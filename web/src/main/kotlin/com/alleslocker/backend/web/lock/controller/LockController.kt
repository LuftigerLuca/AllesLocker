package com.alleslocker.backend.web.lock.controller

import com.alleslocker.backend.application.common.factory.UseCaseFactory
import com.alleslocker.backend.application.lock.dto.request.CreateLockRequestDto
import com.alleslocker.backend.application.lock.usecase.CreateLockUseCase
import com.alleslocker.backend.web.lock.mapper.toDto
import com.alleslocker.backend.web.lock.presenter.CreateLockPresenter
import com.alleslocker.backend.web.lock.schema.request.CreateLockRequestSchema
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/lock")
class LockController(
    private val useCaseFactory: UseCaseFactory,
    private val httpServletResponse: HttpServletResponse,
    private val jacksonConverter: MappingJackson2HttpMessageConverter
) {
   @PostMapping("/create")
   fun create(@RequestBody request: CreateLockRequestSchema) {
       val presenter = CreateLockPresenter(httpServletResponse, jacksonConverter)
       useCaseFactory.make(CreateLockUseCase::class).execute(request.toDto(), presenter)
   }
}