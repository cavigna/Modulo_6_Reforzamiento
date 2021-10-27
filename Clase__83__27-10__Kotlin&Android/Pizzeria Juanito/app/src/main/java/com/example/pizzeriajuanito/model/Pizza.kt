package com.example.pizzeriajuanito.model

data class Pizza(
    var cliente: String,

    var size: String =  "",

    var precioSize: Int = 0,
    var total: Int = 0,

    var carne: Int = 400,
    var pepe: Int = 200,
    var tocino: Int = 450,
    var champ: Int = 250,
    var tomate: Int = 200,
    var choclo: Int = 200,
    var aceituna: Int = 250,

    )

{


    fun sumarTotal() {
        total = precioSize + carne + pepe + tocino + champ + tomate + choclo + aceituna
    }
}

//    fun precioPorSize(tam: String) {
//        when (tam) {
//            "s" -> precioSize = 1500
//            "m" -> precioSize = 3000
//            "xl" -> precioSize = 5000
//
//        }
//    }


