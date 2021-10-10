package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.pizzeria.databinding.ActivityPedidoBinding;

public class Pedido extends AppCompatActivity {
    ActivityPedidoBinding binding;
    TextView tvNombreCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPedidoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Pizza pizza = (Pizza) getIntent().getSerializableExtra("pizza");
        tvNombreCliente =  binding.tvNombreCliente;

        tvNombreCliente.setText(pizza.getCliente());
    }
}