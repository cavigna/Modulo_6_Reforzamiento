package com.example.ejercicioroom.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ejercicioroom.databinding.FragmentDetailsBinding;
import com.example.ejercicioroom.model.ProductoEntity;
import com.example.ejercicioroom.viewmodel.ProductoViewModel;


public class DetailsFragment extends Fragment {
    FragmentDetailsBinding binding;
    ProductoViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailsBinding.inflate(inflater, container, false);

        int id = DetailsFragmentArgs.fromBundle(getArguments()).getIdProducto();

        viewModel = new ViewModelProvider(this).get(ProductoViewModel.class);

        viewModel.getProductoById(id).observe(getViewLifecycleOwner(), productoEntity -> {
            binding.tvNombre.setText(productoEntity.getModelo());
            binding.tvPrecio.setText("$" + productoEntity.getPrecio());
        });

        return binding.getRoot();
    }
}