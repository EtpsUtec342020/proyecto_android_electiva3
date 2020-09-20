package com.electiva3.proyecto_android_electiva3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.electiva3.proyecto_android_electiva3.adapters.DetalleOrdenAdapter;
import com.electiva3.proyecto_android_electiva3.adapters.OrdenAdapter;
import com.electiva3.proyecto_android_electiva3.entities.DetalleOrden;
import com.electiva3.proyecto_android_electiva3.entities.Orden;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class activity_ordenes extends AppCompatActivity {


    String title ="Ordenes";
    RecyclerView rvOrdenes;
    FloatingActionButton fabAgregarOrden;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordenes);

        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        rvOrdenes  =  findViewById(R.id.rvOrdenes);



        ArrayList<Orden> ordenes =   new ArrayList<>();

        ordenes.add(new Orden("#222","Jorge De La Cruz" , "Pendiente" , "22/09/2020" ));
        ordenes.add(new Orden("#223","Nestor Funes Patiño" , "Pendiente" , "22/09/2020" ));
        ordenes.add(new Orden("#224","Victor Garcia" , "Pendiente" , "22/09/2020" ));
        ordenes.add(new Orden("#225","Gabriela Najarro" , "Pendiente" , "22/09/2020" ));



        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvOrdenes.setLayoutManager(linearLayoutManager);

        OrdenAdapter ordenAdapter =  new OrdenAdapter(getApplicationContext() ,   ordenes );
        rvOrdenes.setAdapter(ordenAdapter);

    }

    @Override
    public void onBackPressed() {
        Intent intent= new Intent(getApplicationContext() , activity_admin_home.class);
        startActivity(intent);
        finish();

    }
}
