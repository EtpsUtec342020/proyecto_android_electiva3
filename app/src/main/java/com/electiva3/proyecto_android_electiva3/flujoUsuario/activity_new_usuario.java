package com.electiva3.proyecto_android_electiva3.flujoUsuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.electiva3.proyecto_android_electiva3.R;

public class activity_new_usuario extends AppCompatActivity
{

    private EditText edtNombre, edtDui, edtNit, edtLicencia, edtTelefono, edtDireccion, edtCorreo;
    private Button btnAgregar, btnCancelar;
    private Spinner spnRol;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_usuario);

        edtNombre = findViewById(R.id.edtNombre);
        edtDui  = findViewById(R.id.edtDui);
        edtNit = findViewById(R.id.edtNit);
        edtLicencia = findViewById(R.id.edtLicencia);
        edtCorreo = findViewById(R.id.edtCorreo);
        edtTelefono = findViewById(R.id.edtTelefono);
        edtDireccion = findViewById(R.id.edtDireccion);
        spnRol =  findViewById(R.id.spnRol);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnCancelar = findViewById(R.id.btnCancelar);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent usuarios = new Intent(getApplicationContext() ,   activity_lista_usuarios.class);
                startActivity(usuarios);
                finish();
            }
        });

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String nombre = edtNombre.getText().toString();
                String dui = edtDui.getText().toString();
                String nit = edtNit.getText().toString();
                String licencia = edtLicencia.getText().toString();
                String correo = edtCorreo.getText().toString();
                String telefono = edtTelefono.getText().toString();
                String direccion = edtDireccion.getText().toString();

                if(TextUtils.isEmpty(nombre)) {
                    edtNombre.setError("Campo Requerido");
                }
                else if(TextUtils.isEmpty(dui)) {
                    edtDui.setError("Campo Requerido");
                }
                else if(TextUtils.isEmpty(nit)) {
                    edtNit.setError("Campo Requerido");
                }
                else if(TextUtils.isEmpty(licencia)) {
                    edtLicencia.setError("Campo Requerido");
                }
                else if(TextUtils.isEmpty(correo)) {
                    edtCorreo.setError("Campo Requerido");
                }
                else if(TextUtils.isEmpty(telefono)) {
                    edtTelefono.setError("Campo Requerido");
                }
                else if(TextUtils.isEmpty(direccion)) {
                    edtDireccion.setError("Campo Requerido");
                }


            }
        });


    }
}
