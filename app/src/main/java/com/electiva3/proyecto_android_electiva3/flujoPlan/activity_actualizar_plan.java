package com.electiva3.proyecto_android_electiva3.flujoPlan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.electiva3.proyecto_android_electiva3.R;

public class activity_actualizar_plan extends AppCompatActivity
{
    private Spinner spnTipoPlan,  spnDuracion, spnEstado;
    private TextView txtCosto;
    private Button btnCancelar, btnActualizar;
    private ListView lvServicios;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_plan);

        txtCosto = findViewById(R.id.tvCosto);
        lvServicios = findViewById(R.id.lvServicios);
        btnActualizar = findViewById(R.id.btnCrear);
        btnCancelar = findViewById(R.id.btnCancelar);
        spnTipoPlan = findViewById(R.id.spnTipoPlan);
        spnDuracion = findViewById(R.id.spnDuracion);
        spnEstado = findViewById(R.id.spnEstado);

        //prueba servicios
        String[] servicios = {"servicio 1", "servicio 2", "servicio 3", "servicio 4", "servicio 5"};
        lvServicios.setChoiceMode(AbsListView.CHOICE_MODE_NONE);
        lvServicios.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, servicios));


        btnCancelar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( getApplicationContext() , activity_lista_planes.class);
                startActivity(i);
                finish();
            }
        });
    }
}
