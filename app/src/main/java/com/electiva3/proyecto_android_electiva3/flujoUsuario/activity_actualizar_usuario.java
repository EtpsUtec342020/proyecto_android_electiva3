package com.electiva3.proyecto_android_electiva3.flujoUsuario;

import androidx.annotation.NonNull;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.EventListener;

public class activity_actualizar_usuario extends AppCompatActivity
{
    private EditText edtNombre, edtDui, edtNit, edtLicencia, edtTelefono, edtDireccion, edtCorreo, edtContrasena, edtContrasena2;
    private Button btnActualizar, btnCancelar;
    private Spinner spnRol, spnEstado;

    private String id;
    Conexion conexion = new Conexion();
    Usuario usuario = new Usuario();

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
        btnActualizar = findViewById(R.id.btnActualizar);
        btnCancelar = findViewById(R.id.btnCancelar);

        //establecer la conexion
        conexion.inicializarFirabase(this);
        //recuperar el id del objeto
        id = getIntent().getStringExtra("id");

        MostrarDatos();


        btnActualizar.setOnClickListener(new View.OnClickListener()
        {
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
                String password = edtContrasena.getText().toString();
                String password2 = edtContrasena2.getText().toString();

                if(password == password2)
                {
                    if(usuario.getNombre() != nombre && usuario.getDui() != dui)
                    {

                        conexion.getDatabaseReference().child("usuarios").child(id).updateChildren(usuario.getUsuario());
                        Intent usuarios = new Intent(getApplicationContext() ,   activity_lista_usuarios.class);
                        startActivity(usuarios);
                        finish();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Las Contraseñas no son Iguales", Toast.LENGTH_LONG).show();
                }

            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent usuarios = new Intent(getApplicationContext() ,   activity_lista_usuarios.class);
                startActivity(usuarios);
                finish();
            }
        });

    }

    public void MostrarDatos()
    {
        conexion.getDatabaseReference().child("usuarios").child(id).addValueEventListener(new ValueEventListener()
        {
                DataSnapshot ds;
                @Override
                 public void onDataChange(@NonNull DataSnapshot snapshot) {

                    ds = snapshot;
                    if (ds.exists())
                    {
                        //llenando el objeto
                        usuario.setNombre(ds.child("nombre").getValue().toString());
                        usuario.setDui(ds.child("dui").getValue().toString());
                        usuario.setNit(ds.child("nit").getValue().toString());
                        usuario.setLicencia(ds.child("licencia").getValue().toString());
                        usuario.setCorreo(ds.child("correo").getValue().toString());
                        usuario.setDireccion(ds.child("direccion").getValue().toString());
                        usuario.setTelefono(ds.child("telefono").getValue().toString());
                        usuario.setEstado(ds.child("estado").getValue().toString());
                        usuario.setRol(ds.child("rol").getValue().toString());


                        //mostrando en vista
                        edtNombre.setText(usuario.getNombre());
                        edtDui.setText(usuario.getDui());
                        edtNit.setText(usuario.getNit());
                        edtLicencia.setText(usuario.getLicencia());
                        edtCorreo.setText(usuario.getCorreo());
                        edtTelefono.setText(usuario.getTelefono());
                        edtDireccion.setText(usuario.getDireccion());

                    }

                 }
                 @Override
                 public void onCancelled(@NonNull DatabaseError error) {

                  }
        });
    }
}
