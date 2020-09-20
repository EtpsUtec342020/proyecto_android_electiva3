package com.electiva3.proyecto_android_electiva3.flujoContrato;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.electiva3.proyecto_android_electiva3.R;

public class activity_actualizar_contrato extends AppCompatActivity
{
    private EditText txtNombre, txtVehiculo, txtPlan, txtDuracion, txtFechaA, txtFechaV, txtNumManto, txtCostoT;
    private Spinner spnEstado;
    private Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_contrato);

        txtNombre = findViewById(R.id.txtCliente);
        txtVehiculo = findViewById(R.id.txtVehiculo);
        txtPlan = findViewById(R.id.txtPlan);
        txtDuracion = findViewById(R.id.txtDuracion);
        txtFechaA = findViewById(R.id.txtFechaA);
        txtFechaV = findViewById(R.id.txtFechaV);
        txtNumManto = findViewById(R.id.txtNumManto);
        txtCostoT = findViewById(R.id.txtCostoT);
        spnEstado = findViewById(R.id.spnEstado);
        btnAgregar = findViewById(R.id.btnAgregar);
    }
}
