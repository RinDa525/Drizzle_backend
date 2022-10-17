package com.example.Drizzle_Prj.common

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController

//@ControllerAdvice : 스프링에게 이 클래스가 전역적인 익셉션 핸들러임을 알려줌
@ControllerAdvice
@RestController

class DrizzleExceptionHandler {
    private val logger=LoggerFactory.getLogger(this::class.java)
    //@ExceptionHandler : 이 함수가 괄호안에 들어간 타입의 예외를 처리할 것임을 알려줌
    @ExceptionHandler(DrizzleException::class)
    fun handleDrizzleException(e:DrizzleException):ApiResponse{
        logger.error("API error", e)
        return ApiResponse.error(e.message)
    }

    @ExceptionHandler(Exception::class)
    fun handleException(e:Exception):ApiResponse{
        logger.error("API error",e)
        return ApiResponse.error("알 수 없는 오류가 발생했습니다. ")
    }

}