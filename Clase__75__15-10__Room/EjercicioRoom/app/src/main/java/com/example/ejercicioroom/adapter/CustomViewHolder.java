package com.example.ejercicioroom.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejercicioroom.R;
import com.example.ejercicioroom.databinding.ItemRowBinding;
import com.example.ejercicioroom.model.ProductoEntity;
import java.text.NumberFormat;


public class CustomViewHolder extends RecyclerView.ViewHolder {
    ItemRowBinding binding;
    private TextView tvIdrow, tvNombreRow, tvMarca, tvPrecioRow;
    private CardView cardView;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);

        binding = ItemRowBinding.bind(itemView);

        tvIdrow = binding.tvIDRow;
        tvNombreRow = binding.tvNombreRow;
        tvMarca = binding.tvMarca;
        tvPrecioRow = binding.tvPrecioRow;
    }


    public void unirDatos(ProductoEntity productoEntity){

        int id =  productoEntity.getId();
        String nombre = productoEntity.getModelo();
        String marca = productoEntity.getMarca();
        int precio = productoEntity.getPrecio();



        tvIdrow.setText(String.valueOf(id));
        tvNombreRow.setText(nombre);
        tvMarca.setText(marca);
        tvPrecioRow.setText(String.valueOf(precio));
    }


    public static CustomViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);
        return new CustomViewHolder(view);
    }
}
