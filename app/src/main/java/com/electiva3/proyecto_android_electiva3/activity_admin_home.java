package com.electiva3.proyecto_android_electiva3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class activity_admin_home extends AppCompatActivity implements View.OnClickListener
{
    ImageView imgUsuario, imgContrato, imgMarca, imgVehiculo, imgServicio, imgPlan, imgOrdenServicio, imgReserva;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        imgUsuario = findViewById(R.id.imgUsuario);
        imgContrato = findViewById(R.id.imgContrato);
        imgMarca = findViewById(R.id.imgMarca);
        imgVehiculo = findViewById(R.id.imgVehiculo);
        imgServicio = findViewById(R.id.imgServicio);
        imgPlan = findViewById(R.id.imgPlan);
        imgOrdenServicio = findViewById(R.id.imgOrdenServicio);
        imgReserva = findViewById(R.id.imgReserva);

        imgUsuario.setOnClickListener(this);
        imgContrato.setOnClickListener(this);
        imgMarca.setOnClickListener(this);
        imgVehiculo.setOnClickListener(this);
        imgServicio.setOnClickListener(this);
        imgPlan.setOnClickListener(this);
        imgOrdenServicio.setOnClickListener(this);
        imgReserva.setOnClickListener(this);
    }


    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.imgUsuario:
                Intent usuarios = new Intent(getApplicationContext() ,   activity_new_usuario.class);
                startActivity(usuarios);
                break;
        }
    }
}