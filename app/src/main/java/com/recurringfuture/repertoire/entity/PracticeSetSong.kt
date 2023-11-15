package com.recurringfuture.repertoire.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "practice_set_song",
//    primaryKeys = ["practiceSetId", "songId"],
    foreignKeys = [
        ForeignKey(
            entity = PracticeSet::class,
            parentColumns = ["id"],
            childColumns = ["practiceSetId"]
        ),
        ForeignKey(
            entity = Song::class,
            parentColumns = ["id"],
            childColumns = ["songId"]
        )
    ]
)
data class PracticeSetSong(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val practiceSetId: Int,
    val songId: Int
)
