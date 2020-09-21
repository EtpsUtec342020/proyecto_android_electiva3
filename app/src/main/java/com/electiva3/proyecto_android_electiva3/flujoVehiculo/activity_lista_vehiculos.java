package com.electiva3.proyecto_android_electiva3.flujoVehiculo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.electiva3.proyecto_android_electiva3.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class activity_lista_vehiculos extends AppCompatActivity
{
    private ListView lvlista;
    private FloatingActionButton fabAgregarVehiculo;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_vehiculos);

        lvlista = findViewById(R.id.lvlista);
        fabAgregarVehiculo = findViewById(R.id.fabAgregarVehiculo);

        lvlista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent( getApplicationContext() , activity_actualizar_vehiculo.class);
                startActivity(i);
            }
        });


        fabAgregarVehiculo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( getApplicationContext() , activity_new_vehiculo.class);
                startActivity(i);
                finish();
            }
        });

    }
}
