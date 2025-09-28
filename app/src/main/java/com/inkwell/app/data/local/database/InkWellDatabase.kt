package com.inkwell.app.data.local.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import android.content.Context
import com.inkwell.app.data.local.dao.AttachmentDao
import com.inkwell.app.data.local.dao.FolderDao
import com.inkwell.app.data.local.dao.NoteDao
import com.inkwell.app.data.local.entity.AttachmentEntity
import com.inkwell.app.data.local.entity.FolderEntity
import com.inkwell.app.data.local.entity.NoteEntity
import com.inkwell.app.data.local.converter.DateConverter

@Database(
    entities = [
        NoteEntity::class,
        FolderEntity::class,
        AttachmentEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class InkWellDatabase : RoomDatabase() {
    
    abstract fun noteDao(): NoteDao
    abstract fun folderDao(): FolderDao
    abstract fun attachmentDao(): AttachmentDao
    
    companion object {
        @Volatile
        private var INSTANCE: InkWellDatabase? = null
        
        fun getDatabase(context: Context): InkWellDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    InkWellDatabase::class.java,
                    "inkwell_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
