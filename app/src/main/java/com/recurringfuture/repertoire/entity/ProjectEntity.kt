package com.recurringfuture.repertoire.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName = "projects")
data class ProjectEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String?,
    val description: String?,
    @ColumnInfo(name = "creation_date")
    val creationDate: Date?,
    @ColumnInfo(name = "modified_date")
    val modifiedDate: Date?,
)
