package com.electiva3.proyecto_android_electiva3.flujoUsuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.electiva3.proyecto_android_electiva3.R;
import com.electiva3.proyecto_android_electiva3.entities.Conexion;
import com.electiva3.proyecto_android_electiva3.entities.Usuario;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class activity_new_usuario extends AppCompatActivity
{

    private EditText edtNombre, edtDui, edtNit, edtLicencia, edtTelefono, edtDireccion, edtCorreo;
    private Button btnAgregar, btnCancelar;
    private Spinner spnRol;

    Usuario usuario = new Usuario();

    Conexion conexion = new Conexion();


    
   // FirebaseDatabase firabaseDataBase;
   // DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_usuario);

     //   inicializarFirabase();

        conexion.inicializarFirabase(this);

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


                if(nombre.isEmpty()) {
                    edtNombre.setError("Campo Requerido");
                }
                else if(dui.isEmpty()) {
                    edtDui.setError("Campo Requerido");
                }
                else if(nit.isEmpty()) {
                    edtNit.setError("Campo Requerido");
                }
                else if(licencia.isEmpty()) {
                    edtLicencia.setError("Campo Requerido");
                }
                else if(correo.isEmpty()) {
                    edtCorreo.setError("Campo Requerido");
                }
                else if(telefono.isEmpty()) {
                    edtTelefono.setError("Campo Requerido");
                }
                else if(direccion.isEmpty()) {
                    edtDireccion.setError("Campo Requerido");
                }
                else
                {
                    usuario.setKeyUsuario(UUID.randomUUID().toString());
                    usuario.setNombre(nombre);
                    usuario.setDui(Integer.parseInt(dui));
                    usuario.setNit(Integer.parseInt(nit));
                    usuario.setLicencia(Integer.parseInt(licencia));
                    usuario.setCorreo(correo);
                    usuario.setTelefono(Integer.parseInt(telefono));
                    usuario.setDireccion(direccion);
                    usuario.setRol("administrador");
                    usuario.setEstadoUsuario("Activo");

                    conexion.getDatabaseReference().child("usuarios").child(usuario.getKeyUsuario()).setValue(usuario);

                   Toast.makeText(getApplicationContext(), "Agredado", Toast.LENGTH_SHORT).show();

                    Intent usuarios = new Intent(getApplicationContext() ,   activity_lista_usuarios.class);
                    startActivity(usuarios);
                    finish();
                }

            }
        });


    }

   /* public void inicializarFirabase()
    {
        FirebaseApp.initializeApp(this);
        firabaseDataBase = FirebaseDatabase.getInstance();
        databaseReference = firabaseDataBase.getReference();
    }*/
}
