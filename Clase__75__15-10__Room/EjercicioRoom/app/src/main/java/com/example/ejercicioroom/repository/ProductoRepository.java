package com.example.ejercicioroom.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.ejercicioroom.dao.ProductoDao;
import com.example.ejercicioroom.db.BaseDeDatos;
import com.example.ejercicioroom.model.MarcaEntity;
import com.example.ejercicioroom.model.Producto;
import com.example.ejercicioroom.model.ProductoEntity;

import java.util.List;

public class ProductoRepository {
    private ProductoDao productoDao;
    private LiveData<List<ProductoEntity>> selectAllProductos;
    private int id;
    private LiveData<ProductoEntity> productoById;


    public ProductoRepository(Application application) {

        BaseDeDatos baseDeDatos = BaseDeDatos.getDataBase(application);
        productoDao = baseDeDatos.productoDao();
        productoById = productoDao.selectProductById(id);
        selectAllProductos = productoDao.selectAllProductos();


    }

    public LiveData<List<ProductoEntity>> selectAllProductos() {
        return selectAllProductos;
    }

    public LiveData<ProductoEntity> getProductoById(int id) {
        return productoDao.selectProductById(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void agregarProducto(ProductoEntity productoEntity) {
        BaseDeDatos.databaseWriteExecutor.execute(() ->
                productoDao.agregarProducto(productoEntity)
        );
    }

    public void eliminarProducto(ProductoEntity productoEntity) {
        BaseDeDatos.databaseWriteExecutor.execute(() ->
                productoDao.elminarProducto(productoEntity)
        );
    }

    public void agregarMarca(MarcaEntity marca){
        BaseDeDatos.databaseWriteExecutor.execute(()->
                productoDao.agregarMarca(marca)
                );
    }
}
