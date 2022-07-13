package com.knowing.domain.usecase.auth

import com.knowing.domain.repository.AuthRepository
import javax.inject.Inject

class FetchGoogleSignInUseCase @Inject constructor(
    private val authRepository: AuthRepository
){
    suspend fun invoke(body: HashMap<String, String>) =
        authRepository.fetchGoogleSignIn(body)
}