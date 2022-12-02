package com.example.aptoide_tech_challenge.data.entities


import com.google.gson.annotations.SerializedName

data class AllModel(
//    @SerializedName("data")
//    val `data`: DataModel = DataModel(),
    @SerializedName("info")
    val info: InfoModelX = InfoModelX()
)