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

        CheckBox cbCarne = binding.checkBoxCarne;
        CheckBox cbPepe = binding.checkBoxPeperoni;
        CheckBox cbTocino = binding.checkBoxTocino;
        CheckBox cbChamp   = binding.checkBoxChamp;
        CheckBox cbTomate = binding.checkBoxTomate;
        CheckBox cbChoclo = binding.checkBoxChoclo;
        CheckBox cbAceituna = binding.checkBoxAceituna;

        Button boton = binding.button;

        Pizza prueba  = new Pizza("xl");
        prueba.setTieneCarne();
        prueba.precioTotal();
        Log.i("total",
                String.valueOf(prueba.getTotal())
                );

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = editTextNombre.getText().toString();

                boolean sizeSmall = rbSmall.isChecked();
                boolean sizeMedium = rbMedium.isChecked();
                boolean sizeLarge = rbXl.isChecked();

                if(nombre.isEmpty()) {
                    editTextNombre.setError("Agrege Su Nombre");
                    Toast.makeText(getApplicationContext(),
                            "Tiene que Seleccionar un tamaño", Toast.LENGTH_LONG).show();
                }
                if((sizeSmall || sizeMedium || sizeLarge) && (!nombre.isEmpty()) ) {
//                    Pizza pizza =  new Pizza()
                }

                Log.i("juanito", String.valueOf(radioGroup.getCheckedRadioButtonId()));






            }
        });



    }
}


/*
if(sizeSmall && sizeMedium && sizeLarge ) {
                    Toast.makeText(getApplicationContext(),
                            "Tiene que Seleccionar un tamaño", Toast.LENGTH_LONG).show();
                }
 */