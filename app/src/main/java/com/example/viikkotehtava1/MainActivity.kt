package com.example.viikkotehtava1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.viikkotehtava1.Domain.Task
import com.example.viikkotehtava1.ui.theme.Viikkotehtava1Theme
import com.example.viikkotehtava1.Domain.addTask
import com.example.viikkotehtava1.Domain.filterByDone
import com.example.viikkotehtava1.Domain.sortByDueDate
import com.example.viikkotehtava1.Domain.tasks
import com.example.viikkotehtava1.Domain.toggleDone

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Viikkotehtava1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TODO(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun TODO(modifier: Modifier = Modifier){
    val TaskList by remember { mutableStateOf(tasks) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.width(8.dp))
        TaskList.forEach {
            Text("${it.id} : ${it.title} (${it.dueDate})")
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = {
                val newTask = Task(
                    id = tasks.size + 1,
                    title = "new task",
                    description = "new task",
                    priority = 1,
                    dueDate = "2025-01-15",
                    done = false
                )
                addTask(TaskList, newTask) }) {
                Text("Add Task")
            }
            Button(onClick = {
                var id = 1
                toggleDone(TaskList, id) }) {
                Text("Toggle Done")
            }
            Button(onClick = { filterByDone(TaskList, true) }) {
                Text("Filter By Done")
            }
            Button(onClick = { sortByDueDate(TaskList) }) {
                Text("Sort By Due Date")
            }
        }
    }
}
