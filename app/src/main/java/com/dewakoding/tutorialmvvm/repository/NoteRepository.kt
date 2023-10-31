package com.dewakoding.tutorialmvvm.repository

import com.dewakoding.tutorialmvvm.data.AppDatabase
import com.dewakoding.tutorialmvvm.data.model.Note

//repository bisa mengambil data dari daatabase atau server atau lainnya
class NoteRepository(private val db: AppDatabase)  {
    fun getAll () = db.noteDao().getAll()

    suspend fun insert(note:Note) =  db.noteDao().insert(note)

    suspend fun delete(note: Note) = db.noteDao().delete(note)

    suspend fun update(note: Note) = db.noteDao().update(note)
}