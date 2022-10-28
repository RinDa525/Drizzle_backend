package com.example.Drizzle_Prj.domain.auth

data class SignupRequest(
    val email:String,
    val name:String,
    val password:String
)
