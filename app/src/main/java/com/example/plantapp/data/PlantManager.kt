package com.example.plantapp.data

import android.os.AsyncTask
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.room.Room
import java.util.concurrent.Executors
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlantManager @Inject constructor(private val plantDao: PlantDao) {
    fun getPlants(): LiveData<List<Plant>> = plantDao.getAll()

    fun getPlant(id: Int): Plant = plantDao.findById(id)

    fun addPlant(plant: Plant) {
        Executors.newSingleThreadExecutor().execute {
            plantDao.insertAll(plant)
        }
    }

    fun deletePlant(plant: Plant) = plantDao.delete(plant)
}