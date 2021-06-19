package com.example.plantapp.view.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.plantapp.R
import com.example.plantapp.view.view.Theme
import com.example.plantapp.view.view.plant.PlantViewModel
import com.example.plantapp.view.view.plant_add.PlantAddScreen
import com.example.plantapp.view.view.tasks.Task
import com.example.plantapp.view.view.tasks.TaskScreen
import view.PlantScreen

@Composable
fun MainScreenNavigationConfigurations(
    navController: NavHostController
) {
    NavHost(navController, startDestination = BottomNavigationScreens.Plants.route) {
        composable(BottomNavigationScreens.Plants.route) {
            PlantScreen(navController = navController, plantViewModel = hiltNavGraphViewModel(it))
        }
        composable(BottomNavigationScreens.Tasks.route) {
            TaskScreen(taskList = listOf(
                Task(
                    taskName = "Water your Monstera",
                    dueDate = "Task Due: 2 Days Ago",
                    imageResource = R.drawable.monst
                ),
                Task(
                    taskName = "Repot your Peace lily",
                    dueDate = "Task Due: 1 Day",
                    imageResource = R.drawable.monst
                )
            ), roomList = listOf(
                Theme(
                    name = "Living room",
                    imageResource = R.drawable.succulents
                ),
                Theme(
                    name = "Bedroom",
                    imageResource = R.drawable.succs
                ),
                Theme(
                    name = "Kitchen",
                    imageResource = R.drawable.succs
                )
            ))
        }
        composable(BottomNavigationScreens.PlantAdd.route) {
            PlantAddScreen(plantViewModel = hiltNavGraphViewModel(it))
        }
    }
}


@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.arguments?.getString(KEY_ROUTE)
}