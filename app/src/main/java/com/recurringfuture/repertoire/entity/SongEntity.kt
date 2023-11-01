package com.recurringfuture.repertoire.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName = "songs")
data class SongEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String?,
    val author: String?,
    val key: String?,
    val tuning: String?,
    val capo: Int,
    val tempo: Int,
    val genre: String?,
    val duration: String?,
    val state: Int,
    val threshold: String?,
    val alert: Boolean = false,
    @ColumnInfo(name = "creation_date")
    val creationDate: Date?,
    @ColumnInfo(name = "modified_date")
    val modifiedDate: Date?,
    @ColumnInfo(name = "last_performed_date")
    val lastPerformedDate: Date?,
    val count: Int
)
