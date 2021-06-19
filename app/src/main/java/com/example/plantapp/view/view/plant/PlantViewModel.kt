package com.example.plantapp.view.view.plant

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.plantapp.R
import com.example.plantapp.data.PlantManager
import com.example.plantapp.view.view.Plant
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlantViewModel @Inject internal constructor(val plantManager: PlantManager): ViewModel() {
    val plants: LiveData<List<Plant>> = Transformations.map(plantManager.getPlants()) {
        list ->
        list.map {  plant ->
            Plant(
                name = plant.name,
                description = plant.description ?: "",
                imageResource = R.drawable.monst
            )
        }
    }
}