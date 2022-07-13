package com.knowing.data.repository

import com.knowing.data.datasource.AuthDataSource
import com.knowing.domain.entity.auth.FetchGoogleSignInResponseEntity
import com.knowing.domain.repository.AuthRepository
import com.knowing.data.mapper.AuthMapper.mapperToFetchGoogleLoginEntity
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource
): AuthRepository {
    override suspend fun fetchGoogleSignIn(body: HashMap<String, String>): FetchGoogleSignInResponseEntity =
        mapperToFetchGoogleLoginEntity(authDataSource.fetchGoogleSignIn(body))
}