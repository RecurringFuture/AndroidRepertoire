package com.recurringfuture.repertoire.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.recurringfuture.repertoire.entity.PracticeSet
import com.recurringfuture.repertoire.entity.PracticeSetSong
import com.recurringfuture.repertoire.entity.Song
import kotlinx.coroutines.flow.Flow

@Dao
interface PracticeSetSongsDao {

    @Upsert
    suspend fun upsert(practiceSetSong: PracticeSetSong)

    @Delete
    suspend fun delete(practiceSetSong: PracticeSetSong)

    @Query(
        "SELECT * FROM song INNER JOIN practice_set_song ON " +
                "song.id=practice_set_song.songId WHERE " +
                "practice_set_song.practiceSetId=:practiceSetId"
    )
    fun fetchSongsForPracticeSet(practiceSetId: Int): Flow<List<Song>>

    @Query(
        "SELECT * FROM practice_set INNER JOIN practice_set_song ON " +
                "practice_set.id=practice_set_song.practiceSetId WHERE " +
                "practice_set_song.songId=:songId"
    )
    fun fetchPracticeSetForSong(songId: Int): Flow<List<PracticeSet>>
}