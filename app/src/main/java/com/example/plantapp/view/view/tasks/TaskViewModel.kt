package com.example.plantapp.view.view.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.plantapp.data.TaskManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject internal constructor(val taskManager: TaskManager): ViewModel() {
    val tasks: LiveData<List<TaskModel>> = taskManager.getTasks()
}