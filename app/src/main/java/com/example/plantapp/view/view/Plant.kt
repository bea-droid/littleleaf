package com.example.plantapp.view.view

data class Plant(
    val name: String,
    val description: String,
    val imageResource: Int,
    var isChecked: Boolean = false
)