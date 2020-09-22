package com.electiva3.proyecto_android_electiva3.flujoUsuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.electiva3.proyecto_android_electiva3.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class activity_lista_usuarios extends AppCompatActivity
{
    private ListView lvlista;
    private FloatingActionButton fabAgregarUsuario;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);

        lvlista = findViewById(R.id.lvlista);
        fabAgregarUsuario = findViewById(R.id.fabAgregarUsuario);

        lvlista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent( getApplicationContext() , activity_actualizar_usuario.class);
                startActivity(i);
            }
        });


        fabAgregarUsuario.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( getApplicationContext() , activity_new_usuario.class);
                startActivity(i);
                finish();
            }
        });




    }
}
