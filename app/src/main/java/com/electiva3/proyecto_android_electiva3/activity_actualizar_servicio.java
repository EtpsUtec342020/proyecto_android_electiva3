package com.electiva3.proyecto_android_electiva3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class activity_actualizar_servicio extends AppCompatActivity
{

    private TextView txtTitulo, txtDescripcion, txtCosto;
    private Spinner spnCategoria, spnEstado;
    private Button btnActualizar, btnCancelar;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_servicio);

        txtTitulo = findViewById(R.id.edtTitulo);
        txtDescripcion = findViewById(R.id.edtDescripcion);
        txtCosto = findViewById(R.id.edtCosto);
        spnCategoria = findViewById(R.id.spnCategoria);
        btnActualizar = findViewById(R.id.btnActualizar);
        btnCancelar = findViewById(R.id.btnCancelar);


        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent( getApplicationContext() , activity_lista_servicios.class);
                startActivity(i);
                finish();
            }
        });
    }
}
