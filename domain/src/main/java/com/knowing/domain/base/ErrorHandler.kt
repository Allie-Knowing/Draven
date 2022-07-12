package com.knowing.domain.base

interface ErrorHandler {
    suspend fun <T> invoke(func: suspend () -> T): T
}