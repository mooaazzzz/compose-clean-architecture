package com.jkdigitals.jkdigitaljetpackcompose.data.remote.dto

import com.jkdigitals.jkdigitaljetpackcompose.domain.model.SignInResponse

data class SignInResponseDto(
    val token: String,
    val success: Boolean,
    val message: String,
    val user: User,
    val states: States,
    val jumio: Jumio
)

data class User(
    val _id: String,
    val email: String,
    val username: String,
    val role: String,
    val status: String,
    val gems: Int,
    val phone: String,
    val dateofbirth: String,
    val userip: String,
    val isPlaying: Boolean,
    val isOnline: Boolean,
    val isFlag: Boolean,
    val isReadInstructions: Boolean,
    val suspicious: Boolean,
    val KYCStatus: String,
    val invitedBy: String,
    val inviteCode: String,
    val createdAt: String,
    val updatedAt: String
)

data class States(
    val city: String,
    val region: String,
    val country: String,
    val loc: String,
    val postal: String,
    val timezone: String
)

data class Jumio(
    val attempts: Boolean,
    val message: String
)

fun SignInResponseDto.toSignInResponse(): SignInResponse {
    return SignInResponse(
        token = token,
        success = success,
        message = message,
        user = user,
        jumio = jumio
    )
}
