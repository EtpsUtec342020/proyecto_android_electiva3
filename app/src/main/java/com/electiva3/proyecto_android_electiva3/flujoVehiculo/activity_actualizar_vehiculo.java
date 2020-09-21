package com.electiva3.proyecto_android_electiva3.flujoVehiculo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.electiva3.proyecto_android_electiva3.R;

public class activity_actualizar_vehiculo extends AppCompatActivity
{
    private ImageView imvImagen;
    private EditText edtCliente, edtPlaca, edtChasis, edtAnio, edtColor;
    private Spinner spnMarca, spnModelo, spnEstado;
    private Button btnActualizar, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_vehiculo);

        imvImagen = findViewById(R.id.imvImagen);
        edtCliente = findViewById(R.id.edtCliente);
        edtPlaca = findViewById(R.id.edtPlaca);
        edtChasis = findViewById(R.id.edtChasis);
        edtCliente = findViewById(R.id.edtAnio);
        edtCliente = findViewById(R.id.edtColor);
        spnMarca = findViewById(R.id.spnMarca);
        spnModelo = findViewById(R.id.spnModelo);
        btnActualizar = findViewById(R.id.btnActualizar);
        btnCancelar = findViewById(R.id.btnCancelar);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vehiculos = new Intent(getApplicationContext() ,   activity_lista_vehiculos.class);
                startActivity(vehiculos);
                finish();
            }
        });

    }
}
