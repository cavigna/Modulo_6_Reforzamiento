package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.pizzeria.databinding.ActivityPedidoBinding;

public class Pedido extends AppCompatActivity {
    ActivityPedidoBinding binding;
    TextView tvNombreCliente;
    TextView tvDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPedidoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Pizza pizza = (Pizza) getIntent().getSerializableExtra("pizza");

        String  saludo = pizza.getCliente() +", tu pizza de tamaño " + pizza.mapSize() +
                " está en camino";
        tvNombreCliente =  binding.tvNombreCliente;
        tvDetalle  = binding.tvDetalle;


        tvNombreCliente.setText(saludo);
        tvDetalle.setText(pizza.toString());

    }
}

//tvNombreCliente.setText(String.valueOf(pizza.getTotal()));