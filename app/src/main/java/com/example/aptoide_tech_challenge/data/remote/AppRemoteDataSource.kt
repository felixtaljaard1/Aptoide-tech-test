package com.example.aptoide_tech_challenge.data.remote

import javax.inject.Inject

class AppRemoteDataSource @Inject constructor(
    private val appService: AppService
): BaseDataSource(){
    suspend fun getApps() = getResult { appService.getAllApps() }
}