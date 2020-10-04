package com.electiva3.proyecto_android_electiva3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.electiva3.proyecto_android_electiva3.R;
import com.google.android.material.navigation.NavigationView;

public class activity_principal extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView imageMenu;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        drawerLayout =  findViewById(R.id.drawer_layout);
        imageMenu =  findViewById(R.id.imageMenu);
        navigationView  =  findViewById(R.id.navigationView);

        imageMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setItemIconTintList(null);

        NavController navController = Navigation.findNavController( this , R.id.navHost);
        NavigationUI.setupWithNavController(navigationView , navController);

    }
}
