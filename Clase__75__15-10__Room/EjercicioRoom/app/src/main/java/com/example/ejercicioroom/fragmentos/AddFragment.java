package com.example.ejercicioroom.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.ejercicioroom.MainActivity;
import com.example.ejercicioroom.R;
import com.example.ejercicioroom.databinding.FragmentAddBinding;
import com.example.ejercicioroom.model.Producto;
import com.example.ejercicioroom.model.ProductoEntity;
import com.example.ejercicioroom.viewmodel.ProductoViewModel;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class AddFragment extends Fragment {
    FragmentAddBinding binding;
    private TextInputLayout ilID, ilNombre, ilMarca, ilPrecio;
    private Button boton;
    private Producto producto = new Producto();
    static ArrayList<Producto> listaProducto = new ArrayList<>();
    private ArrayList<String> listadoMarcas= new ArrayList<>();



    private ProductoViewModel viewModel;
//    private NavController navController;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAddBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        viewModel =  new ViewModelProvider(this).get(ProductoViewModel.class);


        boton =  binding.button;
        ilID = binding.tiid;
        ilNombre =  binding.tinombre;
        ilPrecio = binding.tiprecio;
        ilMarca =  binding.timarca;




        boton.setOnClickListener(view1 -> {

            String id = ilID.getEditText().getText().toString();
            String nombre = ilNombre.getEditText().getText().toString();
            String marca = ilMarca.getEditText().getText().toString();
            String precio = ilPrecio.getEditText().getText().toString();


            /*
            if(id.isEmpty()) ilID.setError("Debe Ingresar un ID");

            */

            if (nombre.isEmpty()) ilNombre.setError("Debe Ingresar un Modelo");
            if (marca.isEmpty()) ilMarca.setError("Debe Ingresar una Marca");
            if (precio.isEmpty()) ilPrecio.setError("Debe Ingresar un Precio");



            if(!id.isEmpty() && !nombre.isEmpty() && !precio.isEmpty()) {

                producto.setId(Integer.parseInt(id));
                producto.setNombre(nombre);
                //producto.setMarca(nombre);
                producto.setPrecio(Integer.parseInt(precio));

                ProductoEntity productoEntity = new ProductoEntity(
                        nombre,marca, Integer.parseInt(precio)
                );
                viewModel.agregarProducto(productoEntity);

                Toast.makeText(getContext(), "Producto Agregado", Toast.LENGTH_SHORT).show();


               // NavDirections action = AddFragmentDirections.actionAddFragmentToListFragment();
                Navigation.findNavController(view).navigate(R.id.action_addFragment_to_listFragment);
            }
            else{
                Navigation.findNavController(view).navigate(R.id.action_addFragment_to_listFragment);
            }
        });


        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),                android.R., listadoMarcas);
        return view;

        /*
        if (!ilID.getEditText().getText().toString().isEmpty() &&
                !ilNombre.getEditText().getText().toString().isEmpty() &&
                !ilPrecio.getEditText().getText().toString().isEmpty() ){

        }


         */


    }


}