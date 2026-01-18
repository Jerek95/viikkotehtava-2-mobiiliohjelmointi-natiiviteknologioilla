package com.example.viikkotehtava1.Domain

data class Task(val id: Int, var title: String, var description: String, var priority: Int, var dueDate: String, var done: Boolean)