package com.example.joinapplication.Data

import retrofit2.Call
import retrofit2.http.*

interface API {
    @POST("/hub/schoolInfo?Key=c329b214f9dd45f88f52dbf42c638f36&Type=json&pIndex=1&pSize=1000&ATPT_OFCDC_SC_CODE=B10&SCHUL_KND_SC_NM=고등학교")
    fun getSchool(@Query("SCHUL_NM") Search:String): Call<infoFirst>
    @POST("/hub/classInfo?Key=c329b214f9dd45f88f52dbf42c638f36&Type=json&pIndex=1&pSize=100&ATPT_OFCDC_SC_CODE=B10&AY=2020")
    fun getDepartment(@Query("SD_SCHUL_CODE") Code:String): Call<classInfo>

    @POST("/user/login")
    @FormUrlEncoded
    fun getLogin(@Field("id") id : String, @Field("password") pw : String): Call<Void>
    @POST("/user/join")
    @FormUrlEncoded
    fun SignUp(@Field("id") id : String, @Field("password") pw : String): Call<Void>
}