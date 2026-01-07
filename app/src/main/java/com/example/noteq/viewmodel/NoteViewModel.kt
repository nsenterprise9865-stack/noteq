package com.example.noteq.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.noteq.model.Note

class NoteViewModel : ViewModel() {
    // In-memory list of notes; replace with a proper repository for persistence.
    private val _notes = mutableStateListOf<Note>()
    val notes: SnapshotStateList<Note> = _notes

    private var nextId = 1L

    fun addNote(title: String, content: String) {
        val note = Note(
            id = nextId++,
            title = title,
            content = content,
            timestamp = System.currentTimeMillis()
        )
        _notes.add(0, note) // add to top
    }

    fun updateNote(id: Long, title: String, content: String) {
        val index = _notes.indexOfFirst { it.id == id }
        if (index != -1) {
            _notes[index] = _notes[index].copy(title = title, content = content, timestamp = System.currentTimeMillis())
        }
    }

    fun getNoteById(id: Long): Note? = _notes.find { it.id == id }

    fun deleteNote(id: Long) {
        _notes.removeAll { it.id == id }
    }
}
