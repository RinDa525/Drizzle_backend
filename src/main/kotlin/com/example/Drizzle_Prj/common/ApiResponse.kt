package com.example.Drizzle_Prj.common

//통일된 Api 스펙을 만들기 위해 응답 데이터의 형태를 성공여부, 메시지, 그리고 데이터를 가지는 것으로 정의한다
//ok(), error() 정적함수 정의. ex)ApiResponse.ok(data)
data class ApiResponse(
    val success:Boolean,
    val data:Any? =null,
    val message:String? =null
){
    companion object{
        fun ok(data: Any?=null)=ApiResponse(true,data)
        fun error(message: String? =null)=
            ApiResponse(false,message=message)
    }
}
