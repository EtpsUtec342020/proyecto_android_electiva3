package com.electiva3.proyecto_android_electiva3.flujoContrato;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.electiva3.proyecto_android_electiva3.R;

public class activity_new_contrato extends AppCompatActivity implements View.OnClickListener
{
    private TextView txtCliente, txtVehiculo, txtPlan, txtFechaVen, txtNumManto, txtCosto;
    private Spinner spnDuracionC;
    private CalendarView cvfechaActivacion;
    private ConstraintLayout vt2;
    private ListView lvlistar;
    private Button btnAgregar, btnSeleccionar, btnCancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contrato);

        txtCliente = findViewById(R.id.txtCliente);
        txtVehiculo = findViewById(R.id.txtVehiculo);
        txtPlan = findViewById(R.id.txtPlan);
        cvfechaActivacion = findViewById(R.id.cvfechaActivacion);
        txtFechaVen = findViewById(R.id.txtFechaVen);
        txtNumManto = findViewById(R.id.txtNumManto);
        txtCosto = findViewById(R.id.txtCosto);
        spnDuracionC = findViewById(R.id.spnDuracionC);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnSeleccionar = findViewById(R.id.btnSeleccionar);
        btnCancelar = findViewById(R.id.btnCancelar);
        vt2 = findViewById(R.id.vt2);
        lvlistar = findViewById(R.id.lvlistar);

        txtCliente.setOnClickListener(this);
        txtVehiculo.setOnClickListener(this);
        txtPlan.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.txtCliente:
                    Seleccionar();
                break;
            case R.id.txtVehiculo:
                    Seleccionar();
                break;
            case R.id.txtPlan:
                     Seleccionar();
                break;
            case R.id.btnCancelar:
                vt2.setVisibility(View.INVISIBLE);
                cvfechaActivacion.setVisibility(View.VISIBLE);
                break;
        }
    }

    public void Seleccionar()
    {
        vt2.setVisibility(View.VISIBLE);
        cvfechaActivacion.setVisibility(View.INVISIBLE);


        String[] Arreglo = {"dato 1", "dato 2", "dato 3", "dato 4", "dato 5"};
        lvlistar.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        lvlistar.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, Arreglo));

    }
}
