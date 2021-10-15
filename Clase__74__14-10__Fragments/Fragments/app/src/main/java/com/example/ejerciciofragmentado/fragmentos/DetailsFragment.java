package com.example.ejerciciofragmentado.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ejerciciofragmentado.R;
import com.example.ejerciciofragmentado.databinding.FragmentDetailsBinding;
import com.example.ejerciciofragmentado.model.Producto;


public class DetailsFragment extends Fragment {
    FragmentDetailsBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailsBinding.inflate(inflater, container, false);

        Producto producto = DetailsFragmentArgs.fromBundle(getArguments()).getProducto();

        binding.tvNombre.setText(producto.getNombre());

        binding.tvPrecio.setText("$" + producto.getPrecio());



        return binding.getRoot();
    }
}