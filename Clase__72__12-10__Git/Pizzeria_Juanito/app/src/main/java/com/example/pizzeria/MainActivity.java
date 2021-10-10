package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.pizzeria.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;


    Button boton;

    private RadioButton rbSmall;
    private RadioButton rbMedium;
    private RadioButton rbXl;


    private CheckBox cbCarne;
    private CheckBox cbPepe;
    private CheckBox cbTocino;
    private CheckBox cbChamp;
    private CheckBox cbTomate;
    private CheckBox cbChoclo;
    private CheckBox cbAceituna;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();
        setContentView(view);

        EditText editTextNombre = binding.editTextNombre;

        RadioGroup radioGroup = binding.radioGroup;
        rbSmall = binding.radioButtonSmall;
        rbMedium = binding.radioButtonMedium;
        rbXl = binding.radioButtoLarge;

        cbCarne = binding.checkBoxCarne;
        cbPepe = binding.checkBoxPeperoni;
        cbTocino = binding.checkBoxTocino;
        cbChamp = binding.checkBoxChamp;
        cbTomate = binding.checkBoxTomate;
        cbChoclo = binding.checkBoxChoclo;
        cbAceituna = binding.checkBoxAceituna;

        boton = binding.button;







        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = editTextNombre.getText().toString();

                boolean sizeSmall = rbSmall.isChecked();
                boolean sizeMedium = rbMedium.isChecked();
                boolean sizeLarge = rbXl.isChecked();


                if (nombre.isEmpty()) {
                    editTextNombre.setError("Agrege Su Nombre");

                }
                if ((sizeSmall || sizeMedium || sizeLarge) && (!nombre.isEmpty())) {

                   Pizza pizza =   doPizza();
                    Intent intento = new Intent(getApplicationContext(),
                            Pedido.class);
                    intento.putExtra("pizza", pizza);
                    startActivity(intento);


                    Log.i("juanito",String.valueOf(pizza.getTotal()));

                } else {
                    Toast.makeText(getApplicationContext(),
                            "Tiene que Seleccionar un tamaño", Toast.LENGTH_LONG).show();
                }




            }
        });


    }



    private Pizza doPizza(){
        boolean sizeSmall = rbSmall.isChecked();
        boolean sizeMedium = rbMedium.isChecked();
        boolean sizeLarge = rbXl.isChecked();
        Pizza pizza = null;

        if (sizeSmall) {
             pizza = new Pizza("s");
             makePizza(pizza);
             return pizza;

        } else if (sizeMedium) {
             pizza = new Pizza("m");
             makePizza(pizza);
             return pizza;


        } else if (sizeLarge) {
            pizza = new Pizza("xl");
            makePizza(pizza);
            return pizza;
        }
        return pizza;



    }

    private void makePizza(Pizza pizza){
        if(cbCarne.isChecked()) pizza.setTieneCarne();
        if(cbPepe.isChecked()) pizza.setTienePeperoni();
        if(cbTocino.isChecked()) pizza.setTieneTocino();
        if(cbTomate.isChecked()) pizza.setTieneTomate();
        if(cbChamp.isChecked()) pizza.setTieneChamp();
        if(cbChoclo.isChecked()) pizza.setTieneChoclo();
        if(cbAceituna.isChecked()) pizza.setTieneAceituna();
        pizza.precioTotal();


    }
}


/*
if(sizeSmall && sizeMedium && sizeLarge ) {
                    Toast.makeText(getApplicationContext(),
                            "Tiene que Seleccionar un tamaño", Toast.LENGTH_LONG).show();
                }
 */