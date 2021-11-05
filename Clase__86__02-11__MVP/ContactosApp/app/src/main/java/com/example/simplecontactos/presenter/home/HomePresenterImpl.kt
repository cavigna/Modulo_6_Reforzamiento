package com.example.simplecontactos.presenter.home

import com.example.simplecontactos.controller.ContactoController
import com.example.simplecontactos.model.Contacto

class HomePresenterImpl(var homeView: HomeView) : HomePresenter {

    var contactoController = ContactoController()

    override fun agregarContacto(nombre: String, tel: String) {

        if(contactoController.agregarContacto(nombre, tel)){
            homeView.mostrarConfirmación()
            homeView.limpiarTxt()
        }else{
            homeView.mostrarError()
        }

    }

    override fun listarContactos(): MutableList<Contacto> {
        return contactoController.listarContactos()
    }


}