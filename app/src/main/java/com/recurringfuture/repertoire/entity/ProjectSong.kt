package com.recurringfuture.repertoire.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "project_song",
//    primaryKeys = ["projectId", "songId"],
    foreignKeys = [
        ForeignKey(
            entity = Project::class,
            parentColumns = ["id"],
            childColumns = ["projectId"]
        ),
        ForeignKey(
            entity = Song::class,
            parentColumns = ["id"],
            childColumns = ["songId"]
        )
    ]
)
data class ProjectSong(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val projectId: Int,
    val songId: Int
)
