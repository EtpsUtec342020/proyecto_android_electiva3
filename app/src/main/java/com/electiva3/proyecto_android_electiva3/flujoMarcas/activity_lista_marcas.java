package com.electiva3.proyecto_android_electiva3.flujoMarcas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.electiva3.proyecto_android_electiva3.R;
import com.electiva3.proyecto_android_electiva3.adapters.MarcasAdapter;
import com.electiva3.proyecto_android_electiva3.entities.Conexion;
import com.electiva3.proyecto_android_electiva3.entities.Marca;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class activity_lista_marcas extends AppCompatActivity {

    private FloatingActionButton fbAgregarMarca;
    private DatabaseReference databaseReference;
    private RecyclerView rvMarcas;
    private ArrayList<Marca> marcas;
    private Conexion conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_marcas);

        rvMarcas =  findViewById(R.id.rvMarcas);

        conexion =  new Conexion();
        marcas =  new ArrayList<>();
        databaseReference =  FirebaseDatabase.getInstance().getReference().child("marcas");

        LinearLayoutManager layoutManager =  new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMarcas.setLayoutManager(layoutManager);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    marcas.clear();
                    for(  DataSnapshot ds:  snapshot.getChildren()  ){
                        String key    = ds.getKey();
                        String marca  = ds.child("marca").getValue().toString();
                        String estado = ds.child("estado").getValue().toString();
                        marcas.add( new Marca(key,marca,estado) );
                    }

                    MarcasAdapter  marcasAdapter =  new MarcasAdapter(  getApplicationContext() , marcas );
                    rvMarcas.setAdapter(marcasAdapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}