package com.example.ejercicioroom.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ejercicioroom.R;
import com.example.ejercicioroom.databinding.FragmentBuscarBinding;
import com.google.android.material.textfield.TextInputLayout;

public class BuscarFragment extends Fragment {

    FragmentBuscarBinding binding;
    TextInputLayout ilId, ilnombre;
    Button boton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBuscarBinding.inflate(inflater, container, false);

        View view = binding.getRoot();

        ilId =  binding.tiid;
        ilnombre = binding.tinombre;
        boton = binding.button;

        boton.setOnClickListener(view1 -> {


        });


        return view;
    }
}