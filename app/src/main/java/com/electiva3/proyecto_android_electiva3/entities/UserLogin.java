package com.electiva3.proyecto_android_electiva3.entities;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class UserLogin {

    public String estado1 = "1";
    private String rol;
    private String nombre;
    private String correo;

    public  UserLogin() {
    }

    public void Login (@NotNull Conexion conexion, @NotNull FirebaseUser user)
    {
        Query q = conexion.getDatabaseReference().child("usuarios").child(user.getUid());

        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataSnapshot ds;
                ds = snapshot;

                if (ds.exists()) {

                    Usuario usuario = ds.getValue(Usuario.class);

                    //  estado3 = usuario.getEstado();
                    //llenando el objeto
                    //  estado3 = ds.child("estado").getValue().toString();
                    nombre = ds.child("nombre").getValue().toString();
                    correo = ds.child("correo").getValue().toString();
                    rol = ds.child("rol").getValue().toString();
                }


                System.out.println();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }




    public void prueba()
    {
        System.out.println(estado1);
    }


}
