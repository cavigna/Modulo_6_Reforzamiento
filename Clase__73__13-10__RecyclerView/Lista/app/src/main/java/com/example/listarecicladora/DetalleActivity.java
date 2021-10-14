package com.example.listarecicladora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.listarecicladora.databinding.ActivityDetalleBinding;
import com.example.listarecicladora.model.Producto;

public class DetalleActivity extends AppCompatActivity {

    private ActivityDetalleBinding binding;
    private TextView tvId, tvNombre, tvPrecio;
    //private Producto producto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =  ActivityDetalleBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

       Producto producto =  (Producto) getIntent().getSerializableExtra("producto");

        tvId = binding.tvId;
        tvNombre = binding.tvNombre;
        tvPrecio = binding.tvPrecio;

        //tvId.setText(String.valueOf(Integer.valueOf(producto.getId())));
        tvId.setText(String.valueOf(producto.getId()));
        tvNombre.setText(producto.getNombre());
        tvPrecio.setText(String.valueOf(producto.getPrecio()));




    }
}