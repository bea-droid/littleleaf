package com.example.plantapp.view.navigation

import androidx.annotation.StringRes
import com.example.plantapp.R

sealed class BottomNavigationScreens(val route: String, @StringRes val resourceId: Int) {
    object Plants : BottomNavigationScreens("Plants", R.string.plant_route)
    object Tasks : BottomNavigationScreens("Tasks", R.string.tasks_route)
    object PlantAdd : BottomNavigationScreens("PlantAdd", R.string.plant_add)
}