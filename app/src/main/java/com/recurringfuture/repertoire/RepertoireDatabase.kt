package com.recurringfuture.repertoire

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.recurringfuture.repertoire.dao.PracticeSetDao
import com.recurringfuture.repertoire.dao.ProjectDao
import com.recurringfuture.repertoire.dao.ProjectSongsDao
import com.recurringfuture.repertoire.dao.SongDao
import com.recurringfuture.repertoire.entity.PracticeSet
import com.recurringfuture.repertoire.entity.Project
import com.recurringfuture.repertoire.entity.ProjectSong
import com.recurringfuture.repertoire.entity.Song
import com.recurringfuture.repertoire.utils.Converters

@Database(
    entities = [Song::class, Project::class, ProjectSong::class, PracticeSet::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class RepertoireDatabase : RoomDatabase() {

    abstract fun songDao(): SongDao
    abstract fun projectDao(): ProjectDao
    abstract fun projectSongsDao(): ProjectSongsDao
    abstract fun practiceSetDao(): PracticeSetDao

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