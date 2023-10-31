package com.dewakoding.tutorialmvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dewakoding.tutorialmvvm.repository.NoteRepository

//fungsi viewmodelfactory : ketika merubah rotasi hp. data tidak merender dari awal
class NoteViewModelFactory (private val noteRepository: NoteRepository):ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NoteViewModel(noteRepository) as T
    }
}