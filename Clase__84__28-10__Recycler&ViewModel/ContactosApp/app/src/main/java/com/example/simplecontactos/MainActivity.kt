package com.example.simplecontactos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.simplecontactos.viewmodel.ContactoViewModel

class MainActivity : AppCompatActivity() {

    val viewModel : ContactoViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}