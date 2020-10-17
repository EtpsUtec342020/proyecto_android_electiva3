package com.electiva3.proyecto_android_electiva3.flujoUsuario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.electiva3.proyecto_android_electiva3.R;
import com.electiva3.proyecto_android_electiva3.activity_principal;
import com.electiva3.proyecto_android_electiva3.adapters.UsuariosAdapter;
import com.electiva3.proyecto_android_electiva3.entities.Conexion;
import com.electiva3.proyecto_android_electiva3.entities.Usuario;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class activity_lista_usuarios extends AppCompatActivity
{
    private FloatingActionButton fabAgregarUsuario;
    private RecyclerView rvUsuarios;
    private String title="Lista Usuarios";
    private ArrayList<Usuario> usuList = new ArrayList<>();

    Conexion conexion = new Conexion();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);


       rvUsuarios = findViewById(R.id.rvUsuarios);
       fabAgregarUsuario = findViewById(R.id.fabAgregarUsuario);

        getSupportActionBar().setTitle(title);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager( getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvUsuarios.setLayoutManager(linearLayoutManager);
       conexion.inicializarFirabase(this);
       ListarUsuarios();

        fabAgregarUsuario.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( getApplicationContext() , activity_new_usuario.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void ListarUsuarios()
    {
        conexion.getDatabaseReference().child("usuarios").addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    usuList.clear();
                    for (DataSnapshot ds : snapshot.getChildren()) {
                        String correo = ds.child("correo").getValue().toString();
                        String estado = ds.child("estado").getValue().toString();
                        String nombre = ds.child("nombre").getValue().toString();
                        String key = ds.getKey();

                        usuList.add(new Usuario(key, nombre, correo, estado));
                    }

                    final UsuariosAdapter usuarioAdapter = new UsuariosAdapter(getApplicationContext(), usuList);

                    usuarioAdapter.SetOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                          String idUsuario =  usuList.get(rvUsuarios.getChildAdapterPosition(v)).getKey();
                            Intent intent  =  new Intent(getApplicationContext(),   activity_actualizar_usuario.class  );
                            intent.putExtra("id", idUsuario);
                            startActivity(intent);
                            finish();
                        }
                    });

                    rvUsuarios.setAdapter(usuarioAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent= new Intent(getApplicationContext() , activity_principal.class);
        startActivity(intent);
        finish();
    }
}
