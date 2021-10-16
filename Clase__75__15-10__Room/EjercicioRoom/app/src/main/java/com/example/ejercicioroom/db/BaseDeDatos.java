package com.example.ejercicioroom.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.ejercicioroom.dao.ProductoDao;
import com.example.ejercicioroom.model.MarcaEntity;
import com.example.ejercicioroom.model.ProductoEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ProductoEntity.class, MarcaEntity.class}, version = 1, exportSchema = false)
public abstract class BaseDeDatos extends RoomDatabase {

    private static volatile BaseDeDatos instance;

    public abstract ProductoDao productoDao();

    private static final String DB_NAME = "ejercicio_db";

    private static final int NUMBER_OF_THREADS = 4;

    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static BaseDeDatos getDataBase(final Context context) {

        if (instance == null) {
            synchronized (BaseDeDatos.class) {

                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            BaseDeDatos.class,
                            DB_NAME

                    ).fallbackToDestructiveMigration().build();
                }
            }
        }
        return instance;
    }
}
