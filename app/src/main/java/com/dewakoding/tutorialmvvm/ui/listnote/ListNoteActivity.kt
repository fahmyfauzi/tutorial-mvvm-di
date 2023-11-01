package com.dewakoding.tutorialmvvm.ui.listnote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.dewakoding.tutorialmvvm.R
import com.dewakoding.tutorialmvvm.data.AppDatabase
import com.dewakoding.tutorialmvvm.data.model.Note
import com.dewakoding.tutorialmvvm.databinding.ActivityListBinding
import com.dewakoding.tutorialmvvm.listener.OnNoteClickListener
import com.dewakoding.tutorialmvvm.repository.NoteRepository
import com.dewakoding.tutorialmvvm.ui.addnote.AddNoteActivity
import com.dewakoding.tutorialmvvm.viewmodel.NoteViewModel
import com.dewakoding.tutorialmvvm.viewmodel.NoteViewModelFactory
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListNoteActivity : AppCompatActivity() {

    //supaya tidak menggunakan findviewbyid
    private val binding by lazy { ActivityListBinding.inflate(layoutInflater) }

    //menampilkan list
    private val noteViewModel : NoteViewModel by viewModels()

    //inisialissasi adapter
    private lateinit var adapter: ListNoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        adapter=ListNoteAdapter(applicationContext,object:OnNoteClickListener{
            override fun onDelete(note: Note) {
                //delete
                noteViewModel.delete(note)
            }

            override fun onEdit(note: Note) {

            }
        })

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = StaggeredGridLayoutManager(2, LinearLayout.VERTICAL)
        binding.recyclerView.adapter = adapter


        //berpindah halaman ke AddNoteActivity
        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(applicationContext, AddNoteActivity::class.java)
            startActivity(intent)
        }

        noteViewModel.getAll().observe(this){listNote ->
            listNote.let {
                adapter.updateList(it)
            }
        }
    }


}