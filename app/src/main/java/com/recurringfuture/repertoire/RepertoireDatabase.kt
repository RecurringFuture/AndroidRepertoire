package com.recurringfuture.repertoire

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.recurringfuture.repertoire.dao.SongDao
import com.recurringfuture.repertoire.entity.SongEntity

@Database(entities = [SongEntity::class], version = 1)
abstract class RepertoireDatabase : RoomDatabase() {

    abstract fun songDao(): SongDao

    companion object {

        @Volatile
        private var INSTANCE: RepertoireDatabase? = null

        fun getInstance(context: Context): RepertoireDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RepertoireDatabase::class.java,
                        "repertoire_database"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}