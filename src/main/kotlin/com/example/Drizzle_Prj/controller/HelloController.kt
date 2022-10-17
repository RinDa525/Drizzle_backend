package com.example.Drizzle_Prj.controller

import com.example.Drizzle_Prj.common.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
//@RestController : 스프링에서 HTTP의 호출의 응답으로 뷰를 렌더링하지 않고
// HTTP의 본문에 직접 텍스트로 이루어진 데이터를 쓴다는 것을 나타님
@RestController

class HelloController {
    //@GetMapping : http의 get 메서드를 통해 해당 함수를 실행하면 이 반환값을 응답으로 돌려준다는 의미
    @GetMapping("/api/v1/hello")
    fun hello()=ApiResponse.ok("world")
}