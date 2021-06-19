package com.example.plantapp.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PlantDao {
    @Query("SELECT * FROM plant")
    fun getAll(): LiveData<List<Plant>>

    @Query("SELECT * FROM plant WHERE uid IS :id LIMIT 1")
    fun findById(id: Int): Plant

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg plants: Plant)

    @Delete
    fun delete(plant: Plant)
}