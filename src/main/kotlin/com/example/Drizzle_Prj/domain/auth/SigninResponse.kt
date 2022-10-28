package com.example.Drizzle_Prj.domain.auth

data class SigninResponse(
    val token: String, //응답
    val refreshToken: String, //응답
    val userName: String,
    val userId: Long
    )


