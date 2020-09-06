package com.electiva3.proyecto_android_electiva3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class activity_lista_usuarios extends AppCompatActivity
{
    private ListView listView;
    private FloatingActionButton fabAgregarUsuario;

    private FrameLayout idPrueba;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);

        listView = findViewById(R.id.lvUsuarios);
        fabAgregarUsuario = findViewById(R.id.fabAgregarUsuario);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
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
