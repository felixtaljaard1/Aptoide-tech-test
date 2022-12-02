package com.example.aptoide_tech_challenge.data.entities


import com.google.gson.annotations.SerializedName

data class AppModel(
    @SerializedName("responses")
    val responses: ResponsesModel = ResponsesModel(),
    @SerializedName("status")
    val status: String = ""
)