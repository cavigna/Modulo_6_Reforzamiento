package com.example.listarecicladora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.listarecicladora.databinding.ActivityMainBinding;
import com.example.listarecicladora.model.Producto;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private TextInputEditText etID, etNombre, etPrecio;
    private TextInputLayout ilID, ilNombre,ilPrecio;
    private Button boton;
    private Producto producto = new Producto();
    static ArrayList<Producto> listaProducto = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        etID = binding.etid;
        etNombre = binding.etnombre;
        etPrecio = binding.etprecio;
        boton =  binding.button;

        ilID = binding.tiid;
        ilNombre =  binding.tinombre;
        ilPrecio = binding.tiprecio;

        listaProducto.add(new Producto(1, "producto uno", 123));
        listaProducto.add(new Producto(2, "producto dos", 456));
        listaProducto.add(new Producto(3, "producto tres", 789));

        setContentView(view);
        boton.setOnClickListener(new View.OnClickListener() {


            String id = Objects.requireNonNull(ilID.getEditText()).getText().toString();
            String nombre = Objects.requireNonNull(ilNombre.getEditText()).getText().toString();
            String precio = Objects.requireNonNull(ilPrecio.getEditText()).getText().toString();


            @Override
            public void onClick(View view) {
                producto.setId(conversorNumerico(id));
                producto.setNombre(nombre);
                producto.setPrecio(conversorNumerico(precio));

                Intent intento = new Intent(getApplicationContext()
                        , ListadoActivity.class);
                listaProducto.add(producto);
                intento.putExtra("listaProducto", listaProducto);


                for(int i= 0; i<listaProducto.size(); i++){
                    Log.i("problema", listaProducto.get(i).getNombre());
                }

                startActivity(intento);
            }
        });





    }

    private int conversorNumerico(String valor) {
        try {
            int numero = Integer.parseInt(valor);

            return numero;
        } catch (NumberFormatException nfe) {
            // Handle the condition when str is not a number.
        return 0;
        }
    };


}