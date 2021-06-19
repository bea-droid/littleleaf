package com.example.plantapp.view.view.tasks

data class Task(
    val taskName: String,
    val dueDate: String,
    val imageResource: Int,
    var isCompleted: Boolean = false
)