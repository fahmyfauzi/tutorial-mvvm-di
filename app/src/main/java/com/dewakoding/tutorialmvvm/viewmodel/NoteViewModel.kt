package com.dewakoding.tutorialmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dewakoding.tutorialmvvm.data.model.Note
import com.dewakoding.tutorialmvvm.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//viewmodel hanya tempat untuk mengambil data, datanya dari repository
class NoteViewModel(val noteRepository: NoteRepository):ViewModel() {

    fun getAll(): LiveData<List<Note>> = noteRepository.getAll()

    fun insert(note: Note) = viewModelScope.launch(Dispatchers.IO){
        noteRepository.insert(note)
    }

    fun delete(note:Note) = viewModelScope.launch(Dispatchers.IO) {
        noteRepository.delete(note)
    }

    fun update(note:Note) = viewModelScope.launch(Dispatchers.IO){
        noteRepository.update(note)
    }
}