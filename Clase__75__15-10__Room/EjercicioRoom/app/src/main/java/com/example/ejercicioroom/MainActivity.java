package com.example.ejercicioroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.View;

import com.example.ejercicioroom.databinding.ActivityMainBinding;
import com.example.ejercicioroom.viewmodel.ProductoViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    NavController navController;
    BottomNavigationView bottomNav;
    ProductoViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        bottomNav = binding.bottomNav;
        viewModel = new ViewModelProvider(this).get(ProductoViewModel.class);


        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        assert navHostFragment != null;
        navController = navHostFragment.getNavController();

        bottomNav.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case(R.id.go_to_addFragment):
                    navController.navigate(R.id.addFragment);
                    break;

                    case (R.id.go_to_listFragment):
                    navController.navigate(R.id.listFragment);
                    break;

                case (R.id.go_to_addMarcaFragment):
                    navController.navigate(R.id.addMarcaFragment);
                    break;

                case (R.id.go_to_searchFragment):
                    navController.navigate(R.id.buscarFragment);
                    break;

            }
            return true;

        });





    }


}