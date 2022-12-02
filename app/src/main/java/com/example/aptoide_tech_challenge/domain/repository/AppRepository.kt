package com.example.aptoide_tech_challenge.domain.repository

import com.example.aptoide_tech_challenge.data.local.AppDAO
import com.example.aptoide_tech_challenge.data.remote.AppRemoteDataSource
import com.example.aptoide_tech_challenge.utils.performGetOperation
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val remoteDataSource: AppRemoteDataSource,
    private val localDataSource: AppDAO
){
    fun getAllApps() = performGetOperation(
        databaseQuery = { localDataSource.getAllApp()},
        networkCall = { remoteDataSource.getApps()},
        saveCallResult = { localDataSource.insertAllApps(it.list)}
    )
}