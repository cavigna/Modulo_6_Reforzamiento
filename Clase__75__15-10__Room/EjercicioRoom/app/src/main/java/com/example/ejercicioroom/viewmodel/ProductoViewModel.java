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
    private LiveData<List<MarcaEntity>> allMarcas;
    private int id;
    private LiveData<ProductoEntity> productoById;
    private LiveData<ProductoEntity> productoById2;



    private MutableLiveData<ProductoEntity> currentProduct;


    public ProductoViewModel(@NonNull Application application) {
        super(application);

        repository = new ProductoRepository(application);
        allProductos = repository.selectAllProductos();
        this.productoById = repository.getProductoById(id);
        this.allMarcas = repository.selectAllMarcas();

        this.productoById2 = repository.getProductoById(repository.getId()


        );
//        currentProduct = (MutableLiveData<ProductoEntity>) repository.getProductoById(1);
//        currentProduct = (MutableLiveData<ProductoEntity>) productoById;


     }

    public LiveData<ProductoEntity> getProductoById(int id) {
        return repository.getProductoById(id);
    }

    public LiveData<ProductoEntity> getProductoById2() {
        return this.productoById2;
    }

    public void agregarProducto(ProductoEntity productoEntity){
        repository.agregarProducto(productoEntity);
     }



    public LiveData<List<ProductoEntity>> selectAllProductos() {
        return allProductos;
    }

    public LiveData<List<MarcaEntity>>  getAllMarcas() {
        return allMarcas;
    }

    public void agregarMarca(MarcaEntity marca){
        repository.agregarMarca(marca);
    }



    public void setProductoById(LiveData<ProductoEntity> productoById) {
        this.productoById = productoById;
    }

    public void setCurrentProduct(int id) {
        this.currentProduct = (MutableLiveData<ProductoEntity>) repository.getProductoById(id);
    }

    public MutableLiveData<ProductoEntity> getCurrentProduct() {
        return currentProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
