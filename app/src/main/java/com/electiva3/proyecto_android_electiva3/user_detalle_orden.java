package com.electiva3.proyecto_android_electiva3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import com.electiva3.proyecto_android_electiva3.userfragments.FragmentContratoOrden;
import com.electiva3.proyecto_android_electiva3.userfragments.FragmentDetalleOrden;
import com.electiva3.proyecto_android_electiva3.userfragments.FragmentOrdenOrden;
import com.electiva3.proyecto_android_electiva3.userfragments.FragmentVehiculoOrden;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class user_detalle_orden  extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detalle_order);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        bottomNavigationView = findViewById(R.id.bottom_navigation);


        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);


        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , ( new FragmentContratoOrden()))
                .commit();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.page_1:
                            selectedFragment  = new FragmentContratoOrden();
                            break;

                        case R.id.page_2:
                            selectedFragment  =  new FragmentVehiculoOrden();
                            break;

                        case R.id.page_3:
                            selectedFragment  =  new FragmentOrdenOrden();
                            break;

                        case R.id.page_4:
                            selectedFragment  =  new FragmentDetalleOrden();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment)
                            .commit();

                    return true;
                }
            };

}
