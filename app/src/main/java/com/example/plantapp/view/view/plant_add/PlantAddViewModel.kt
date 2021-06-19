package com.example.plantapp.view.view.plant_add

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.plantapp.data.Plant
import com.example.plantapp.data.PlantManager
import com.example.plantapp.data.Task
import com.example.plantapp.data.TaskManager
import com.example.plantapp.view.view.tasks.TaskType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class PlantAddViewModel @Inject internal constructor(val plantManager: PlantManager, val taskManager: TaskManager): ViewModel() {

    var currentState = mutableStateOf(AddPlantState())

    fun save() {
        if(currentState.value.isValid()) {
            plantManager.addPlant(currentState.value.toPlant())
            taskManager.addTask(currentState.value.toTask())
        }
    }

    fun updateState(state: AddPlantState) {
        currentState.value = state
    }
}

data class AddPlantState(
    val name: String? = null,
    val description: String? = null,
    val reminder: TaskType = TaskType.WATER,
    val weeks: Int = 0,
    val days: Int = 0
)

fun AddPlantState.isValid() = !this.name.isNullOrBlank()
fun AddPlantState.toPlant() = Plant(
    uid = Random.nextInt(),
    name = this.name!!,
    description = this.description
)
fun AddPlantState.toTask() = Task(
    uid = Random.nextInt(),
    plantId = 0,
    plantName = this.name!!,
    taskType = this.reminder,
    weeks = this.weeks.toInt(),
    days = this.days.toInt()
    )