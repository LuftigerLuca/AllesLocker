package com.alleslocker.backend.application.person.dto.request

data class AddPersonAdapterRequest (
    val id: String,
    val firstname: String,
    val lastname: String,
    val email: String,
)