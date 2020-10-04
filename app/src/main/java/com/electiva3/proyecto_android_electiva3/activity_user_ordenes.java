package com.electiva3.proyecto_android_electiva3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import com.electiva3.proyecto_android_electiva3.useradapter.OrdenAdapter;
import com.electiva3.proyecto_android_electiva3.userentities.UserOrden;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class activity_user_ordenes extends AppCompatActivity {

    String title ="Ordenes";
    RecyclerView rvOrdenes;
    FloatingActionButton fabAgregarOrden;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_ordenes);

        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        rvOrdenes  =  findViewById(R.id.rvOrdenes);

        ArrayList<UserOrden> ordenes =   new ArrayList<>();

        ordenes.add(new UserOrden("#222","Jorge De La Cruz"));
        ordenes.add(new UserOrden("#223","Nestor Funes Patiño"));
        ordenes.add(new UserOrden("#224","Victor Garcia"));
        ordenes.add(new UserOrden("#225","Gabriela Najarro"));

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvOrdenes.setLayoutManager(linearLayoutManager);

        OrdenAdapter ordenAdapter =  new OrdenAdapter(getApplicationContext() ,ordenes);
        rvOrdenes.setAdapter(ordenAdapter);

    }

    @Override
    public void onBackPressed() {
        //Intent intent= new Intent(getApplicationContext() , activity_admin_home.class);
        //startActivity(intent);
        //finish();

    }
}
