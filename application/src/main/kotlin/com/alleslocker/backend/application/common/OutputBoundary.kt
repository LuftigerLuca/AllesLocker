package com.alleslocker.backend.application.common

interface OutputBoundary<R> {
    fun present(response: Response<R>)
}