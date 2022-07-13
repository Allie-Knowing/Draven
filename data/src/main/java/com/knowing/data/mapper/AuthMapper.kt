package com.knowing.data.mapper

import com.knowing.data.remote.response.FetchGoogleSignInResponse
import com.knowing.domain.entity.auth.FetchGoogleSignInResponseEntity
import com.knowing.domain.entity.auth.FetchGoogleSignInResponseEntity.GoogleSignInEntity

object AuthMapper {
    fun mapperToFetchGoogleLoginEntity(fetchGoogleSignInResponse: FetchGoogleSignInResponse):
            FetchGoogleSignInResponseEntity {
        val data = fetchGoogleSignInResponse.data
        val googleSignInEntity = GoogleSignInEntity(
            data.access_token,
            data.refresh_token,
            data.is_first_login
        )
        return fetchGoogleSignInResponse.run {
            FetchGoogleSignInResponseEntity(
                googleSignInEntity
            )
        }
    }
}