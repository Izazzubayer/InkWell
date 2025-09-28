package com.inkwell.app.data.local.dao

import androidx.room.*
import com.inkwell.app.data.local.entity.FolderEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FolderDao {
    
    @Query("SELECT * FROM folders ORDER BY name ASC")
    fun getAllFolders(): Flow<List<FolderEntity>>
    
    @Query("SELECT * FROM folders WHERE parentId IS NULL ORDER BY name ASC")
    fun getRootFolders(): Flow<List<FolderEntity>>
    
    @Query("SELECT * FROM folders WHERE parentId = :parentId ORDER BY name ASC")
    fun getFoldersByParent(parentId: String): Flow<List<FolderEntity>>
    
    @Query("SELECT * FROM folders WHERE id = :folderId")
    suspend fun getFolderById(folderId: String): FolderEntity?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFolder(folder: FolderEntity)
    
    @Update
    suspend fun updateFolder(folder: FolderEntity)
    
    @Delete
    suspend fun deleteFolder(folder: FolderEntity)
    
    @Query("DELETE FROM folders WHERE id = :folderId")
    suspend fun deleteFolderById(folderId: String)
}
