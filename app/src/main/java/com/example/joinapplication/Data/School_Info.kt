package com.example.joinapplication.Data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class infoFirst(
    @SerializedName("schoolInfo")
    @Expose
    val schoolList:List<SchoolInfo>
)

data class SchoolInfo(
    @SerializedName("row")
    @Expose
    val schoolInfo:List<Row>
)

data class Row(
    @SerializedName("SCHUL_KND_SC_NM")
    @Expose
    val SchoolType: String,
    @SerializedName("ORG_RDNMA")
    @Expose
    val address: String,
    @SerializedName("SD_SCHUL_CODE")
    @Expose
    val SchoolCode: String,
    @SerializedName("SCHUL_NM")
    @Expose
    val SchoolName: String,
    @SerializedName("ENG_SCHUL_NM")
    @Expose
    val engSchoolName: String
    )


