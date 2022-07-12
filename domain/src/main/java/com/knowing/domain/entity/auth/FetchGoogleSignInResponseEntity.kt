package com.knowing.domain.entity.auth

data class FetchGoogleSignInResponseEntity(
    val access_token: String,
    val refresh_token: String,
    val is_first_login: Boolean
)
