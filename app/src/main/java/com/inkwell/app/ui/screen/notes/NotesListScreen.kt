package com.inkwell.app.ui.screen.notes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesListScreen(
    onNoteClick: (String) -> Unit,
    onNewNoteClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("InkWell") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onNewNoteClick
            ) {
                Icon(Icons.Default.Add, contentDescription = "New Note")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Placeholder content - will be replaced with actual notes
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(5) { index ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { onNoteClick("note_$index") }
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = "Sample Note ${index + 1}",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "This is a sample note content. Tap to edit...",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
        }
    }
}
