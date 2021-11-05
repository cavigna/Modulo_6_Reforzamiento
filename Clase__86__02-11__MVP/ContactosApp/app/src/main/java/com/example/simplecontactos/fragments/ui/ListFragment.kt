package com.example.simplecontactos.fragments.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simplecontactos.adapter.ContactoAdapter
import com.example.simplecontactos.databinding.FragmentListBinding
import com.example.simplecontactos.presenter.home.HomePresenter
import com.example.simplecontactos.presenter.home.HomePresenterImpl
import com.example.simplecontactos.viewmodel.ContactoViewModel

class ListFragment : Fragment() {
   private lateinit var binding: FragmentListBinding

   private lateinit var presenter: HomePresenter

   val viewModel : ContactoViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = FragmentListBinding.inflate(layoutInflater, container, false)

        //val presenter = HomePresenterImpl()

        val adapter = ContactoAdapter(requireActivity())

        with(binding){
            recycler.layoutManager = LinearLayoutManager(context)
            recycler.adapter = adapter

        }







//        viewModel.listaContacto.observe(viewLifecycleOwner, {
//            adapter.setContacto(it)
//        })




        return binding.root

    }


}