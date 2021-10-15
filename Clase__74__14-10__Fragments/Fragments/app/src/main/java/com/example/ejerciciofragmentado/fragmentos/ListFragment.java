package com.example.ejerciciofragmentado.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ejerciciofragmentado.MainActivity;
import com.example.ejerciciofragmentado.R;
import com.example.ejerciciofragmentado.adapter.ProductoAdapter;
import com.example.ejerciciofragmentado.databinding.FragmentAddBinding;
import com.example.ejerciciofragmentado.databinding.FragmentListBinding;
import com.example.ejerciciofragmentado.model.Producto;

import java.util.ArrayList;


public class ListFragment extends Fragment {
    FragmentListBinding binding;
    private RecyclerView recyclerView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        ArrayList<Producto> listadoProductos = (ArrayList<Producto>)
                getArguments().getSerializable("listaProducto");

        recyclerView = binding.recycler;

        ProductoAdapter adapter = new ProductoAdapter(listadoProductos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);





        return view;


    }
}