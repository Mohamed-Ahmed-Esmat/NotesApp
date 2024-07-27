package com.example.notesapp.database


import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Note::class],
    version = 1,
    exportSchema = false, // Add this line
    //autoMigrations = [AutoMigration(from = 1, to = 2)]
)


abstract class RoomDBHelper : RoomDatabase() {
    abstract val dao: NoteDAO

    companion object {
        @Volatile
        private var INSTANCE: RoomDBHelper? = null

        fun getInstance(c: Context): RoomDBHelper {
            return INSTANCE ?: synchronized(this) {
                val instance = Room
                    .databaseBuilder(c, RoomDBHelper::class.java, "DB")
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}