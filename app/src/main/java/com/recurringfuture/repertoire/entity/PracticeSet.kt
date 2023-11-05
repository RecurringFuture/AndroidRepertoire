package com.recurringfuture.repertoire.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import java.sql.Date

@Entity(tableName = "practice_set")
class PracticeSet(
    val id: Int,
    val title: String,
    val description: String,
    @ColumnInfo(name = "creation_date")
    val creationDate: Date?,
    @ColumnInfo(name = "modified_date")
    val modifiedDate: Date?
)