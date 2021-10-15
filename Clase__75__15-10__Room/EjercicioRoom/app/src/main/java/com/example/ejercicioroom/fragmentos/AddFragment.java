package com.example.ejercicioroom.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ejercicioroom.R;
import com.example.ejercicioroom.databinding.FragmentAddBinding;
import com.example.ejercicioroom.model.Producto;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class AddFragment extends Fragment {
    FragmentAddBinding binding;
    private TextInputLayout ilID, ilNombre,ilPrecio;
    private Button boton;
    private Producto producto = new Producto();
    static ArrayList<Producto> listaProducto = new ArrayList<>();
//    private NavController navController;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAddBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        boton =  binding.button;
        ilID = binding.tiid;
        ilNombre =  binding.tinombre;
        ilPrecio = binding.tiprecio;


        boton.setOnClickListener(view1 -> {

            String id = ilID.getEditText().getText().toString();
            String nombre = ilNombre.getEditText().getText().toString();
            String precio = ilPrecio.getEditText().getText().toString();


            if(!id.isEmpty() && !nombre.isEmpty() && !precio.isEmpty()) {

                producto.setId(Integer.parseInt(id));
                producto.setNombre(nombre);
                producto.setPrecio(Integer.parseInt(precio));


                listaProducto.add(producto);


                Bundle bundle = new Bundle();
                bundle.putSerializable("listaProducto", listaProducto);

               // NavDirections action = AddFragmentDirections.actionAddFragmentToListFragment();
                Navigation.findNavController(view).navigate(R.id.action_addFragment_to_listFragment, bundle);
            }
        });
        return view;

        /*
        if (!ilID.getEditText().getText().toString().isEmpty() &&
                !ilNombre.getEditText().getText().toString().isEmpty() &&
                !ilPrecio.getEditText().getText().toString().isEmpty() ){

        }


         */


    }


}