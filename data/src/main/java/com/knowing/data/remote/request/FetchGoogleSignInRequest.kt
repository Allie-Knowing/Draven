package com.knowing.data.remote.request

data class FetchGoogleSignInRequest(
    val name: String,
    val email: String,
    val picture: String?
)
