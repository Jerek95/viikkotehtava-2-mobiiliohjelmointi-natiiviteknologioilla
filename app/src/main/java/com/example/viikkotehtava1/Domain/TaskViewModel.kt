package com.example.viikkotehtava1.Domain


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class TaskViewModel : ViewModel() {
    //private val _tasks = mutableStateOf(listOf<Task>())
    //val tasks: List<Task> = _tasks

    var tasks by mutableStateOf(listOf<Task>())

    init {
        tasks = listOf<Task>(
            Task(1, "kauppa", "käy kaupassa", 1, "25-01-13", false),
            Task(2, "siivoa", "imuroi lattiat", 2, "25-01-20", false),
            Task(3, "lenkki", "käy lenkillä", 3, "25-01-14", false),
            Task(4, "pyykit", "pese pyykit", 4, "25-01-18", false),
            Task(5, "ruoka", "tee ruokaa", 5, "25-01-12", false)
        )
    }

    fun addTask(task: Task) : List<Task>{
        tasks = tasks + task
        return tasks + task
    }

    fun toggleDone(id: Int) : List<Task>{
        tasks.forEach { it ->
            if (it.id == id){
                it.done = true
            }
        }
        return tasks
    }

    fun filterByDone(done: Boolean) : List<Task>{
        tasks = tasks.filter { !it.done }
        return tasks
    }

    fun sortByDueDate() : List<Task>{
        tasks = tasks.sortedBy { it.dueDate }
        return tasks
    }

    fun reset() : List<Task>{
        tasks = tasks.sortedBy { it.id }
        return tasks
    }
}
