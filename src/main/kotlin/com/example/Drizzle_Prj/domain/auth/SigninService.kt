package com.example.Drizzle_Prj.domain.auth

import com.example.Drizzle_Prj.common.DrizzleException
import com.example.Drizzle_Prj.domain.user.User
import com.example.Drizzle_Prj.domain.user.UserRepository

import org.mindrot.jbcrypt.BCrypt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.IllegalFormatException
import javax.management.loading.UserRepository

@Service
class SighinService @Autowired constructor(
    private val userRepository: UserRepository
) {

    //1
    fun signin(signinRequest: SigninRequest): SigninResponse {
        val user = userRepository
            .findMyEmail(signinRequest.email.toLowerCase())
            ?: throw DrizzleException("로그인 정보를 확인해주세요.")

        if (isNotVaildPassword(signinRequest.password, user.password)) {
            throw DrizzleException("로그인 정보를 확인해주세요.")
        }

        return responseWithTokens(user)
    }

    //2
    private fun isNotVaildPassword(
        plain: String,
        hashed: String
    ) = BCrypt.checkpw(plain, hashed).not()

    private fun responseWithTokens(user: User) = user.id?.let { userID ->
        SigninResponse(
            JWTUtil.createToken(user.email),
            JWTUtil.createRefreshToken(user.email),
            user.name,
            userId
        )
    } ?: throw IllegalArgumentException	("user.id 없음.")
}




