package com.example.ejercicioroom.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ejercicioroom.R;
import com.example.ejercicioroom.databinding.FragmentResultadoBinding;
import com.example.ejercicioroom.viewmodel.ProductoViewModel;


public class ResultadoFragment extends Fragment {
    FragmentResultadoBinding binding;
    TextView tvId, tvModelo, tvMarca, tvPrecio;
    ProductoViewModel viewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentResultadoBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        tvId = binding.tvId;
        tvModelo = binding.tvNombre;
        tvMarca = binding.tvMarcaR;
        tvPrecio = binding.tvPrecioR;

        viewModel = new ViewModelProvider(requireActivity()).get(ProductoViewModel.class);

        viewModel.getProductoById(viewModel.getId()).observe(getViewLifecycleOwner(), p -> {
            if(p == null){
                ocultarElemntos();
            }else {
                tvId.setText(String.valueOf(p.getId()));
                tvModelo.setText(p.getModelo());
                tvMarca.setText(p.getMarca());
                tvPrecio.setText(String.valueOf(p.getPrecio()));
            }
        });
        return view;
    }

    public void ocultarElemntos(){

        tvId.setVisibility(View.INVISIBLE);
        tvModelo.setVisibility(View.INVISIBLE);
        tvMarca.setVisibility(View.INVISIBLE);
        tvPrecio.setVisibility(View.INVISIBLE);

        binding.textView2.setVisibility(View.INVISIBLE);
        binding.textView3.setVisibility(View.INVISIBLE);
        binding.textView4.setVisibility(View.INVISIBLE);
        binding.textView.setVisibility(View.INVISIBLE);

        binding.tvSinRes.setVisibility(View.VISIBLE);

    }
}