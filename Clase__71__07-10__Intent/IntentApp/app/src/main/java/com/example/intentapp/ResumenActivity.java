package com.example.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.intentapp.databinding.ActivityMainBinding;
import com.example.intentapp.databinding.ActivityResumenBinding;

public class ResumenActivity extends AppCompatActivity {
    ActivityResumenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityResumenBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //Registro registro = (Registro) getIntent().getSerializableExtra("registro");
        Registro registro = (Registro) getIntent().getSerializableExtra("registro");

        

        TextView tvnombre = binding.textView;
        TextView tvapellido = binding.textView;
        TextView tvemail = binding.textView;
        TextView tvpassword = binding.textView;


        tvnombre.setText(registro.getName());
    }
}