package com.example.simplecontactos.presenter.home

import com.example.simplecontactos.model.Contacto

interface HomePresenter {

    fun agregarContacto(nombre: String, tel: String)

    fun listarContactos(): MutableList<Contacto>

}