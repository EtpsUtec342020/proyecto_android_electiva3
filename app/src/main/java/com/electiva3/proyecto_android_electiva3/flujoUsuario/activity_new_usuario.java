package com.electiva3.proyecto_android_electiva3.flujoUsuario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.electiva3.proyecto_android_electiva3.R;
import com.electiva3.proyecto_android_electiva3.entities.Conexion;
import com.electiva3.proyecto_android_electiva3.entities.GeneradorPassword;
import com.electiva3.proyecto_android_electiva3.entities.Rol;
import com.electiva3.proyecto_android_electiva3.entities.Usuario;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;
import java.util.UUID;

public class activity_new_usuario extends AppCompatActivity
{

    private EditText edtNombre, edtDui, edtNit, edtLicencia, edtTelefono, edtDireccion, edtCorreo;
    private Button btnAgregar, btnCancelar;
    private Spinner spnRol;
    private AlertDialog.Builder builder;

    private String title="Agregar Nuevo Usuario";
    private ArrayList<Rol> roleslist = new ArrayList<>();

    Conexion conexion = new Conexion();
    Usuario usuario = new Usuario();
    GeneradorPassword pass = new GeneradorPassword();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_usuario);

        getSupportActionBar().setTitle(title);

        builder= new AlertDialog.Builder(this);
        builder.setTitle("Usuario creado exitosamente!!");
        builder.setCancelable(false);
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i=  new Intent( getApplicationContext() , activity_lista_usuarios.class);
                startActivity(i);
                finish();
            }
        });

        //inicializando conexion
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
                    SimpleDateFormat dfDate_day= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    String dt="";
                    Calendar c = Calendar.getInstance();
                    dt = dfDate_day.format(c.getTime());

                    String key = (UUID.randomUUID().toString());
                    usuario.setNombre(nombre);
                    usuario.setDui(dui);
                    usuario.setNit(nit);
                    usuario.setLicencia(licencia);
                    usuario.setCorreo(correo);
                    usuario.setPassword(pass.getPassword());
                    usuario.setTelefono(telefono);
                    usuario.setDireccion(direccion);
                    usuario.setRol("administrador");
                    usuario.setEstado("Activo");
                    usuario.setFechaRegistro(dt.toString());

                    conexion.getDatabaseReference().child("usuarios").child(key).setValue(usuario);

                    builder.setMessage("Usuario: "+usuario.getCorreo()+"\nPassword: "+usuario.getPassword()+"\nFecha Creacion: "+usuario.getFechaRegistro());
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                }

            }
        });

    }

    public void Roles()
    {
        conexion.getDatabaseReference().child("rol").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists())
                {
                    roleslist.clear();
                    for (DataSnapshot ds : snapshot.getChildren()) {
                        String key = ds.getKey();
                        String rol = Objects.requireNonNull(ds.getValue()).toString();
                         roleslist.add(new Rol(key, rol));
                    }
                    RolAdapter rolAdapter = new RolAdapter(getApplicationContext() , R.layout.cus, roleslist);

                    spnRol.setAdapter(rolAdapter);
                  //  spnRol.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, roleslist));
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent= new Intent(getApplicationContext() , activity_lista_usuarios.class);
        startActivity(intent);
        finish();

    }

}