package com.electiva3.proyecto_android_electiva3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class activity_lista_contratos extends AppCompatActivity
{

    private ListView lvlista;
    private FloatingActionButton fabAgregarConcontrato;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contratos);

        lvlista = findViewById(R.id.lvlista);
        fabAgregarConcontrato = findViewById(R.id.fabAgregarContrato);

        lvlista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent( getApplicationContext() , activity_actualizar_contrato.class);
                startActivity(i);
            }
        });


        fabAgregarConcontrato.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( getApplicationContext() , activity_new_contrato.class);
                startActivity(i);
                finish();
            }
        });
    }
}
