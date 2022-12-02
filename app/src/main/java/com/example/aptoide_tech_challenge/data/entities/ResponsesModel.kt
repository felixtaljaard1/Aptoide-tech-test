package com.example.aptoide_tech_challenge.data.entities


import com.google.gson.annotations.SerializedName

data class ResponsesModel(
    @SerializedName("listApps")
    val listApps: ListAppsModel = ListAppsModel()
)