package com.example.aptoide_tech_challenge.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.aptoide_tech_challenge.data.entities.Model

@Dao
interface AppDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllApps(result:List<Model>)

    @Query("SELECT * FROM Apps_Result")
    fun getAllApp(): LiveData<List<Model>>
}