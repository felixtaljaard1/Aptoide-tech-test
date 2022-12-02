package com.example.aptoide_tech_challenge.data.entities


import com.google.gson.annotations.SerializedName

data class TimeModel(
    @SerializedName("human")
    val human: String = "",
    @SerializedName("seconds")
    val seconds: Double = 0.0
)