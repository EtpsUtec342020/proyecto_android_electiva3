package com.electiva3.proyecto_android_electiva3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class activity_new_vehiculo extends AppCompatActivity
{
    private  ImageView imvImagen;
    private EditText edtPlaca, edtChasis, edtAnio, edtColor;
    private Spinner spnMarca, spnModelo;
    private Button btnAgregar;
    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_vehiculo);

        imvImagen = findViewById(R.id.imvImagen);
        edtPlaca = findViewById(R.id.edtPlaca);
        edtChasis = findViewById(R.id.edtChasis);
        edtAnio = findViewById(R.id.edtAnio);
        edtColor = findViewById(R.id.edtColor);
        spnMarca = findViewById(R.id.spnMarca);
        spnModelo = findViewById(R.id.spnModelo);
        btnAgregar = findViewById(R.id.btnActualizar);
    }
}
