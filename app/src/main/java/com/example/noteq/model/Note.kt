package com.example.noteq.model

data class Note(
    val id: Long = 0L,
    val title: String = "",
    val content: String = "",
    val timestamp: Long = System.currentTimeMillis()
)
