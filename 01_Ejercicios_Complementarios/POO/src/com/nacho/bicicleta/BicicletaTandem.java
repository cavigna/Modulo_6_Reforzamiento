package com.nacho.bicicleta;

public class BicicletaTandem extends Bicicleta{
    int numAsientos;

    public BicicletaTandem(int velocidaddActual, int platoActual, int pinonActual, int numAsientos){

        super(velocidaddActual, platoActual, pinonActual);
        this.numAsientos = numAsientos;

    }

    @Override
    public void acelerar() {
        super.acelerar();
        setVelocidadActual((int) (getVelocidadActual()*4));
    }

     public static void main(String[] args) {

        BicicletaMontana biciMon = new BicicletaMontana(1,1,1, 1);
        BicicletaTandem biciTan = new BicicletaTandem(1,1,1, 1);

         System.out.println(biciMon.getVelocidadActual());
         System.out.println(biciTan.getVelocidadActual());

         biciMon.acelerar();
         biciTan.acelerar();
         System.out.println(biciMon.getVelocidadActual());
         System.out.println(biciTan.getVelocidadActual());



    }
}
