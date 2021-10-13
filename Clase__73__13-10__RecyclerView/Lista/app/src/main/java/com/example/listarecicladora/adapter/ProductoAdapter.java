package com.example.listarecicladora.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listarecicladora.R;
import com.example.listarecicladora.databinding.ItemRowBinding;
import com.example.listarecicladora.model.Producto;

import java.util.ArrayList;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.MyViewHolder> {

    private ArrayList<Producto> listadoProducto;

    public ProductoAdapter(ArrayList<Producto> listadoProducto){
        this.listadoProducto =  listadoProducto;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.unirDatos(listadoProducto.get(position));
    }

    @Override
    public int getItemCount() {
        return listadoProducto.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        ItemRowBinding binding;
        private TextView tvIdrow, tvNombreRow, tvPrecioRow;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding =  ItemRowBinding.bind(itemView);
            tvIdrow =  binding.tvIDRow;
            tvNombreRow = binding.tvNombreRow;
            tvPrecioRow =  binding.tvPrecioROw;
        }

        public void unirDatos(Producto producto){
            tvIdrow.setText(producto.getId());
            tvNombreRow.setText(producto.getNombre());
            tvPrecioRow.setText(String.valueOf(producto.getPrecio()));
        }
    }
}
