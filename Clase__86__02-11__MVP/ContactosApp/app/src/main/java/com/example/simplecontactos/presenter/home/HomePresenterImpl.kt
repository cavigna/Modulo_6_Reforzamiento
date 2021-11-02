package com.example.simplecontactos.presenter.home

import com.example.simplecontactos.controller.ContactoController

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


}