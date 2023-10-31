package com.dewakoding.tutorialmvvm.ui.addnote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dewakoding.tutorialmvvm.databinding.ActivityAddBinding
import com.dewakoding.tutorialmvvm.databinding.ActivityListBinding

class AddNoteActivity: AppCompatActivity() {
    //supaya tidak menggunakan findviewbyid
    private val binding by lazy { ActivityAddBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}