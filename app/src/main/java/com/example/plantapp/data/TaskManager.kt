package com.example.plantapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.plantapp.R
import com.example.plantapp.view.view.tasks.TaskModel
import com.example.plantapp.view.view.tasks.TaskType
import java.util.concurrent.Executors
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskManager @Inject constructor(private val taskDao: TaskDao) {
    fun getTasks(): LiveData<List<TaskModel>> = Transformations.map(taskDao.getAll()) { tasks ->
        tasks.map { task ->
            TaskModel(
                plantName = task.plantName,
                weeks = task.weeks,
                days = task.days,
                taskType = task.taskType,
                imageResource = R.drawable.monst
            )
        }
    }

    fun getTask(id: Int): Task = taskDao.findById(id)

    fun addTask(task: Task) {
        Executors.newSingleThreadExecutor().execute {
            taskDao.insertAll(task)
        }
    }

    fun deleteTask(task: Task) = taskDao.delete(task)
}