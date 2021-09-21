package com.materu.mynotes.dao

import androidx.room.*
import com.materu.mynotes.entities.Notes


@Dao
interface NoteDao {

    @Query("SELECT * FROM notes ORDER BY id DESC")
    suspend fun getAllNotes() : List<Notes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotes(note:Notes): Long

    @Delete
    suspend fun deleteNote(note: Notes)
}