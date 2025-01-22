package com.ben.nicestart2;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import fragments.HomeFragment;
import fragments.ProfileFragment;
import fragments.SearchFragment;

public class Main_Bn extends AppCompatActivity {

    // Declarar los fragmentos fuera de onCreate
    private final Fragment homeFragment = new HomeFragment();
    private final Fragment searchFragment = new SearchFragment();
    private final Fragment profileFragment = new ProfileFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bn);

        // Inicializa el BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Setea el item por defecto (el primero)
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, homeFragment).commit();
        }

        // Setea el listener para los cambios de selección
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                // Usamos un "if" en lugar de un "switch"
                if (item.getItemId() == R.id.navigation_home) {
                    selectedFragment = homeFragment;
                } else if (item.getItemId() == R.id.navigation_search) {
                    selectedFragment = searchFragment;
                } else if (item.getItemId() == R.id.navigation_profile) {
                    selectedFragment = profileFragment;
                }

                // Reemplaza el fragmento actual si se seleccionó uno
                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, selectedFragment).commit();
                }

                return true;
            }
        });
    }
}
