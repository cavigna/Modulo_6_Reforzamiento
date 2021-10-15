package com.example.ejercicioroom.model;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "marca")
public class MarcaEntity {


    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "descripcion")
    @NonNull
    private String nombre;

    public MarcaEntity(int id, @NonNull String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Ignore
    public MarcaEntity(@NonNull String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }
}
