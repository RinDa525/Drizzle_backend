package com.example.Drizzle_Prj.controller

import com.example.Drizzle_Prj.common.ApiResponse
import com.example.Drizzle_Prj.domain.auth.SignupRequest
import com.example.Drizzle_Prj.domain.auth.SignupService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class UserApiController @Autowired constructor(
    private val signupService: SignupService
) {
    //HTTP의 POST 메서드를 이용해 맵핑된 주소를 호출했을 때 함수가 동작함을 나타낸다.
    //데이터를 저장하는 API는 대부분 POST 메서드를 사용하도록 권장됨
    @PostMapping("/users")
    //@RequestBody는 데이터를 HTTP의 바디에서 읽는다는 것을 의미함 url에 따라붙는 쿼리스트링을 피하기 위함
    fun signup(@RequestBody signupRequest: SignupRequest)=
        ApiResponse.ok(signupService.signup(signupRequest))
}