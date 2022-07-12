package com.knowing.data.remote.api

import com.knowing.data.remote.request.FetchGoogleSignInRequest
import com.knowing.data.remote.response.FetchGoogleSignInResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthAPI {
    @POST("/google")
    suspend fun fetchGoogleSignIn(
        @Body body: HashMap<String, String>
    ): FetchGoogleSignInResponse
}