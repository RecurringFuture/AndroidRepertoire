package com.recurringfuture.repertoire.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.recurringfuture.repertoire.entity.PracticeSet

@Dao
interface PracticeSetDao {

    @Insert
    suspend fun insert(practiceSet: PracticeSet)

    @Update
    suspend fun update(practiceSet: PracticeSet)

    @Delete
    suspend fun delete(practiceSet: PracticeSet)
}