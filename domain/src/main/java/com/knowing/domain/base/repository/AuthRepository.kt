package com.knowing.domain.base.repository

import com.knowing.domain.base.entity.auth.FetchGoogleSignInResponseEntity

interface AuthRepository {
    suspend fun fetchGoogleSignIn(body: HashMap<String, String>): FetchGoogleSignInResponseEntity
}