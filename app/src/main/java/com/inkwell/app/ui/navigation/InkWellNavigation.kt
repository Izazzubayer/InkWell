package com.inkwell.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.inkwell.app.ui.screen.notes.NotesListScreen
import com.inkwell.app.ui.screen.notes.NoteEditorScreen

@Composable
fun InkWellNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "notes_list",
        modifier = modifier
    ) {
        composable("notes_list") {
            NotesListScreen(
                onNoteClick = { noteId ->
                    navController.navigate("note_editor/$noteId")
                },
                onNewNoteClick = {
                    navController.navigate("note_editor/new")
                }
            )
        }
        
        composable("note_editor/{noteId}") { backStackEntry ->
            val noteId = backStackEntry.arguments?.getString("noteId") ?: "new"
            NoteEditorScreen(
                noteId = noteId,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
