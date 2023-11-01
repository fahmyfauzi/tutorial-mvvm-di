package com.dewakoding.tutorialmvvm.ui.addnote

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dewakoding.tutorialmvvm.data.AppDatabase
import com.dewakoding.tutorialmvvm.data.model.Note
import com.dewakoding.tutorialmvvm.databinding.ActivityAddBinding
import com.dewakoding.tutorialmvvm.databinding.ActivityListBinding
import com.dewakoding.tutorialmvvm.repository.NoteRepository
import com.dewakoding.tutorialmvvm.viewmodel.NoteViewModel
import com.dewakoding.tutorialmvvm.viewmodel.NoteViewModelFactory
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNoteActivity: AppCompatActivity() {
    //supaya tidak menggunakan findviewbyid
    private val binding by lazy { ActivityAddBinding.inflate(layoutInflater) }

    //inisialisasi NoteViewModel
    private val noteViewModel: NoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.imgCheck.setOnClickListener{
            val title = binding.etTitle.text.toString()
            val description=  binding.etDescription.text.toString()

            //cek validasi
            if(title.isNullOrEmpty() || description.isNullOrEmpty()){
                Toast.makeText(applicationContext,"Data tidak boleh kosong",Toast.LENGTH_SHORT).show()
            }else{
                //insert ke room database
                noteViewModel.insert(Note(null,title,description))
                Toast.makeText(applicationContext,"Sukses",Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

}