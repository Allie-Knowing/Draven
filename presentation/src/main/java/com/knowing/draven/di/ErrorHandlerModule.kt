package com.knowing.draven.di

import com.knowing.data.base.ErrorHandlerImpl
import com.knowing.domain.base.ErrorHandler
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ErrorHandlerModule {
    @Binds
    abstract fun provideErrorHandler(
        errorHandlerImpl: ErrorHandlerImpl
    ): ErrorHandler
}