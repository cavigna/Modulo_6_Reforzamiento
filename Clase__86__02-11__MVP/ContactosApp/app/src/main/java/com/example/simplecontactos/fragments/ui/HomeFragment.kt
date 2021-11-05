package com.example.simplecontactos.fragments.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.simplecontactos.databinding.FragmentHomeBinding
import com.example.simplecontactos.presenter.home.HomePresenter
import com.example.simplecontactos.presenter.home.HomePresenterImpl
import com.example.simplecontactos.presenter.home.HomeView
import com.example.simplecontactos.utils.hideKeyboard
import com.example.simplecontactos.viewmodel.ContactoViewModel
import com.google.android.material.textfield.TextInputLayout


class HomeFragment : Fragment(), HomeView {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel: ContactoViewModel by activityViewModels()

    private lateinit var tvNombre: TextInputLayout
    private lateinit var tvTel: TextInputLayout
    private lateinit var btnAgregar: Button

    private lateinit var presenter: HomePresenter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        presenter =  HomePresenterImpl(this)
        with(binding) {
            tvNombre = txNombre
            tvTel = txNumero
            btnAgregar = bAgregar


        }

        //hideKeyboard()
        btnAgregar.setOnClickListener {

            val nombre = tvNombre.editText?.text.toString()
            val tel = tvTel.editText?.text.toString()

            presenter.agregarContacto(nombre, tel)




        }
        return binding.root
    }

    override fun mostrarConfirmación() {
        Toast.makeText(context, "Dale dale, esta agregado!", Toast.LENGTH_SHORT).show()
    }

    override fun mostrarError() {
        Toast.makeText(context, "Debe Completar todos los campos, Gil!!!", Toast.LENGTH_SHORT).show()
    }

    override fun limpiarTxt() {
        tvNombre.editText?.text?.clear()
        tvTel.editText?.text?.clear()
    }


}


