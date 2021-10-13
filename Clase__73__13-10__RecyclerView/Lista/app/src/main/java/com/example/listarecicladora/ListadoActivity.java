package com.example.listarecicladora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.listarecicladora.adapter.ProductoAdapter;
import com.example.listarecicladora.databinding.ActivityListadoBinding;
import com.example.listarecicladora.model.Producto;

import java.util.ArrayList;

public class ListadoActivity extends AppCompatActivity {
    private ActivityListadoBinding binding;
    private RecyclerView  recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListadoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        recyclerView = binding.recycler;

        ArrayList<Producto> listaProducto = (ArrayList<Producto>) getIntent()
                .getSerializableExtra("listaProducto");

        ProductoAdapter  adapter = new ProductoAdapter(listaProducto,
                ListadoActivity.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);

    }
}