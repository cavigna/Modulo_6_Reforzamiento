package com.example.ejercicioroom.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.example.ejercicioroom.model.MarcaEntity;
import com.example.ejercicioroom.model.ProductoEntity;
import com.example.ejercicioroom.repository.ProductoRepository;

import java.util.List;

public class ProductoViewModel extends AndroidViewModel {
    private ProductoRepository repository;
    private  LiveData<List<ProductoEntity>> allProductos;
    private int id;
    private LiveData<ProductoEntity> productoById;



    private MutableLiveData<ProductoEntity> currentProduct;


    public ProductoViewModel(@NonNull Application application) {
        super(application);

        repository = new ProductoRepository(application);
        allProductos = repository.selectAllProductos();
        productoById = repository.getProductoById(id);
        //currentProduct = (MutableLiveData<ProductoEntity>) repository.getProductoById(1);
        currentProduct = new MutableLiveData<>();


     }

     public void agregarProducto(ProductoEntity productoEntity){
        repository.agregarProducto(productoEntity);
     }

    public LiveData<List<ProductoEntity>> selectAllProductos() {
        return allProductos;
    }


    public void agregarMarca(MarcaEntity marca){
        repository.agregarMarca(marca);
    }




    public MutableLiveData<ProductoEntity> getCurrentProduct() {
        return currentProduct;
    }
}
