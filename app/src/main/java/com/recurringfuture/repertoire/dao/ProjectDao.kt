package com.recurringfuture.repertoire.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.recurringfuture.repertoire.entity.Project
import kotlinx.coroutines.flow.Flow

interface ProjectDao {

    @Insert
    suspend fun insert(project: Project)

    @Update
    suspend fun update(project: Project)

    @Delete
    suspend fun delete(project: Project)

    @Query("SELECT * FROM 'project'")
    fun fetchAllProjects(): Flow<List<Project>>

    @Query("SELECT * FROM 'project' WHERE id=:id")
    fun fetchProjectById(id: Int): Flow<Project>
}