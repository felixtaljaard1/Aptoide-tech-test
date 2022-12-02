package com.example.aptoide_tech_challenge.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.aptoide_tech_challenge.data.entities.Model

@Database(entities = [Model::class], version = 2, exportSchema = false)
abstract class AppsLocalDatabase: RoomDatabase() {
    abstract fun appDAO(): AppDAO

    companion object {
        @Volatile
        private var INSTANCE: AppsLocalDatabase? = null

        fun getAppDatabase(context: Context): AppsLocalDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it}
             }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, AppsLocalDatabase::class.java, "AppDB2")
                .fallbackToDestructiveMigration()
                .build()
    }
}