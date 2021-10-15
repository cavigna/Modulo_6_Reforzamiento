package com.example.ejercicioroom.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "producto")
public class ProductoEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String modelo;

    @ColumnInfo(name = "marca_fk", index = true)
    private String marca;

    private int precio;

    public ProductoEntity(int id, String modelo, String marca, int precio) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
    }

@Ignore
    public ProductoEntity(String modelo, String marca, int precio) {
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
    }

    public  int precioConIva(){
        return (int) (this.precio * 1.19);
    }



    /* GETTERS AND SETTERS*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getMarca() {return marca;}

    public void setMarca(String marca) {this.marca = marca;}
}
