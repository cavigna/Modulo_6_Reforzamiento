package com.nacho;

import com.nacho.bicicleta.Bicicleta;
import com.nacho.bicicleta.BicicletaMontana;
import com.nacho.bicicleta.BicicletaTandem;

public class Main {

    public static void main(String[] args) {
        // Ejercicio 7

        Bicicleta[] bicicletas = {
                new BicicletaTandem(1, 1, 1, 1),
                new BicicletaTandem(1, 1, 1, 1),
                new BicicletaMontana(1, 1, 1, 1),
                new BicicletaMontana(1, 1, 1, 1),
        };

        for (int i = 0 ;  i<bicicletas.length; i++){
            bicicletas[i].acelerar();
        }
    }
}
