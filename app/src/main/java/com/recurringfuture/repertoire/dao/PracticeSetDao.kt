package com.recurringfuture.repertoire.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.recurringfuture.repertoire.entity.PracticeSet
import kotlinx.coroutines.flow.Flow

@Dao
interface PracticeSetDao {

    @Upsert
    suspend fun upsert(practiceSet: PracticeSet)

    @Delete
    suspend fun delete(practiceSet: PracticeSet)

    @Query("SELECT * FROM 'practice_set'")
    fun fetchAllPracticeSets(): Flow<List<PracticeSet>>

    @Query("SELECT * FROM 'practice_set' WHERE id=:id")
    fun fetchPracticeSetById(id: Int): Flow<PracticeSet>
}