package com.example.plantapp.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDao {
    @Query("SELECT * FROM task")
    fun getAll(): LiveData<List<Task>>

    @Query("SELECT * FROM task WHERE uid IS :id LIMIT 1")
    fun findById(id: Int): Task

    @Query("SELECT * FROM task WHERE plantId IS :id LIMIT 1")
    fun findByPlant(id: Int): Task

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg tasks: Task)

    @Delete
    fun delete(task: Task)
}