package com.example.ejercicioroom.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ejercicioroom.R;
import com.example.ejercicioroom.adapter.CustomViewHolder;
import com.example.ejercicioroom.adapter.ProductoAdapter;
import com.example.ejercicioroom.adapter.ProductoListAdapter;
import com.example.ejercicioroom.databinding.FragmentAddBinding;
import com.example.ejercicioroom.databinding.FragmentListBinding;
import com.example.ejercicioroom.model.Producto;
import com.example.ejercicioroom.model.ProductoEntity;
import com.example.ejercicioroom.viewmodel.ProductoViewModel;

import java.util.ArrayList;


public class ListFragment extends Fragment {
    FragmentListBinding binding;
    private ProductoViewModel viewModel;
    private RecyclerView recyclerView;
    private ProductoListAdapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        viewModel = new ViewModelProvider(this).get(ProductoViewModel.class);

        recyclerView = binding.recycler;

        adapter = new ProductoListAdapter(new ProductoListAdapter.ProductoDiff());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);



        adapter.setListener(productoEntity -> {


            viewModel.getCurrentProduct().postValue(adapter.getProductoEntity());
            Log.i("prueba", productoEntity.getMarca().toString());
            //Navigation.findNavController(view).navigate(R.id.detailsFragment);
        });

        viewModel.selectAllProductos().observe(getViewLifecycleOwner(), productos ->{
            adapter.submitList(productos);
        } );

//viewModel.getCurrentProduct().setValue(adapter.getItemId(position));

//        recyclerView.addOnItemTouchListener(l->{
//
//        });

//        viewModel.setCurrentProduct(
//
//                MutableLiveData<adapter.getCurrentProduct()>);
        //binding.recycler.findViewHolderForAdapterPosition()

        //ProductoAdapter adapter = new ProductoAdapter(listadoProductos);





        return view;


    }
}