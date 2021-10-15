package com.example.ejercicioroom.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.ejercicioroom.dao.ProductoDao;
import com.example.ejercicioroom.db.BaseDeDatos;
import com.example.ejercicioroom.model.ProductoEntity;

import java.util.List;

public class ProductoRepository {
    private ProductoDao productoDao;
    private LiveData<List<ProductoEntity>> selectAllProductos;

    public ProductoRepository(Application application){

        BaseDeDatos baseDeDatos = BaseDeDatos.getDataBase(application);
        productoDao = baseDeDatos.productoDao();

        selectAllProductos = productoDao.selectAllProductos();


    }






}
