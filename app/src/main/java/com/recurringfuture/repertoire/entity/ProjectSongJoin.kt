package com.recurringfuture.repertoire.entity

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "project_song_join",
    primaryKeys = ["projectId", "songId"],
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
data class ProjectSongJoin(
    val projectId: Int,
    val songId: Int
)
