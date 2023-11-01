package com.recurringfuture.repertoire.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "project_songs")
data class ProjectSongsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val projectId: Int,
    val songId: Int
)
