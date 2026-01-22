package com.example.viikkotehtava1.Domain

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(modifier: Modifier = Modifier, viewModel: TaskViewModel = viewModel()){

    val taskList: List<Task> = viewModel.tasks

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(1){
            taskList.forEach { task ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(checked = task.done, onCheckedChange = {task.done = !task.done})
                    Text(task.title)
                    Button(
                        onClick = {} //taskList.remove(task)
                    )
                    { Text("Delete") }
                }

            }

            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                var text by remember { mutableStateOf("") }
                TextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Enter name") }
                )
                Button(
                    onClick = {viewModel.addTask(
                        Task(viewModel.tasks.size + 1, text, text, 1, "", false)
                    )}
                )
                { Text("Add Task")}
                Button(onClick = { viewModel.filterByDone(false) }) {
                    Text("Filter By Done")
                }
                Button(onClick = { viewModel.sortByDueDate() }) {
                    Text("Sort By Due Date")
                }
                Button(onClick = { viewModel.reset() }) {
                    Text("Reset")
                }
            }
        }
    }

}