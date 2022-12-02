package com.example.aptoide_tech_challenge.data.entities


import com.google.gson.annotations.SerializedName

data class DatasetsModel(
    @SerializedName("all")
    val all: AllModel = AllModel()
)