package com.example.plantapp.view.view.tasks

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.plantapp.view.view.Theme
import com.example.plantapp.view.view.ThemeItem

@Composable
fun TaskScreen(roomList: List<Theme>, viewModel: TaskViewModel) {
    val context = LocalContext.current
    val taskList by viewModel.tasks.observeAsState(emptyList())
    Column() {
        Text(
            text = "My rooms",
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp, start = 8.dp, end = 8.dp),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h6
        )
        LazyRow() {
            items(roomList) { room ->
                ThemeItem(
                    theme = room,
                    onThemeClick = {
                        Toast.makeText(
                            context,
                            "You clicked a room",
                            Toast.LENGTH_LONG
                        ).show()
                    })
            }
        }
        Text(
            text = "Tasks",
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp, start = 8.dp, end = 8.dp),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h6 )
        LazyColumn {
            items(taskList) { task ->
                TaskRow(task = task, onTaskClick = { Toast.makeText(context, "You clicked a task", Toast.LENGTH_LONG).show() })
            }
        }
    }
}