package com.inkwell.app.di

import android.content.Context
import androidx.room.Room
import com.inkwell.app.data.local.database.InkWellDatabase
import com.inkwell.app.data.local.dao.AttachmentDao
import com.inkwell.app.data.local.dao.FolderDao
import com.inkwell.app.data.local.dao.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    
    @Provides
    @Singleton
    fun provideInkWellDatabase(@ApplicationContext context: Context): InkWellDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            InkWellDatabase::class.java,
            "inkwell_database"
        ).build()
    }
    
    @Provides
    fun provideNoteDao(database: InkWellDatabase): NoteDao = database.noteDao()
    
    @Provides
    fun provideFolderDao(database: InkWellDatabase): FolderDao = database.folderDao()
    
    @Provides
    fun provideAttachmentDao(database: InkWellDatabase): AttachmentDao = database.attachmentDao()
}
