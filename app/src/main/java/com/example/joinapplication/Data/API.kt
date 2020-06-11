package com.example.joinapplication.Data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface API {
    @POST("/hub/schoolInfo?Key=c329b214f9dd45f88f52dbf42c638f36&Type=json&pIndex=1&pSize=1000&ATPT_OFCDC_SC_CODE=B10&HS_SC_NM=고등학교")
    fun getSchool(@Query("SCHUL_NM") Search:String): Call<infoFirst>
}