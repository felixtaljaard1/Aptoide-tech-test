package com.example.aptoide_tech_challenge.data.di

import android.content.Context
import com.example.aptoide_tech_challenge.data.local.AppDAO
import com.example.aptoide_tech_challenge.data.local.AppsLocalDatabase
import com.example.aptoide_tech_challenge.data.remote.AppRemoteDataSource
import com.example.aptoide_tech_challenge.data.remote.AppService
import com.example.aptoide_tech_challenge.domain.repository.AppRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("http://ws2.aptoide.com/api/6/bulkRequest/api_list/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideAppService(retrofit: Retrofit): AppService =
        retrofit.create(AppService::class.java)

    @Singleton
    @Provides
    fun provideAppRemoteDatabase(appService: AppService) =
        AppRemoteDataSource(appService)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        AppsLocalDatabase.getAppDatabase(appContext)

    @Singleton
    @Provides
    fun provideAppDAO(appDatabase: AppsLocalDatabase) = appDatabase.appDAO()

    @Singleton
    @Provides
    fun provideRepository(
        remoteDataSource: AppRemoteDataSource,
        localDataSource: AppDAO
    ) = AppRepository(remoteDataSource,localDataSource)
}