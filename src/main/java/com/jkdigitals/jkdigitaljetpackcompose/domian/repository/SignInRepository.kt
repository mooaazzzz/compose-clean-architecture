package com.jkdigitals.jkdigitaljetpackcompose.domian.repository

import com.jkdigitals.jkdigitaljetpackcompose.data.remote.dto.SignInResponseDto
import com.jkdigitals.jkdigitaljetpackcompose.domian.model.SignInRequest

interface SignInRepository {
    suspend fun signInUser(request: SignInRequest): SignInResponseDto
}