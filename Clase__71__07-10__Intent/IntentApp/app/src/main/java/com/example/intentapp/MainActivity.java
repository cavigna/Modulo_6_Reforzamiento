package com.example.intentapp;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.intentapp.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(binding.getRoot());

        Button boton = binding.button;
        EditText nombre = binding.editTextTextPersonName;
        EditText apellido = binding.editTextTextPersonName2;
        EditText email = binding.editTextTextEmailAddress;
        EditText password = binding.editTextTextPassword;

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreString = nombre.getText().toString();
                String apellidoString = apellido.getText().toString();
                String emailString = email.getText().toString();
                String passwordString = password.getText().toString();

                if(nombreString.isEmpty()) nombre.setError("Falta Nombre");
                if(apellidoString.isEmpty()) apellido.setError("Falta Apellido");
                if(emailString.isEmpty()) email.setError("Falta email");
                if(passwordString.isEmpty()) password.setError("Falta contraseña");

                Intent intento = new Intent(getApplicationContext(), ResumenActivity.class);

                Registro registro = new Registro(nombreString, apellidoString,
                        emailString, passwordString);

                if(!nombreString.isEmpty() && !apellidoString.isEmpty() && !emailString.isEmpty()
                        && !passwordString.isEmpty()
                ){
                    intento.putExtra("registro",registro);
                    startActivity(intento);
                }
                //else()

            }
        });


    }


}

/*

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
 */