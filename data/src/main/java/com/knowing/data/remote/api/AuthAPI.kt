package com.knowing.data.remote.api

import com.knowing.data.remote.request.GoogleLoginRequest
import com.knowing.data.remote.response.GoogleLoginResponse
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Url

interface AuthAPI {
    @POST("/google")
    suspend fun googleLogin(
        @Body body: GoogleLoginRequest
    ): GoogleLoginResponse

    @POST
    suspend fun fetchGoogleAuthInfo(
        @Url url: String
    )
}