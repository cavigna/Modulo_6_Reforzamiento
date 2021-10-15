package com.example.listarecicladora.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listarecicladora.DetalleActivity;
import com.example.listarecicladora.R;
import com.example.listarecicladora.databinding.ItemRowBinding;
import com.example.listarecicladora.model.Producto;

import java.util.ArrayList;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.MyViewHolder> {

    private ArrayList<Producto> listadoProducto;
    private Context contexto;

    public ProductoAdapter(ArrayList<Producto> listadoProducto, Context contexto){
        this.listadoProducto =  listadoProducto;
        this.contexto = contexto;
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
        holder.cardView.setOnClickListener(view -> {
            Intent intento =  new Intent(contexto, DetalleActivity.class);
            intento.putExtra("producto", listadoProducto.get(position));
            contexto.startActivity(intento);
        });
    }

    @Override
    public int getItemCount() {
        return listadoProducto.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        ItemRowBinding binding;
        private TextView tvIdrow, tvNombreRow, tvPrecioRow;
        private CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding =  ItemRowBinding.bind(itemView);
            tvIdrow =  binding.tvIDRow;
            tvNombreRow = binding.tvNombreRow;
            tvPrecioRow =  binding.tvPrecioROw;
            cardView = binding.card;

//            cardView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intento =  new Intent(contexto, DetalleActivity.class);
//                    //intento.putExtra("producto", ProductoAdapter.this.getItemViewType(getLayoutPosition()));
//                    intento.putExtra("producto", listadoProducto.get(getAdapterPosition()));
//
//                    contexto.startActivity(intento);
//                }
//            });


        }

        public void unirDatos(Producto producto){
            tvIdrow.setText(String.valueOf(producto.getId()));
            tvNombreRow.setText(producto.getNombre().toString());
            tvPrecioRow.setText(String.valueOf(producto.getPrecio()));
        }
    }
}


