package com.example.simplecontactos.model

class ContactoModel {

    var listadoContacto  = mutableListOf<Contacto>()


    fun agregarContacto(contacto: Contacto){
        listadoContacto.add(contacto)
    }

}