package com.example.aptoide_tech_challenge.data.entities


import com.google.gson.annotations.SerializedName

data class ListAppsModel(
    @SerializedName("datasets")
    val datasets: DatasetsModel = DatasetsModel(),
    @SerializedName("info")
    val info: InfoModelX = InfoModelX()
)