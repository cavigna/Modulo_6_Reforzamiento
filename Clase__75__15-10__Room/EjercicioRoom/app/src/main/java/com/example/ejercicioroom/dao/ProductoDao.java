package com.example.ejercicioroom.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.ejercicioroom.model.Producto;
import com.example.ejercicioroom.model.ProductoEntity;

import java.util.List;

@Dao
public interface ProductoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void agregarProducto(ProductoEntity productoEntity);

    @Delete
    void elminarProducto(ProductoEntity productoEntity);

    @Delete
    void eliminarTodosLosProductos(ProductoEntity productoEntity);

    @Query("SELECT * FROM producto")
    LiveData<List<ProductoEntity>> selectAllProductos();

}
