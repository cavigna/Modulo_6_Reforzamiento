package com.example.ejercicioroom.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ejercicioroom.R;
import com.example.ejercicioroom.databinding.FragmentAddMarcaBinding;
import com.example.ejercicioroom.model.Producto;
import com.example.ejercicioroom.viewmodel.ProductoViewModel;
import com.google.android.material.textfield.TextInputLayout;


public class AddMarcaFragment extends Fragment {
        FragmentAddMarcaBinding binding;
        private TextInputLayout ilNombre;
        private Button boton;
        private ProductoViewModel viewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddMarcaBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        ilNombre = binding.tinombre;
        boton = binding.button;

        viewModel = new ViewModelProvider(this).get(ProductoViewModel.class);


        return view;
    }


}