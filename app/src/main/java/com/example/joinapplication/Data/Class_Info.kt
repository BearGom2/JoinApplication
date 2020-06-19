package com.example.joinapplication.Data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class classInfo(
    @SerializedName("classInfo")
    @Expose
    val schoolList:List<RowList>
)

data class RowList(
    @SerializedName("row")
    @Expose
    val schoolInfo:List<ClassRow>
)

data class ClassRow(
    @SerializedName("SCHUL_NM")
    @Expose
    val SchoolName: String,
    @SerializedName("GRADE")
    @Expose
    val grade: String,
    @SerializedName("DDDEP_NM")
    @Expose
    val departmentName: String,
    @SerializedName("CLASS_NM")
    @Expose
    val classNum: String
)