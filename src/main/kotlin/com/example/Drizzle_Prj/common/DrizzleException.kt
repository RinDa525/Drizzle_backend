package com.example.Drizzle_Prj.common

import java.lang.RuntimeException

//1. DrizzleException을 캐치해 익셉션의 메시지를 전파해줌
//2. DrizzleException 을 제외한 모든 예외를 캐치해 "알 수 없는 오류가 발생했습니다." 메세지 전파
class DrizzleException(message:String) :RuntimeException(message)