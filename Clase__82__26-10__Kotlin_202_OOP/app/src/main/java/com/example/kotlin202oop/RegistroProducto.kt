package com.example.kotlin202oop

class RegistroProducto(
    var listadoProductos: ArrayList<Producto> = ArrayList()
) {
    init {
        listadoProductos.add(Pelicula(1, "Matrix", 100, "N", 120))
    }

    fun guardarProducto(producto: Producto) {
        if (listadoProductos.any { it.codigo != producto.codigo }) {
            listadoProductos.add(producto)
        } else {
            println("Código ya ingresado.")
        }
    }

    fun mostrarListado() {
        for (p in listadoProductos) {
            if (p::class.java == Pelicula::class.java) {
                var pelicula = p as Pelicula
                println(" ${p.codigo} - ${p.nombre} - ${p.condicion}  - Duración: ${p.duracion} ")
            } else if (p is Libro) {
                var libro = p as Libro
                println(" $p.codigo - $p.nombre - $p.condicion  - Duración: ${p.cantidadPaginas} ")
            }


        }
    }

    fun eliminarProducto(codigo: Int) {
        if (listadoProductos.any { it.codigo == codigo }) {

            listadoProductos.remove(listadoProductos.first { producto -> producto.codigo == codigo })

            println("Producto eliminado")
        } else {
            println("Producto no encontrado")
        }
    }

    fun cantidadProductos(condicion: String) {
        var canPro = listadoProductos.filter { it.condicion == condicion }.size
        println("Cantidad Total = $canPro")
    }

}

