package com.example.ejercicioroom.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.ejercicioroom.R;
import com.example.ejercicioroom.databinding.FragmentBuscarBinding;
import com.example.ejercicioroom.viewmodel.ProductoViewModel;
import com.google.android.material.textfield.TextInputLayout;

public class BuscarFragment extends Fragment {

    FragmentBuscarBinding binding;
    TextInputLayout ilId, ilnombre;
    Button boton;
    ProductoViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBuscarBinding.inflate(inflater, container, false);

        View view = binding.getRoot();

        viewModel = new ViewModelProvider(getActivity()).get(ProductoViewModel.class);

        ilId =  binding.tiid;
        ilnombre = binding.tinombre;
        boton = binding.button;

        boton.setOnClickListener(view1 -> {
            String id = ilId.getEditText().getText().toString();
            String nombre = ilnombre.getEditText().getText().toString();

            if (id.isEmpty() && nombre.isEmpty()){
                Toast.makeText(getContext(), "Debe Ingresar un ID O un Nombre", Toast.LENGTH_SHORT).show();
            }

            else{
                viewModel.setId(Integer.parseInt(id));
                viewModel.getProductoById2();

                Log.i("prueba", String.valueOf(viewModel.getId()));
                NavDirections action = BuscarFragmentDirections.actionBuscarFragmentToResultadoFragment();
                Navigation.findNavController(view).navigate(action);

            }

        });


        return view;
    }
}