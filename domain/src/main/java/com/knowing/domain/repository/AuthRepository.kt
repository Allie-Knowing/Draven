package com.knowing.domain.repository

import com.knowing.domain.entity.auth.FetchGoogleSignInResponseEntity

interface AuthRepository {
    suspend fun fetchGoogleSignIn(body: HashMap<String, String>): FetchGoogleSignInResponseEntity
}