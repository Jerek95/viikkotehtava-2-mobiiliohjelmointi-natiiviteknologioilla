package com.example.viikkotehtava1.Domain


import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel


class TaskViewModel : ViewModel() {
    private val _tasks = mutableStateListOf<Task>()
    val tasks: List<Task> = _tasks

    fun init() {
        _tasks + (Task(1, "kauppa", "käy kaupassa", 1, "25-01-13", false))
        _tasks + (Task(2, "siivoa", "imuroi lattiat", 2, "25-01-20", false))
        _tasks + (Task(3, "lenkki", "käy lenkillä", 3, "25-01-14", false))
        _tasks + (Task(4, "pyykit", "pese pyykit", 4, "25-01-18", false))
        _tasks + (Task(5, "ruoka", "tee ruokaa", 5, "25-01-12", false))
    }

    fun addTask(task: Task) : List<Task>{
        return _tasks + task
    }

    fun toggleDone(id: Int) : List<Task>{
        _tasks.forEach { it ->
            if (it.id == id){
                it.done = true
            }
        }
        return _tasks
    }

    fun filterByDone(done: Boolean) : List<Task>{
        val doneTasks = _tasks.filter { it.done }
        return doneTasks
    }

    fun sortByDueDate() : List<Task>{
        val byDueDate = _tasks.sortedBy { it.dueDate }
        return byDueDate
    }
}
