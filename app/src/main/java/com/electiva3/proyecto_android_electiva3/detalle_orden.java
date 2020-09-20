package com.electiva3.proyecto_android_electiva3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.electiva3.proyecto_android_electiva3.fragments.FragmentClienteOrden;
import com.electiva3.proyecto_android_electiva3.fragments.FragmentOrdenOrden;
import com.electiva3.proyecto_android_electiva3.fragments.FragmentVehiculoOrden;
import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class detalle_orden extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_orden);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);


        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , ( new FragmentClienteOrden()   ))
                .commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.page_1:
                            selectedFragment  = new FragmentClienteOrden();
                            break;

                        case R.id.page_2:
                            selectedFragment  =  new FragmentOrdenOrden();
                            break;

                        case R.id.page_3:
                            selectedFragment  =  new FragmentVehiculoOrden();
                            break;
                    }


                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , selectedFragment)
                    .commit();

                    return true;
                }
            };
}
