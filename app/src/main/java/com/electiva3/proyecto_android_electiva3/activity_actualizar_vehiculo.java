package com.electiva3.proyecto_android_electiva3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class activity_actualizar_vehiculo extends AppCompatActivity
{
    private ImageView imvImagen;
    private EditText txtPlaca, txtChasis, txtAnio, txtColor;
    private Spinner spnMarca, spnModelo, spnEstado;
    private Button btnActualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_vehiculo);

        imvImagen = findViewById(R.id.imvImagen);
        txtPlaca = findViewById(R.id.edtPlaca);
        txtChasis = findViewById(R.id.edtChasis);
        txtAnio = findViewById(R.id.edtAnio);
        txtColor = findViewById(R.id.edtColor);
        spnMarca = findViewById(R.id.spnMarca);
        spnModelo = findViewById(R.id.spnModelo);
        btnActualizar = findViewById(R.id.btnAgrear);
    }
}
