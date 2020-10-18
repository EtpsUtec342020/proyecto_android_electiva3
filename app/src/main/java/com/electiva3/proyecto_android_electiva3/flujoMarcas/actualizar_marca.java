package com.electiva3.proyecto_android_electiva3.flujoMarcas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.electiva3.proyecto_android_electiva3.R;
import com.electiva3.proyecto_android_electiva3.adapters.ModelosAdapter;
import com.electiva3.proyecto_android_electiva3.entities.Conexion;
import com.electiva3.proyecto_android_electiva3.entities.Marca;
import com.electiva3.proyecto_android_electiva3.entities.Modelo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class actualizar_marca extends AppCompatActivity {

    private ArrayList<Modelo> modelos;
    private Marca marca;
    Button btnActualizarMarca;
    RecyclerView rvModelosMarcas;
    EditText edtMarca;
    Spinner spnModelo , spnEstado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_marca);


        marca =  new Marca();

        String keyMarca = getIntent().getStringExtra("keyMarca");


        modelos  =  new ArrayList<>();
        rvModelosMarcas =  findViewById(R.id.rvModelosMarca);
        btnActualizarMarca = findViewById(R.id.btnActualizarMarca);
        edtMarca =  findViewById(R.id.edtMarca);
        spnModelo =  findViewById(R.id.spnModelo);
        spnEstado =  findViewById(R.id.spnEstado);


        LinearLayoutManager linearLayoutManager =  new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation( LinearLayoutManager.VERTICAL   );
        rvModelosMarcas.setLayoutManager( linearLayoutManager );

        obtenerInformacionMarca(keyMarca);
        listarModelosMarca(keyMarca);

    }


    public void obtenerInformacionMarca(String keyMarca){

        final DatabaseReference   marcas =     FirebaseDatabase.getInstance().getReference().child("marcas").child(keyMarca);

        marcas.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                DataSnapshot ds = snapshot;
                if (ds.exists())
                {

                    System.out.println("Reference Marca");

                    marca.setKey(ds.getKey());
                    marca.setMarca(   ds.child("marca").getValue().toString()  );
                    marca.setEstado(  ds.child("estado").getValue().toString()   );

                    edtMarca.setText(marca.getMarca());



                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    public void listarModelosMarca(String keyMarca){



        FirebaseDatabase.getInstance().getReference().child("modelos").getRef().orderByChild("marca").equalTo(keyMarca).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.exists()){

                    modelos.clear();

                    for( DataSnapshot ds: snapshot.getChildren()){

                        String key = ds.getKey();
                        String modelo = ds.child("modelo").getValue().toString();
                        String estado = ds.child("estado").getValue().toString();
                        String keyMarca =  ds.child("marca").getValue().toString();
                        modelos.add(new Modelo(key , modelo , estado ,  keyMarca));

                    }

                    ModelosAdapter modelosAdapter =  new ModelosAdapter( getApplicationContext() , modelos);
                    rvModelosMarcas.setAdapter(modelosAdapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}