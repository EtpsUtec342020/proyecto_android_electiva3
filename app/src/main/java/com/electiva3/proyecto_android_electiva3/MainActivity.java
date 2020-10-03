package com.electiva3.proyecto_android_electiva3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.electiva3.proyecto_android_electiva3.entities.Conexion;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity<CollectionReference> extends AppCompatActivity
{
    private EditText edtCorreo, edtContrasena;
    private Button btnIngresar;

    FirebaseAuth auth;
    DatabaseReference database;

    Conexion conexion = new Conexion();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        edtCorreo =  findViewById(R.id.edtCorreo);
        edtContrasena =  findViewById(R.id.edtContrasena);

        btnIngresar = findViewById(R.id.btnRegistrar);

        auth = FirebaseAuth.getInstance();
        database  = FirebaseDatabase.getInstance().getReference();

        conexion.inicializarFirabase(this);


        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login(){

        String email =  edtCorreo.getText().toString();
        String password =  edtContrasena.getText().toString();

        if(email.isEmpty()){
            edtCorreo.setError("Campo requerido");
        }else  if(password.isEmpty()){
            edtContrasena.setError("Campo requerido");
        }else{
            //Toast.makeText(getApplicationContext(), "Login is successfull", Toast.LENGTH_SHORT).show();
            auth.signInWithEmailAndPassword(email , password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful()){
                        Intent i = new Intent(getApplicationContext(), activity_principal.class);
                        startActivity(i);
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(), "Contraseña o usuario incorrectos", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

}
