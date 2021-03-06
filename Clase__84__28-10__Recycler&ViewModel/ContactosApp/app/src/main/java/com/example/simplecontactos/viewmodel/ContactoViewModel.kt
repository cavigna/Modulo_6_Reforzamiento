package com.example.simplecontactos.viewmodel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simplecontactos.model.Contacto

class ContactoViewModel() : ViewModel() {

    var listaContacto = MutableLiveData<ArrayList<Contacto>>()



    init {
        listaContacto.value = ArrayList()
        listaContacto.value?.add(Contacto("juan", "+569988634475") )
    }

    fun onGuardar(nombre:String, numero:String){
        var contacto = Contacto(nombre, numero)
        listaContacto.value?.add(contacto)
    }
}