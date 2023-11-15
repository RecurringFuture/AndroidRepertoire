package com.recurringfuture.repertoire.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.recurringfuture.repertoire.entity.Project
import com.recurringfuture.repertoire.entity.ProjectSong
import com.recurringfuture.repertoire.entity.Song
import kotlinx.coroutines.flow.Flow

@Dao
interface ProjectSongsDao {

    @Upsert
    suspend fun upsert(projectSong: ProjectSong)

    @Delete
    suspend fun delete(projectSong: ProjectSong)

    @Query(
        "SELECT * FROM song INNER JOIN project_song ON " +
                "song.id=project_song.songId WHERE " +
                "project_song.projectId=:projectId"
    )
    fun fetchSongsForProject(projectId: Int): Flow<List<Song>>

    @Query(
        "SELECT * FROM project INNER JOIN project_song ON " +
                "project.id=project_song.projectId WHERE " +
                "project_song.songId=:songId"
    )
    fun fetchProjectsForSong(songId: Int): Flow<List<Project>>
}