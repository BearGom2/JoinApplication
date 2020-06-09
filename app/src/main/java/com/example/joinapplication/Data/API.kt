package com.example.joinapplication.Data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface API {
    @GET("/hub/schoolInfo?Key=c329b214f9dd45f88f52dbf42c638f36&Type=json&pIndex=1&pSize=1000&ATPT_OFCDC_SC_CODE=B10&SCHUL_NM=서울&SCHUL_KND_SC_NM=고등학교")
    fun getSchool(): Call<infoFirst>

    @GET("/hub/schoolInfo?Key=c329b214f9dd45f88f52dbf42c638f36&Type=json&pIndex=1&pSize=1000&ATPT_OFCDC_SC_CODE=B10&SCHUL_NM=서울&SCHUL_KND_SC_NM=고등학교")
    fun getinfo(): Call<List<Row>>

    @GET("/hub/classInfo?Key=c329b214f9dd45f88f52dbf42c638f36&Type=json&pIndex=1&pSize=1000&ATPT_OFCDC_SC_CODE=B10&SD_SCHUL_CODE=7010911&AY=2020")
    fun getClass(): Call<List<Class_Info>>
}