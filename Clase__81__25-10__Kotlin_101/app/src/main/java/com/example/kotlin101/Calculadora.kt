package com.example.kotlin101

import kotlin.math.round
import kotlin.math.roundToInt


fun main() {

    calculadora()
}

fun calculadora() {
    var salir = false
    var eleccion = 0



    do {

        println(
            """
            1. Adicción
            2. Sustracción
            3. Multiplicación
            4. División
            5. Número Mayor
            6. Número Menor
            0. Salir
            
        """.trimIndent()
        )

        println("Seleccione una opción:")

        var eleccion = readLine()?.toIntOrNull() ?:0

        if (eleccion == 0) {
            salir = true
            break


        }else if(eleccion<0 || eleccion>6){
            println("Elección no valida")
        }
        else {
            println("Ingrese dos Numeros:")

            var n1 = readLine()?.toInt() ?:1
            var n2 = readLine()?.toInt() ?:1
            println()
            eleccionCalculadora(eleccion, n1, n2)
            println()
            println()
            println()
        }


    } while (!salir)
}



fun eleccionCalculadora(eleccion: Int, n1: Int, n2: Int) {
    when (eleccion) {
        1 -> adicion(n1, n2)
        2 ->  sustraccion(n1, n2)
        3 -> multiplicacion(n1,n2)
        4 -> division(n1,n2)
        5 -> mayorQue(n1,n2)
        6 -> menorQue(n1, n2)
        else-> println("Opción no valida")
    }

}

fun adicion(n1: Int, n2: Int): Int {

    var resultado = n1.plus(n2)

    println("$n1 + $n2 = $resultado")
    return resultado
}

fun sustraccion(n1: Int, n2: Int) {

    var resultado = n1.minus(n2)
    println("$n1 - $n2 = $resultado")
}

fun multiplicacion(n1: Int, n2: Int) {

    var resultado = n1.times(n2)
    println("$n1 * $n2 = $resultado")
}

fun division(n1: Int, n2: Int) {

    var resultado = (n1.div(n2.toFloat()) )
    println("$n1 / $n2 = $resultado")
}

fun mayorQue(n1: Int, n2: Int)  {
    when {
        n1 > n2 -> {
            println("$n1 es mayor que $n2")
        }
        n2>n1 -> {
            println("$n2 es mayor que $n1")
        }

        else -> {
            println("$n1 es igual que $n2")
        }

    }


}

fun menorQue(n1: Int, n2: Int) {
    when {
        n1 < n2 -> {
            println("$n1 es menor que $n2")
        }
        n2<n1 -> {
            println("$n2 es menor que $n1")
        }
        else -> {
            println("$n2 es igual que $n1")
        }
    }
}

