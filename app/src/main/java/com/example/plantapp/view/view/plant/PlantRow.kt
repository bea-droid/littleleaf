package com.example.plantapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.plantapp.view.view.Plant

@Composable
fun PlantRow(plant: Plant, onPlantClick: (Plant) -> Unit) {
    Row(modifier = Modifier.clickable(onClick = { onPlantClick(plant) })
        .fillMaxWidth()
        .padding(start = 16.dp, bottom = 8.dp, top = 8.dp, end = 16.dp)) {
        val imageModifier = Modifier.size(75.dp).fillMaxHeight().clip(shape = RoundedCornerShape(15))

        Image(
            painter = painterResource(plant.imageResource),
            contentDescription = null,
            modifier = imageModifier
        )

        Column(modifier = Modifier.padding(start = 16.dp).align(Alignment.CenterVertically)) {
            Text(text = plant.name,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.body1)
            Text(text = plant.description,
                style = MaterialTheme.typography.body1)
        }
    }
}