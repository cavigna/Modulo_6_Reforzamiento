package com.example.pizzeria;

import java.io.Serializable;

public class Pizza implements Serializable {

    private String size;
    private String cliente;
    protected int total = 0;
    private int precioSize = 0;

    private boolean tieneCarne = false;
    private boolean tienePeperoni = false;
    private boolean tieneTocino = false;
    private boolean tieneChamp = false;
    private boolean tieneTomate = false;
    private boolean tieneChoclo = false;
    private boolean tieneAceituna = false;

//    private int tieneCarne = 0;
//    private int tienePeperoni = 0;
//    private int tieneTocino = 0;
//    private int tieneChamp = 0;
//    private int tieneTomate = 0;
//    private int tieneChoclo = 0;
//    private int tieneAceituna = 0;


    private static final int S = 1500;
    private static final int M = 3000;
    private static final int XL = 5000;

    private static final int PRECIOCARNE = 400;
    private static final int PRECIOPEPE = 200;
    private static final int PRECIOTOCINO = 450;
    private static final int PRECIOCHAMP = 250;
    private static final int PRECIOTOMATE = 200;
    private static final int PRECIOCHOCLO = 200;
    private static final int PRECIOACEITUNA = 250;

    public Pizza(){

    }

    public Pizza(String size) {
        this.size = size;
        precioPorSize(size);
        sumartotal();

    }

    public Pizza(String size, boolean tieneCarne, boolean tienePeperoni, boolean tieneTocino, boolean tieneChamp, boolean tieneTomate, boolean tieneChoclo, boolean tieneAceituna) {
        this.size = size;
        precioPorSize(size);


        this.tieneCarne = tieneCarne;
        this.tienePeperoni = tienePeperoni;
        this.tieneTocino = tieneTocino;
        this.tieneChamp = tieneChamp;
        this.tieneTomate = tieneTomate;
        this.tieneChoclo = tieneChoclo;
        this.tieneAceituna = tieneAceituna;
    }


    public void precioTotal(){
        if(this.tieneCarne) this.total += PRECIOCARNE;
        if(this.tienePeperoni) this.total += PRECIOPEPE;
        if(this.tieneTocino) this.total += PRECIOTOCINO;
        if(this.tieneChamp) this.total += PRECIOCHAMP;
        if(this.tieneTomate) this.total += PRECIOTOMATE;
        if(this.tieneChoclo) this.total += PRECIOCHOCLO;
        if(this.tieneAceituna) this.total += PRECIOACEITUNA;


    }


    public void sumartotal(){
        this.total += precioSize;
   }

    public int getTotal() {
        return total;
    }

    private void precioPorSize(String tam){
        switch (tam){
            case "s" :
                precioSize = S;
                break;
            case "m":
                precioSize = M;
                break;
            case "xl":
                precioSize = XL;
                break;
            default:
                precioSize =  0;
        }
    }


    /* GETTERS  AND SETTERS */

    public int getPrecioSize() {
        return precioSize;
    }

    public void setPrecioSize(int precioSize) {
        this.precioSize = precioSize;
    }

    public boolean isTieneCarne() {
        return tieneCarne;
    }

    public void setTieneCarne() {
        this.tieneCarne = !this.tieneCarne;
    }

    public boolean isTienePeperoni() {
        return tienePeperoni;
    }

    public void setTienePeperoni() {
        this.tienePeperoni = !this.tienePeperoni;
    }

    public boolean isTieneTocino() {
        return tieneTocino;
    }

    public void setTieneTocino() {
        this.tieneTocino = !this.tieneTocino;
    }

    public boolean isTieneChamp() {
        return tieneChamp;
    }

    public void setTieneChamp() {
        this.tieneChamp = !this.tieneChamp;
    }

    public boolean isTieneTomate() {
        return tieneTomate;
    }

    public void setTieneTomate() {
        this.tieneTomate = !this.tieneTomate;
    }

    public boolean isTieneChoclo() {
        return tieneChoclo;
    }

    public void setTieneChoclo() {
        this.tieneChoclo = !this.tieneChoclo;
    }

    public boolean isTieneAceituna() {
        return tieneAceituna;
    }

    public void setTieneAceituna() {
        this.tieneAceituna = !this.tieneAceituna;
    }
}


/*
          switch (size){
        case "s" :
            precioSize = S;
            break;
        case "m":
            precioSize = M;
            break;
        case "xl":
            precioSize = XL;
            break;
        default:
            precioSize =  0;
    }
 */