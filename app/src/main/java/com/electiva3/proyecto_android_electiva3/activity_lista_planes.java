package com.electiva3.proyecto_android_electiva3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class activity_lista_planes extends AppCompatActivity implements View.OnClickListener
{

    private FloatingActionButton faAgregarPlan;
    private ListView lvlista, lvServicios;
    private ConstraintLayout vt2, vt3;
    private Spinner spnTipoPlan,  spnDuracion;
    private TextView txtCosto;
    private Button btnAgregar, btnCancelar, btnServicios, btnAceptar, btnCancelar2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_planes);

        lvlista = findViewById(R.id.lvlista);
        faAgregarPlan = findViewById(R.id.fabAgregarPlan);

        //variables de crear plan
        vt2 = findViewById(R.id.vt2);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnServicios = findViewById(R.id.btnServicios);
        spnTipoPlan = findViewById(R.id.spnTipoPlan);
        spnDuracion = findViewById(R.id.spnDuracion);
        txtCosto = findViewById(R.id.txtCosto);

        //variables seleccionar servicios
        vt3 = findViewById(R.id.vt3);
        lvServicios = findViewById(R.id.lvServicios);
        btnAceptar = findViewById(R.id.btnAceptar);
        btnCancelar2 = findViewById(R.id.btnCancelar2);

        lvlista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent i = new Intent( getApplicationContext() , activity_actualizar_plan.class);
                startActivity(i);

            }
        });

        faAgregarPlan.setOnClickListener(this);
        btnServicios.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);
        btnCancelar2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.fabAgregarPlan:
              //  vt2.setVisibility(View.VISIBLE);
              //  faAgregarPlan.setVisibility(View.INVISIBLE);
                Intent i = new Intent( getApplicationContext() , activity_actualizar_plan.class);
                startActivity(i);
                finish();

                break;
            case R.id.btnCancelar:
                vt2.setVisibility(View.INVISIBLE);
                faAgregarPlan.setVisibility(View.VISIBLE);
                break;
            case R.id.btnServicios:
                vt3.setVisibility(View.VISIBLE);

                String[] servicios = {"servicio 1", "servicio 2", "servicio 3", "servicio 4", "servicio 5", "servicio 1", "servicio 2", "servicio 3", "servicio 4", "servicio 5"};

                lvServicios.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
                lvServicios.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, servicios));
                break;
            case R.id.btnCancelar2:
                vt3.setVisibility(View.INVISIBLE);
                break;


        }
    }

}
