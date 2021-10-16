package com.example.ejercicioroom.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.example.ejercicioroom.model.ProductoEntity;
import com.example.ejercicioroom.repository.ProductoRepository;

import java.util.List;

public class ProductoViewModel extends AndroidViewModel {
    private ProductoRepository repository;
    private  LiveData<List<ProductoEntity>> allProductos;


    public ProductoViewModel(@NonNull Application application) {
        super(application);

        repository = new ProductoRepository(application);
        allProductos = repository.selectAllProductos();

     }

     public void agregarProducto(ProductoEntity productoEntity){
        repository.agregarProducto(productoEntity);
     }

    public LiveData<List<ProductoEntity>> selectAllProductos() {
        return allProductos;
    }


}
