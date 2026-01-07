package com.example.noteq

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.noteq.ui.theme.AppTheme
import com.example.noteq.ui.screens.NoteListScreen
import com.example.noteq.ui.screens.NoteEditScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                AppContent()
            }
        }
    }
}

@Composable
fun AppContent() {
    val navController = rememberNavController()
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        NavHost(navController = navController, startDestination = "list") {
            composable("list") {
                NoteListScreen(onAddNote = { navController.navigate("edit") },
                    onEditNote = { noteId -> navController.navigate("edit/" + noteId) })
            }
            composable("edit/{noteId}") { backStackEntry ->
                val noteId = backStackEntry.arguments?.getString("noteId")?.toLongOrNull()
                NoteEditScreen(noteId = noteId, onNavigateBack = { navController.popBackStack() })
            }
            composable("edit") {
                NoteEditScreen(noteId = null, onNavigateBack = { navController.popBackStack() })
            }
        }
    }
}
