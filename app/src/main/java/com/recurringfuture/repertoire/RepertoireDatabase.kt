package com.recurringfuture.repertoire

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.recurringfuture.repertoire.dao.SongDao
import com.recurringfuture.repertoire.entity.ProjectEntity
import com.recurringfuture.repertoire.entity.SongEntity
import com.recurringfuture.repertoire.utils.Converters

@Database(entities = [SongEntity::class, ProjectEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class RepertoireDatabase : RoomDatabase() {

    abstract fun songDao(): SongDao
//    abstract fun songDao(): SongDao

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