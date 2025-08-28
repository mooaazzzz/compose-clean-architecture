package com.jkdigitals.jkdigitaljetpackcompose.domain.model

import com.jkdigitals.jkdigitaljetpackcompose.data.remote.dto.Jumio
import com.jkdigitals.jkdigitaljetpackcompose.data.remote.dto.User

data class SignInResponse(
    val token: String,
    val success: Boolean,
    val message: String,
    val user: User,
    val jumio: Jumio
)

