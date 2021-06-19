package com.example.plantapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.plantapp.view.view.tasks.TaskType

@Entity
data class Task(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "plantId") val plantId: Int,
    @ColumnInfo(name = "taskType") val taskType: TaskType,
    @ColumnInfo(name = "plantName") val plantName: String,
    @ColumnInfo(name = "weeks") val weeks: Int,
    @ColumnInfo(name = "days") val days: Int
)