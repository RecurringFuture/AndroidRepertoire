package com.recurringfuture.repertoire.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "songs")
data class SongEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String = "",
    val author: String = "",
    val key: String = "",
    val tuning: String = "",
    val capo: Int = 0,
    val tempo: Int = 0,
    val genre: String = "",
    val duration: String = "",
    val state: Int = 0,
    val threshold: String = "",
    val alert: Boolean = false,
    val creationDate: LocalDate,
    val modifiedDate: LocalDate,
    val lastPerformedDate: LocalDate,
    val count: Int = 0
)
