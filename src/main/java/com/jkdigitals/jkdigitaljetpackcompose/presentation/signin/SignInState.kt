package com.jkdigitals.jkdigitaljetpackcompose.presentation.signin

import com.jkdigitals.jkdigitaljetpackcompose.domain.model.SignInResponse

data class SignInState(
    val isLoading: Boolean = false,
    val error: String = "",
    val response : SignInResponse? = null,
)
