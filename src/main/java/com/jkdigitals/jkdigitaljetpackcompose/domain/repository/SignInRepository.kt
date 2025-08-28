package com.jkdigitals.jkdigitaljetpackcompose.domain.repository

import com.jkdigitals.jkdigitaljetpackcompose.data.remote.dto.SignInResponseDto
import com.jkdigitals.jkdigitaljetpackcompose.domain.model.SignInRequest

interface SignInRepository {
    suspend fun signInUser(request: SignInRequest): SignInResponseDto
}