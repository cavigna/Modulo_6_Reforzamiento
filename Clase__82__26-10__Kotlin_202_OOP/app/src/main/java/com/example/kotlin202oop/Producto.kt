package com.example.kotlin202oop

 abstract  class Producto(
    var codigo: Int,
    var nombre: String,
    var precio: Int,
    var condicion: String,
) {
    open abstract fun imprimir(): String
}

class Pelicula(
    codigo: Int,
    nombre: String,
    precio: Int,
    condicion: String,
    var duracion: Int
) : Producto(
    codigo, nombre, precio, condicion
) {
    override fun imprimir(): String {
        return "Código: $codigo - $nombre - $condicion - duración: $duracion minutos"
    }
}

class Libro(
    codigo: Int,
    nombre: String,
    precio: Int,
    condicion: String,
    var cantidadPaginas: Int
) : Producto(
    codigo, nombre, precio, condicion
){
    override fun imprimir(): String {
        return "Código: $codigo - $nombre - $condicion -  $cantidadPaginas páginas"
    }

}