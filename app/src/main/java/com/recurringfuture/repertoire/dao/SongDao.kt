package com.recurringfuture.repertoire.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.recurringfuture.repertoire.entity.SongEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SongDao {

    @Insert
    suspend fun insert(song: SongEntity)

    @Update
    suspend fun update(song: SongEntity)

    @Delete
    suspend fun delete(song: SongEntity)

    @Query("SELECT * FROM 'songs'")
    fun fetchAllSongs(): Flow<List<SongEntity>>

    @Query("SELECT * FROM 'songs' WHERE id=:id")
    fun fetchSongById(id: Int): Flow<SongEntity>
}