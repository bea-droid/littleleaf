package com.example.plantapp.view.view.tasks

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.plantapp.R

@Composable
fun TaskRow(task: TaskModel, onTaskClick: (TaskModel) -> Unit) {
    val context = LocalContext.current
    Row(modifier = Modifier.clickable(onClick = { onTaskClick(task) })
        .fillMaxWidth()
        .padding(start = 16.dp, bottom = 8.dp, top = 8.dp, end = 16.dp)) {
        val imageModifier = Modifier.size(75.dp).fillMaxHeight().clip(shape = RoundedCornerShape(15))

        Image(
            painter = painterResource(task.imageResource),
            contentDescription = "Content description for visually impaired",
            modifier = imageModifier
        )

        Column(modifier = Modifier.padding(start = 16.dp).align(Alignment.CenterVertically)) {
            Text(text = context.getString(R.string.fertilze_notification, task.plantName),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.body1)
            Text(text = context.getString(R.string.reoccur_label, task.weeks, task.days),
                style = MaterialTheme.typography.body1)
        }
        Checkbox(checked = task.isCompleted, onCheckedChange = {
            task.isCompleted = true },
            modifier = Modifier.align(Alignment.CenterVertically).padding(start = 100.dp))
    }
}