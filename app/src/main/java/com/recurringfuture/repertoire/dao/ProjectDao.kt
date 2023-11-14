package com.recurringfuture.repertoire.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.recurringfuture.repertoire.entity.Project
import kotlinx.coroutines.flow.Flow

@Dao
interface ProjectDao {

    @Upsert
    suspend fun upsert(project: Project)

    @Delete
    suspend fun delete(project: Project)

    @Query("SELECT * FROM 'project'")
    fun fetchAllProjects(): Flow<List<Project>>

    @Query("SELECT * FROM 'project' WHERE id=:id")
    fun fetchProjectById(id: Int): Flow<Project>
}