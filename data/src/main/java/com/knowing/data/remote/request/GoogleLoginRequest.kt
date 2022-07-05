package com.knowing.data.remote.request

data class GoogleLoginRequest(
    val name: String,
    val email: String,
    val picture: String?
)
