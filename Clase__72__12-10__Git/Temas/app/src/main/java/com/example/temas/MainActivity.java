package com.example.temas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.temas.databinding.ActivityMainBinding;
import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    TextInputEditText etNombre;
    TextInputEditText etApellido;
    TextInputEditText etMail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);

        Button boton = binding.button;
        etNombre = binding.etnombre;
        etApellido = binding.etapellido;
        etMail = binding.etemail;

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = etNombre.getEditableText().toString();
                String apellido = etApellido.getEditableText().toString();
                String email = etMail.getEditableText().toString();

                if(nombre.isEmpty()){
                    etNombre.setError("Debe Ingresar Su nombre");
                }else if(!checkInput(nombre, 3)){
                    etNombre.setError("Su nombre debe tener más de tres caracteres");
                }

                if(apellido.isEmpty()){
                    etApellido.setError("Debe Ingresar Su Apellido");
                }else if(!checkInput(nombre, 2)){
                    etApellido.setError("Su nombre debe tener más de dos caracteres");
                }

                if(email.isEmpty()){
                    etMail.setError("Debe Ingresar Su E-mail");
                }else if(checkEmail(email)==false){
                    etMail.setError("Su email NO es válido");
                }



            }
        });
    }



    private boolean checkInput(String nombre, int n) {
        if (nombre.length() > n) {
            return true;
        } else {
            return false;
        }

    }

    private boolean checkEmail(String email) {
            String regex = "\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
    }
}




/*
REGEX EMAIL
\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b

 String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
 */