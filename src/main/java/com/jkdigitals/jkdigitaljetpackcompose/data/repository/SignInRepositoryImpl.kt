package com.jkdigitals.jkdigitaljetpackcompose.data.repository

import com.jkdigitals.jkdigitaljetpackcompose.data.remote.JkDigitalAPI
import com.jkdigitals.jkdigitaljetpackcompose.data.remote.dto.SignInResponseDto
import com.jkdigitals.jkdigitaljetpackcompose.domian.model.SignInRequest
import com.jkdigitals.jkdigitaljetpackcompose.domian.repository.SignInRepository
import javax.inject.Inject

class SignInRepositoryImpl @Inject constructor(
    private val api: JkDigitalAPI
) : SignInRepository {
    override suspend fun signInUser(request: SignInRequest): SignInResponseDto {
        return api.signInUser(request = request)
    }
}