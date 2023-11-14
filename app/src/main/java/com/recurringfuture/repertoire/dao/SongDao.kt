package com.recurringfuture.repertoire.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.recurringfuture.repertoire.entity.Song
import kotlinx.coroutines.flow.Flow

@Dao
interface SongDao {

    @Upsert
    suspend fun upsert(song: Song)

    @Delete
    suspend fun delete(song: Song)

    @Query("SELECT * FROM 'song'")
    fun fetchAllSongs(): Flow<List<Song>>

    @Query("SELECT * FROM 'song' WHERE id=:id")
    fun fetchSongById(id: Int): Flow<Song>
}