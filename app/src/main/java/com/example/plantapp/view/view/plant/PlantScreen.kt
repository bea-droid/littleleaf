package view

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.plantapp.PlantRow
import com.example.plantapp.view.view.plant.PlantViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import androidx.navigation.compose.navigate


@Composable
fun PlantScreen(navController: NavController, plantViewModel: PlantViewModel) {
    val context = LocalContext.current
    val plantList by plantViewModel.plants.observeAsState(emptyList())
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(com.example.plantapp.view.navigation.BottomNavigationScreens.PlantAdd.route) })
            { Icon(imageVector = Icons.Filled.Add, contentDescription = "Add") }
        },
        floatingActionButtonPosition = FabPosition.End) {
        Column() {
            Text(
                text = "My plants",
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp, start = 8.dp, end = 8.dp),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h6
            )
            LazyColumn {

                items(plantList) { plant ->
                    PlantRow(
                        plant = plant,
                        onPlantClick = {
                            Toast.makeText(
                                context,
                                "You clicked a plant",
                                Toast.LENGTH_LONG
                            ).show()
                        })
                    Divider()
                }
            }
        }
    }
}