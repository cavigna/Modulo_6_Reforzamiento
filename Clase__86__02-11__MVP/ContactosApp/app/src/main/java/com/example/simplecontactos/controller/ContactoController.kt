package com.example.simplecontactos.controller

import com.example.simplecontactos.model.Contacto
import com.example.simplecontactos.model.ContactoModel

class ContactoController {

    var contactoModel = ContactoModel()

    fun agregarContacto(nombre: String, tel: String): Boolean {

        return if (nombre.isNotEmpty() && tel.isNotEmpty()) {
            contactoModel.agregarContacto(Contacto(nombre, tel))
            true
        } else {
            false
        }


    }

    fun listarContactos():MutableList<Contacto>{
        return contactoModel.listadoContacto
    }
}