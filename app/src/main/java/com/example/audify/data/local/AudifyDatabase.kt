package com.example.audify.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.audify.data.local.dao.SongsDao
import com.example.audify.model.Song

@Database(
    entities = [Song::class],
    version = 1
)
abstract class AudifyDatabase : RoomDatabase() {

    abstract fun getSongsDao() : SongsDao

    companion object {
        const val DB_NAME = "audify_database"

        @Volatile
        private var INSTANCE: AudifyDatabase? = null

        fun getInstance(context: Context) : AudifyDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AudifyDatabase::class.java,
                    DB_NAME
                )
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }
}