package com.jkdigitals.jkdigitaljetpackcompose.data.remote

import com.jkdigitals.jkdigitaljetpackcompose.data.remote.dto.SignInResponseDto
import com.jkdigitals.jkdigitaljetpackcompose.domian.model.SignInRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface JkDigitalAPI {

    @POST("/api/v1/signin")
    suspend fun signInUser(@Body request: SignInRequest) : SignInResponseDto
}