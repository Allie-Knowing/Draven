package com.knowing.data.remote.response

data class GoogleLoginResponse(
    val access_token: String,
    val refresh_token: String,
    val is_first_login: Boolean
)
