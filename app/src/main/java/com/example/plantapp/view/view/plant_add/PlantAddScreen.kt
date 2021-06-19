package com.example.plantapp.view.view.plant_add

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.plantapp.R
import com.example.plantapp.data.Plant
import com.example.plantapp.view.view.plant.PlantViewModel
import com.example.plantapp.view.view.tasks.TaskType
import java.util.*
import kotlin.random.Random

@Composable
fun PlantAddScreen(plantViewModel: PlantAddViewModel = viewModel()) {
    var plantName by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    Column(modifier = Modifier.padding(16.dp).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Plant Name: ",
                fontWeight = FontWeight.Bold)
            OutlinedTextField(value = plantName, onValueChange = {
                plantViewModel.currentState.value = plantViewModel.currentState.value.copy(name = it)
                plantName = it
            })

            Text(
                text = "Plant Description: ",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp)
            )
            OutlinedTextField(value = description, onValueChange = {
                plantViewModel.currentState.value = plantViewModel.currentState.value.copy(description = it)
                description = it })

            Text(
                text = "Remind me to: ",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp)
            )
            NotificationSelector(listOf(TaskType.WATER.name, TaskType.FERTILIZE.name)) { plantViewModel.currentState.value = plantViewModel.currentState.value.copy(reminder = TaskType.valueOf(it))}
        Text(
            text = "every",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
        NotificationSelector(listOf("1", "2", "3", "4")) { plantViewModel.currentState.value = plantViewModel.currentState.value.copy(weeks = it.toInt())}

        Text(
            text = "weeks",
            modifier = Modifier.padding(bottom = 16.dp)
        )

        NotificationSelector(listOf("1", "2", "3", "4", "5", "6")) { plantViewModel.currentState.value = plantViewModel.currentState.value.copy(days = it.toInt())}

        Text(
            text = "days"
        )

        Button(
            onClick = {
                plantViewModel.save()
            }) {
            Text(text = "Save")
        }
    }
}

@Composable
fun NotificationSelector(
    options: List<String>,
    onSelection: (String) -> Unit
) {
    var selectedIndex by remember { mutableStateOf(0) }

    Row() {
        options.forEachIndexed { index, s ->
            Button(
                onClick = {
                    selectedIndex = index
                    onSelection(options[selectedIndex])
                },
                shape = RoundedCornerShape(50),
                modifier = Modifier.padding(2.dp),
                border = if(selectedIndex == index) BorderStroke(1.dp, Color.Black) else BorderStroke(1.dp, Color.Gray)
            ) {
                Text(
                    text = s,
                    fontWeight = if (selectedIndex == index) FontWeight.Bold else FontWeight.Normal,
                    color = if(selectedIndex == index) Color.Black else Color.Gray
                )
            }
        }
    }
}