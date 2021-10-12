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

        String  saludo = pizza.getCliente() +", tu pizza está en camino  "+ getEmojiByUnicode(0x1F681)+ "   "
                + getEmojiByUnicode(0x1F355)
                ;
        tvNombreCliente =  binding.tvNombreCliente;
        tvDetalle  = binding.tvDetalle;
        TextView tvTotal =  binding.tvTotal;

        tvNombreCliente.setText(saludo);
        tvDetalle.setText(pizza.toString());
        tvTotal.setText(new StringBuilder().append("$").append(pizza.getTotal()).toString());

    }

    public String getEmojiByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }
}

//tvNombreCliente.setText(String.valueOf(pizza.getTotal()));