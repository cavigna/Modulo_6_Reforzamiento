package com.nacho.bicicleta;

public class Bicicleta {

    private int velocidadActual;
    private int platoActual;
    private int pinonActual;

    public Bicicleta(int velocidadActual, int platoActual, int pinonActual) {
        this.velocidadActual = velocidadActual;
        this.platoActual = platoActual;
        this.pinonActual = pinonActual;
    }

    public void acelerar(){this.velocidadActual = this.velocidadActual * 2;}

    public void frenar(){this.velocidadActual = this.velocidadActual / 2;}


    public void cambiarPlato(int plato){this.platoActual = plato;}


    public void cambiarPiñon(int piñon){this.pinonActual = piñon;}

    // Ejercicio 2

    public void cambiarPlato(){this.platoActual = 1;}
    public void cambiarPiñon(){this.pinonActual = 1;}

    // Ejercicio 3

    public Bicicleta (){
        this.velocidadActual = 1;
        this.pinonActual = 1;
        this.platoActual = 1;
    }

    /*
    Ejercicio 4 : Getters and Setters
         */

    public int getVelocidadActual() {
        return velocidadActual;
    }

    public void setVelocidadActual(int velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    public int getPlatoActual() {
        return platoActual;
    }

    public void setPlatoActual(int platoActual) {
        this.platoActual = platoActual;
    }

    public int getPinonActual() {
        return pinonActual;
    }

    public void setPinonActual(int pinonActual) {
        this.pinonActual = pinonActual;
    }
}
