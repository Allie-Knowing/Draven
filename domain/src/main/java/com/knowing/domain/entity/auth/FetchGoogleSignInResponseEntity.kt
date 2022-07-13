package com.knowing.domain.entity.auth

data class FetchGoogleSignInResponseEntity(
    val data: GoogleSignInEntity
){
    data class GoogleSignInEntity(
        val access_token: String,
        val refresh_token: String,
        val is_first_login: Boolean
    )
}
