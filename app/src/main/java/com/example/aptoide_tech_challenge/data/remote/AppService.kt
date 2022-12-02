package com.example.aptoide_tech_challenge.data.remote

import com.example.aptoide_tech_challenge.data.entities.DataModel
import com.example.aptoide_tech_challenge.data.entities.ResponsesModel
import retrofit2.Response
import retrofit2.http.GET

interface AppService {
    @GET("listApps")
    suspend fun getAllApps(): Response<DataModel>
}