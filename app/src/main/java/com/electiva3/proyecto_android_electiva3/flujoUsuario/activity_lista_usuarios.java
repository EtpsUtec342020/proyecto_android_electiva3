package com.electiva3.proyecto_android_electiva3.flujoUsuario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.electiva3.proyecto_android_electiva3.R;
import com.electiva3.proyecto_android_electiva3.activity_principal;
import com.electiva3.proyecto_android_electiva3.adapters.UsuariosAdapter;
import com.electiva3.proyecto_android_electiva3.entities.Usuario;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class activity_lista_usuarios extends AppCompatActivity
{

    private FloatingActionButton fabAgregarUsuario;
    private RecyclerView rvUsuarios;
    private String title="Lista Usuarios";

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

        UsuariosAdapter usuarioAdapter =  new UsuariosAdapter( getApplicationContext(), buildUsuarios());
        rvUsuarios.setAdapter( usuarioAdapter  );

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

    public ArrayList<Usuario> buildUsuarios(){
        ArrayList<Usuario>  usuarios =  new ArrayList<Usuario>();
        usuarios.add(new Usuario("jorge de la Cruz", 0000000, 00000000, 00000000,
                "correo@gmail.com", 2222222, "direccion", "admin", "activo"));
        usuarios.add(new Usuario("Gabriela", 0000000, 00000000, 00000000,
                "correo@gmail.com", 2222222, "direccion", "admin", "activo"));
        usuarios.add(new Usuario("Victor Garcia", 0000000, 00000000, 00000000,
                "correo@gmail.com", 2222222, "direccion", "admin", "activo"));
        return usuarios;
    }

    @Override
    public void onBackPressed() {
        Intent intent= new Intent(getApplicationContext() , activity_principal.class);
        startActivity(intent);
        finish();
    }
}
