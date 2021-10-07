package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.firstapp.databinding.ActivityMainBinding;

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
                if(nombre.getText().toString().isEmpty()) nombre.setError("Falta Nombre");
                if(apellido.getText().toString().isEmpty()) apellido.setError("Falta Apellido");
                if(email.getText().toString().isEmpty()) email.setError("Falta email");
                if(password.getText().toString().isEmpty()) password.setError("Falta contraseña");
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