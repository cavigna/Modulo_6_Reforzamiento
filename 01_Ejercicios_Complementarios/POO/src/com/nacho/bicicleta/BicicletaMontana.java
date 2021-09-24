package com.nacho.bicicleta;

/* Ejercicio 5-6*/
public class BicicletaMontana extends Bicicleta{

    private int suspencion;

    public BicicletaMontana(int velocidaddActual, int platoActual, int pinonActual, int suspencion){
        super(velocidaddActual, platoActual, pinonActual);
        this.suspencion = suspencion;
    }

    public void cambiarSuspencion(int suspencion){
        this.suspencion = suspencion;
    }


    @Override
    public void acelerar() {
        super.acelerar();
        setVelocidadActual(getVelocidadActual()*3);
    }

    public int getSuspencion() {
        return suspencion;
    }

    public void setSuspencion(int suspencion) {
        this.suspencion = suspencion;
    }
}




/*
BicicletaMontaña tiene un atributo suspension de
tipo entero y un método cambiarSuspension(int
suspension)

 */
