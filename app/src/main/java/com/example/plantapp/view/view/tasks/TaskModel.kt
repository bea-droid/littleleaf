package com.example.plantapp.view.view.tasks

import java.util.concurrent.TimeUnit

data class TaskModel(
    val plantName: String,
    val weeks: Int,
    val days: Int,
    val taskType: TaskType,
    val imageResource: Int,
    var isCompleted: Boolean = false,
    val notificationTime: TimeUnit? = null
)

enum class TaskType {
    WATER,
    FERTILIZE
}