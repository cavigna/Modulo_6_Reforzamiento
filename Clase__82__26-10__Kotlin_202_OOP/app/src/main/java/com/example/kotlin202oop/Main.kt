package com.example.kotlin202oop


var registroProducto = RegistroProducto()



fun main() {

    var salir = false

    do {
        println(
            """
           1. Agregar Producto:
           2. Listar Productos
           3. Buscar Producto
           5. Salir
        """.trimMargin()
        )

        var opcion = readLine()?.toIntOrNull() ?: 0

        if (opcion == 5) {
            salir = true
        } else if (opcion < 1 || opcion > 5) {
            println("Opción No válida")
        }else{
            opciones(opcion)
        }

    } while (!salir)

}

fun opciones(opcion: Int) {
    when (opcion) {
        1 -> {
            agregarProducto()
        }
        2->{
            registroProducto.mostrarListado()
//            for (p in registroProducto.listadoProductos){
//                p.imprimir()
//            }
        }
    }
}

fun agregarProducto() {
    println(
        """"Que tipo de producto desea agregar?:
        |1. Pelicula
        |2. Libro
    """.trimMargin()
    )
    println("Seleccione su opción")
    var opcionProducto = readLine()?.toInt() ?: 0

    when (opcionProducto) {
        1 -> {
            println("Ingrese Codigo:")
            var codigo = readLine()?.toInt() ?: 0

            println("Ingrese Nombre:")
            var nombre = readLine() ?: ""

            println("Ingrese Precio:")
            var precio = readLine()?.toInt() ?: 0

            println("Ingrese Condicion (U/N): ")
            var condicion = readLine() ?: ""

            println("Ingrese Duracion:")
            var duracion = readLine()?.toInt() ?: 0

            var productoAgregar = Pelicula(codigo, nombre, precio, condicion, duracion)
            registroProducto.guardarProducto(productoAgregar)
        }

        2 -> {
            println("Ingrese Codigo:")
            var codigo = readLine()?.toInt() ?: 0

            println("Ingrese Nombre:")
            var nombre = readLine() ?: ""

            println("Ingrese Precio:")
            var precio = readLine()?.toInt() ?: 0

            println("Ingrese Condicion (U/N): ")
            var condicion = readLine() ?: ""

            println("Ingrese cantidad de páginas:")
            var cantidadPaginas = readLine()?.toInt() ?: 0
            var productoAgregar = Libro(codigo, nombre, precio, condicion, cantidadPaginas)
            registroProducto.guardarProducto(productoAgregar)

        }
        else -> {
            println("Opción no válida")

        }
    }
}