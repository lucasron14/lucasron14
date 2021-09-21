package com.materu.mynotes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.materu.mynotes.dao.NoteDao
import com.materu.mynotes.entities.Notes


@Database(entities = [Notes::class], version = 1, exportSchema = false)
abstract class NotesDatabase: RoomDatabase() {

    companion object{
        var notesDatabase: NotesDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): NotesDatabase{
            if (notesDatabase == null){
                notesDatabase = Room.databaseBuilder(
                    context
                , NotesDatabase::class.java
                , "notes.db"
                ).build()
            }
            return notesDatabase!!
        }
    }

    abstract fun noteDao(): NoteDao
}