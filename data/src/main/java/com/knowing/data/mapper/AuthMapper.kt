package com.knowing.data.mapper

import com.knowing.data.remote.response.FetchGoogleSignInResponse
import com.knowing.domain.base.entity.auth.FetchGoogleSignInResponseEntity

object AuthMapper {
    fun mapperToFetchGoogleLoginEntity(fetchGoogleSignInResponse: FetchGoogleSignInResponse) =
        fetchGoogleSignInResponse.run {
            FetchGoogleSignInResponseEntity(
                access_token, refresh_token, is_first_login
            )
        }
}