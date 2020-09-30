package com.electiva3.proyecto_android_electiva3.flujoPlan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.electiva3.proyecto_android_electiva3.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class activity_lista_planes extends AppCompatActivity implements View.OnClickListener
{

    private FloatingActionButton faAgregarPlan;
    private ListView lvlista, lvServicios;
    private ConstraintLayout vt2, vt3;
    private Spinner spnTipoPlan,  spnDuracion;
    private TextView txtCosto;
    private Button btnCrear, btnCancelar, btnServicios, btnSeleccionar, btnCancelar2;

    private int index = 0;
    private ArrayList id = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_planes);

        lvlista = findViewById(R.id.lvlista);
        faAgregarPlan = findViewById(R.id.fabAgregarPlan);

        //variables de crear plan
        vt2 = findViewById(R.id.vt2);
        btnCrear = findViewById(R.id.btnCrear);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnServicios = findViewById(R.id.btnServicios);
        spnTipoPlan = findViewById(R.id.spnTipoPlan);
        spnDuracion = findViewById(R.id.spnDuracion);
        txtCosto = findViewById(R.id.txtCosto);

        //variables seleccionar servicios
        vt3 = findViewById(R.id.vt3);
        lvServicios = findViewById(R.id.lvServicios);
        btnSeleccionar = findViewById(R.id.btnSeleccionar);
        btnCancelar2 = findViewById(R.id.btnCancelar2);

        lvlista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent i = new Intent( getApplicationContext() , activity_actualizar_plan.class);
                startActivity(i);
                finish();
            }
        });

        faAgregarPlan.setOnClickListener(this);
        btnServicios.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);
        btnCancelar2.setOnClickListener(this);
        btnSeleccionar.setOnClickListener(this);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vt2.setVisibility(View.INVISIBLE);
                faAgregarPlan.setVisibility(View.VISIBLE);
            }
        });
    }


    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.fabAgregarPlan:
                vt2.setVisibility(View.VISIBLE);
                faAgregarPlan.setVisibility(View.INVISIBLE);
              //  Intent i = new Intent( getApplicationContext() , activity_actualizar_plan.class);
              //  startActivity(i);
              //  finish();
                break;
            case R.id.btnServicios:
                vt3.setVisibility(View.VISIBLE);

                final String[] servicios = {"servicio 1", "servicio 2", "servicio 3", "servicio 4", "servicio 5", "servicio 1", "servicio 2", "servicio 3", "servicio 4", "servicio 5"};

                lvServicios.setChoiceMode(lvServicios.CHOICE_MODE_MULTIPLE);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked, servicios);
                lvServicios.setAdapter(adapter);

                lvServicios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                    }
                });

                id.add(index);



                break;
            case R.id.btnCancelar:

                vt2.setVisibility(View.INVISIBLE);
                faAgregarPlan.setVisibility(View.VISIBLE);
                break;

            case R.id.btnCancelar2:
                vt3.setVisibility(View.INVISIBLE);
                break;

            case R.id.btnSeleccionar:

                txtCosto.setText(id.toString());
                vt3.setVisibility(View.INVISIBLE);
                break;

        }
    }


}


































