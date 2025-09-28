package com.inkwell.app.data.local.dao

import androidx.room.*
import com.inkwell.app.data.local.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    
    @Query("SELECT * FROM notes ORDER BY updatedAt DESC")
    fun getAllNotes(): Flow<List<NoteEntity>>
    
    @Query("SELECT * FROM notes WHERE pinned = 1 ORDER BY updatedAt DESC")
    fun getPinnedNotes(): Flow<List<NoteEntity>>
    
    @Query("SELECT * FROM notes WHERE folderId = :folderId ORDER BY updatedAt DESC")
    fun getNotesByFolder(folderId: String): Flow<List<NoteEntity>>
    
    @Query("SELECT * FROM notes WHERE locked = 1 ORDER BY updatedAt DESC")
    fun getLockedNotes(): Flow<List<NoteEntity>>
    
    @Query("SELECT * FROM notes WHERE id = :noteId")
    suspend fun getNoteById(noteId: String): NoteEntity?
    
    @Query("SELECT * FROM notes WHERE title LIKE '%' || :query || '%' OR content LIKE '%' || :query || '%' ORDER BY updatedAt DESC")
    fun searchNotes(query: String): Flow<List<NoteEntity>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteEntity)
    
    @Update
    suspend fun updateNote(note: NoteEntity)
    
    @Delete
    suspend fun deleteNote(note: NoteEntity)
    
    @Query("DELETE FROM notes WHERE id = :noteId")
    suspend fun deleteNoteById(noteId: String)
    
    @Query("UPDATE notes SET pinned = :pinned WHERE id = :noteId")
    suspend fun updatePinnedStatus(noteId: String, pinned: Boolean)
    
    @Query("UPDATE notes SET locked = :locked WHERE id = :noteId")
    suspend fun updateLockedStatus(noteId: String, locked: Boolean)
}
