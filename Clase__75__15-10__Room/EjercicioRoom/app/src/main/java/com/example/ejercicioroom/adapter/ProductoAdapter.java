package com.example.ejercicioroom.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejercicioroom.R;
import com.example.ejercicioroom.databinding.ItemRowBinding;
import com.example.ejercicioroom.fragmentos.ListFragmentDirections;
import com.example.ejercicioroom.model.Producto;

import java.util.ArrayList;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.MyViewHolder> {

    private ArrayList<Producto> listadoProducto;

    public ProductoAdapter(ArrayList<Producto> listadoProducto) {
        this.listadoProducto = listadoProducto;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Producto producto = listadoProducto.get(position);
        holder.unirDatos(producto);

        holder.cardView.setOnClickListener(view -> {
//            Bundle bundle = new Bundle();
//            bundle.putSerializable("producto", producto);

            NavDirections action = ListFragmentDirections.actionListFragmentToDetailsFragment(producto.getId());


            Navigation.findNavController(view).navigate(action);
        });
    }

    @Override
    public int getItemCount() {
        return listadoProducto.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ItemRowBinding binding;
        private TextView tvIdrow, tvNombreRow, tvPrecioRow;
        private CardView cardView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            binding = ItemRowBinding.bind(itemView);
            tvIdrow = binding.tvIDRow;
            tvNombreRow = binding.tvNombreRow;
            tvPrecioRow = binding.tvPrecioRow;
            cardView = binding.card;
        }

        public void unirDatos(Producto producto) {
            tvIdrow.setText(String.valueOf(producto.getId()));
            tvNombreRow.setText(producto.getNombre());
            tvPrecioRow.setText(String.valueOf(producto.getPrecio()));
        }
    }
}







/*
public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.MyViewHolder> {

    private ArrayList<Producto> listadoProducto;

    public ProductoAdapter(ArrayList<Producto> listadoProducto) {
        this.listadoProducto = listadoProducto;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Producto producto = listadoProducto.get(position);
        holder.unirDatos(producto);

        holder.cardView.setOnClickListener(view -> {
//            Bundle bundle = new Bundle();
//            bundle.putSerializable("producto", producto);

            NavDirections action = ListFragmentDirections.actionListFragmentToDetailsFragment(producto);


            Navigation.findNavController(view).navigate(action);
        });
    }

    @Override
    public int getItemCount() {
        return listadoProducto.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ItemRowBinding binding;
        private TextView tvIdrow, tvNombreRow, tvPrecioRow;
        private CardView cardView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            binding = ItemRowBinding.bind(itemView);
            tvIdrow = binding.tvIDRow;
            tvNombreRow = binding.tvNombreRow;
            tvPrecioRow = binding.tvPrecioRow;
            cardView = binding.card;
        }

        public void unirDatos(Producto producto) {
            tvIdrow.setText(String.valueOf(producto.getId()));
            tvNombreRow.setText(producto.getNombre());
            tvPrecioRow.setText(String.valueOf(producto.getPrecio()));
        }
    }
}
 */