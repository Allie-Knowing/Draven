package com.knowing.data.datasource

import com.knowing.data.remote.api.AuthAPI
import com.knowing.data.remote.response.FetchGoogleSignInResponse
import com.knowing.domain.base.ErrorHandler
import javax.inject.Inject

class AuthDataSourceImpl @Inject constructor(
    private val api: AuthAPI,
    private val errorHandler: ErrorHandler
): AuthDataSource {
    override suspend fun fetchGoogleSignIn(body: HashMap<String, String>): FetchGoogleSignInResponse =
        errorHandler { api.fetchGoogleSignIn(body) }
}