package com.example.plantapp.view.view.plant_add

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.plantapp.data.Plant
import com.example.plantapp.data.PlantManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class PlantAddViewModel @Inject internal constructor(val plantManager: PlantManager): ViewModel() {

    var currentState = mutableStateOf(AddPlantState())

    fun save() {
        if(currentState.value.isValid()) {
            plantManager.addPlant(currentState.value.toPlant())
        }
    }

    fun updateState(state: AddPlantState) {
        currentState.value = state
    }
}

data class AddPlantState(
    val name: String? = null,
    val description: String? = null,
    val reminder: String? = null,
    val weeks: String? = null,
    val days: String? = null
)

fun AddPlantState.isValid() = !this.name.isNullOrBlank()
fun AddPlantState.toPlant() = Plant(
    uid = Random.nextInt(),
    name = this.name!!,
    description = this.description
)