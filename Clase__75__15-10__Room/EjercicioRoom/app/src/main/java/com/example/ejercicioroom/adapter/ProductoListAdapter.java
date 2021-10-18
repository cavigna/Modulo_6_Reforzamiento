package com.example.ejercicioroom.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.ejercicioroom.R;
import com.example.ejercicioroom.fragmentos.ListFragmentDirections;
import com.example.ejercicioroom.model.Producto;
import com.example.ejercicioroom.model.ProductoEntity;

public class ProductoListAdapter extends ListAdapter<ProductoEntity, CustomViewHolder> {

    private RecyclerViewOnItemClickListener listener;
    private ProductoEntity productoEntity;


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return CustomViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        ProductoEntity producto = getItem(position);
        holder.unirDatos(producto);

        holder.binding.card.setOnClickListener(view -> {
            this.productoEntity = producto;
            NavDirections action = ListFragmentDirections.actionListFragmentToDetailsFragment(producto.getId());
            Navigation.findNavController(view).navigate(action);
        });

    }

    public ProductoListAdapter(@NonNull DiffUtil.ItemCallback<ProductoEntity> diffCallback) {
        super(diffCallback);
    }





    public ProductoListAdapter(@NonNull AsyncDifferConfig<ProductoEntity> config) {
        super(config);
    }



    public static class ProductoDiff extends DiffUtil.ItemCallback<ProductoEntity>{

        @Override
        public boolean areItemsTheSame(@NonNull ProductoEntity oldItem, @NonNull ProductoEntity newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull ProductoEntity oldItem, @NonNull ProductoEntity newItem) {
            return oldItem.getId() == newItem.getId();
        }
    }



    public interface  RecyclerViewOnItemClickListener {

        void onClick(ProductoEntity productoEntity);
    }

    public void setListener(RecyclerViewOnItemClickListener listener) {
        this.listener = listener;
    }
}
