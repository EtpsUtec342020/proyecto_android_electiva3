package com.electiva3.proyecto_android_electiva3;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.electiva3.proyecto_android_electiva3.entities.Conexion;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseUser;

public class activity_principal extends AppCompatActivity {


    DrawerLayout drawerLayout;
    ImageView imageMenu;
    NavigationView navigationView;
    TextView tvUsuario;

    Conexion conexion = new Conexion();

    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        drawerLayout =  findViewById(R.id.drawer_layout);
        imageMenu =  findViewById(R.id.imageMenu);
        navigationView  =  findViewById(R.id.navigationView);


        //establecer la conexion con firebase
        conexion.inicializarFirabase(this);

        imageMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setItemIconTintList(null);


        final NavController navController = Navigation.findNavController( this , R.id.navHost);
        NavigationUI.setupWithNavController(  navigationView , navController);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();

                if (id==R.id.nav_cerrar_sesion){

                    //cerrar sesion
                    conexion.getAuth().signOut();

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{

                    NavigationUI.onNavDestinationSelected(item,navController);
                    drawerLayout.closeDrawer(GravityCompat.START);

                }
                return false;

            }
        });


    }
}
