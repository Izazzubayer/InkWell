package com.inkwell.app.data.local.dao

import androidx.room.*
import com.inkwell.app.data.local.entity.AttachmentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AttachmentDao {
    
    @Query("SELECT * FROM attachments WHERE noteId = :noteId ORDER BY addedAt ASC")
    fun getAttachmentsByNoteId(noteId: String): Flow<List<AttachmentEntity>>
    
    @Query("SELECT * FROM attachments WHERE id = :attachmentId")
    suspend fun getAttachmentById(attachmentId: String): AttachmentEntity?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAttachment(attachment: AttachmentEntity)
    
    @Update
    suspend fun updateAttachment(attachment: AttachmentEntity)
    
    @Delete
    suspend fun deleteAttachment(attachment: AttachmentEntity)
    
    @Query("DELETE FROM attachments WHERE id = :attachmentId")
    suspend fun deleteAttachmentById(attachmentId: String)
    
    @Query("DELETE FROM attachments WHERE noteId = :noteId")
    suspend fun deleteAttachmentsByNoteId(noteId: String)
}
