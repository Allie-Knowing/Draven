package com.knowing.data.datasource

import com.knowing.data.remote.response.FetchGoogleSignInResponse

interface AuthDataSource {
    suspend fun fetchGoogleSignIn(body: HashMap<String, String>): FetchGoogleSignInResponse
}