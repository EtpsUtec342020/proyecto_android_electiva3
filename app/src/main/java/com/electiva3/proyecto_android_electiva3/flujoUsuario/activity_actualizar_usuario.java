package com.electiva3.proyecto_android_electiva3.flujoUsuario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.electiva3.proyecto_android_electiva3.R;

public class activity_actualizar_usuario extends AppCompatActivity
{
    private EditText edtNombre, edtDui, edtNit, edtLicencia, edtTelefono, edtDireccion, edtCorreo, edtContrasena, edtContrasena2;
    private Button btnActualizar;
    private Spinner spnRol, spnEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_usuario);

        edtNombre = findViewById(R.id.edtNombre);
        edtDui  = findViewById(R.id.edtDui);
        edtNit = findViewById(R.id.edtNit);
        edtLicencia = findViewById(R.id.edtLicencia);
        edtCorreo = findViewById(R.id.edtCorreo);
        edtTelefono = findViewById(R.id.edtTelefono);
        edtDireccion = findViewById(R.id.edtDireccion);
        edtContrasena = findViewById(R.id.edtContrasena);
        edtContrasena2 = findViewById(R.id.edtContrasena2);
        spnEstado = findViewById(R.id.spnEstado);
        spnRol =  findViewById(R.id.spnRol);
        btnActualizar = findViewById(R.id.btnCrear);
    }
}
