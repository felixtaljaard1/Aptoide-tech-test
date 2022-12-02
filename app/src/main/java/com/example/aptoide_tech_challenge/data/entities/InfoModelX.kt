package com.example.aptoide_tech_challenge.data.entities


import com.google.gson.annotations.SerializedName

data class InfoModelX(
    @SerializedName("status")
    val status: String = "",
    @SerializedName("time")
    val time: TimeModel = TimeModel()
)