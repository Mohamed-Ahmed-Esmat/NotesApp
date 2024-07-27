package com.example.notesapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDAO {
    @Upsert
    suspend fun upsert(n: Note)

    @Delete
    suspend fun deleteNote(n: Note)

    @Query("SELECT * FROM note")
    fun getAllNotes(): Flow<List<Note>>
}