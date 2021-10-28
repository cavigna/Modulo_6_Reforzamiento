package com.example.simplecontactos.fragments.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simplecontactos.R
import com.example.simplecontactos.adapter.ContactoAdapter
import com.example.simplecontactos.databinding.FragmentListBinding
import com.example.simplecontactos.viewmodel.ContactoViewModel

class ListFragment : Fragment() {
   private lateinit var binding: FragmentListBinding

   val viewModel : ContactoViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentListBinding.inflate(layoutInflater, container, false)

        val adapter = ContactoAdapter()

        with(binding){
            recycler.layoutManager = LinearLayoutManager(context)
            recycler.adapter = adapter

        }

        viewModel.listaContacto.observe(viewLifecycleOwner, Observer {
            adapter.setContacto(it)
        })


        return binding.root

    }


}