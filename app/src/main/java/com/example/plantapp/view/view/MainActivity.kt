package com.example.plantapp.view.view

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import ui.PlantappTheme
import androidx.navigation.compose.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlantappTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PlantappTheme {
        MainScreen()
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    val bottomNavItems = listOf(
            com.example.plantapp.view.navigation.BottomNavigationScreens.Plants,
            com.example.plantapp.view.navigation.BottomNavigationScreens.Tasks
    )

    Scaffold(
        bottomBar = {
            BloomBottomNav(navController = navController, items = bottomNavItems)
        })
    { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            com.example.plantapp.view.navigation.MainScreenNavigationConfigurations(navController)
        }
    }
}

@Composable
private fun BloomBottomNav(
        navController: NavHostController,
        items: List<com.example.plantapp.view.navigation.BottomNavigationScreens>
) {
    BottomNavigation {
        val currentRoute = com.example.plantapp.view.navigation.currentRoute(navController)
        items.forEach { screen ->
            BottomNavigationItem(
                    icon = {  },
                    label = { Text(stringResource(id = screen.resourceId), color = MaterialTheme.colors.onSecondary) },
                    selected = currentRoute == screen.route,
                    onClick = {
                        // This if check gives us a "singleTop" behavior where we do not create a
                        // second instance of the composable if we are already on that destination
                        if (currentRoute != screen.route) {
                            navController.navigate(screen.route)
                        }
                    }
            )
        }
    }
}