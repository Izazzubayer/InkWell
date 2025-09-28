package com.inkwell.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val content: String, // Encrypted content
    val createdAt: Date,
    val updatedAt: Date,
    val pinned: Boolean = false,
    val locked: Boolean = false,
    val folderId: String? = null,
    val tags: String? = null // JSON array of tags
)

@Entity(tableName = "folders")
data class FolderEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val parentId: String? = null,
    val createdAt: Date,
    val updatedAt: Date
)

@Entity(tableName = "attachments")
data class AttachmentEntity(
    @PrimaryKey
    val id: String,
    val noteId: String,
    val type: String, // "image", "file", etc.
    val uri: String,
    val fileName: String? = null,
    val fileSize: Long? = null,
    val addedAt: Date
)
