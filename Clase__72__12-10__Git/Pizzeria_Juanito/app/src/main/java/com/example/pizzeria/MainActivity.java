package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

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
        RadioButton rbSmall = binding.radioButtonSmall;
        RadioButton rbMedium = binding.radioButtonMedium;
        RadioButton rbXl = binding.radioButtoLarge;

        this.cbCarne = binding.checkBoxCarne;
        cbPepe = binding.checkBoxPeperoni;
        cbTocino = binding.checkBoxTocino;
        cbChamp = binding.checkBoxChamp;
        cbTomate = binding.checkBoxTomate;
        cbChoclo = binding.checkBoxChoclo;
        cbAceituna = binding.checkBoxAceituna;

        Button boton = binding.button;

        Pizza prueba = new Pizza("xl");
        prueba.setTieneCarne();
        prueba.precioTotal();
        Log.i("total",
                String.valueOf(prueba.getTotal())
        );

        String nombre = editTextNombre.getText().toString();

        boolean sizeSmall = rbSmall.isChecked();
        boolean sizeMedium = rbMedium.isChecked();
        boolean sizeLarge = rbXl.isChecked();

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Pizza pizza = null;
                if (nombre.isEmpty()) {
                    editTextNombre.setError("Agrege Su Nombre");

                }
                if ((sizeSmall || sizeMedium || sizeLarge) && (!nombre.isEmpty())) {

                    if (sizeSmall) {
                        pizza = new Pizza("s");
                        
                    } else if (sizeMedium) {
                        pizza = new Pizza("m");
                    } else if (sizeLarge) {
                        pizza = new Pizza("xl");
                    }
                    makePizza(pizza);

                    
//
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Tiene que Seleccionar un tamaño", Toast.LENGTH_LONG).show();
                }

                Log.i("pizza",String.valueOf(pizza.getTotal()));


            }
        });


    }

    private void makePizza(Pizza pizza){
        if(cbCarne.isChecked()) pizza.setTieneCarne();
        if(cbPepe.isChecked()) pizza.setTienePeperoni();
        if(cbTocino.isChecked()) pizza.setTieneTocino();
        if(cbTomate.isChecked()) pizza.setTieneTomate();
        if(cbChamp.isChecked()) pizza.setTieneChamp();
        if(cbChoclo.isChecked()) pizza.setTieneChoclo();
        if(cbAceituna.isChecked()) pizza.setTieneAceituna();

    }
}


/*
if(sizeSmall && sizeMedium && sizeLarge ) {
                    Toast.makeText(getApplicationContext(),
                            "Tiene que Seleccionar un tamaño", Toast.LENGTH_LONG).show();
                }
 */