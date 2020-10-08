package com.electiva3.proyecto_android_electiva3.flujoContrato;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.electiva3.proyecto_android_electiva3.R;

public class activity_new_contrato extends AppCompatActivity implements View.OnClickListener
{
    private TextView txtCliente, txtPlan, txtFechaVen, txtNumManto, txtCosto;
    private Spinner spnVehiculo, spnDuracionC;
    private CalendarView cvfechaActivacion;
    private ConstraintLayout vt2;
    private ListView lvlistar;
    private Button btnCrear, btnSeleccionar, btnCancelar, btnCancelar2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contrato);

        txtCliente = findViewById(R.id.txtCliente);
        txtPlan = findViewById(R.id.txtPlan);
        cvfechaActivacion = findViewById(R.id.cvfechaActivacion);
        txtFechaVen = findViewById(R.id.txtFechaVen);
        txtNumManto = findViewById(R.id.txtNumManto);
        txtCosto = findViewById(R.id.tvCosto);
        spnVehiculo = findViewById(R.id.spnVehiculo);
        spnDuracionC = findViewById(R.id.spnDuracionC);
        btnCrear = findViewById(R.id.btnCrear);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnSeleccionar = findViewById(R.id.btnSeleccionar);
        btnCancelar2 = findViewById(R.id.btnCancelar2);
        vt2 = findViewById(R.id.vt2);
        lvlistar = findViewById(R.id.lvlistar);

        txtCliente.setOnClickListener(this);
        txtPlan.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);
        btnCancelar2.setOnClickListener(this);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cliente = txtCliente.getText().toString();
                String plan = txtPlan.getText().toString();
                String fechaVencimiento = txtFechaVen.getText().toString();

            }
        });
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.txtCliente:
                Seleccionar();

                lvlistar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        txtCliente.setText(lvlistar.getItemAtPosition(position).toString());

                        vt2.setVisibility(View.INVISIBLE);
                    }
                });
                break;
            case R.id.txtPlan:

                Seleccionar();

                lvlistar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        txtPlan.setText(lvlistar.getItemAtPosition(position).toString());

                        vt2.setVisibility(View.INVISIBLE);
                    }
                });
                break;
            case R.id.btnCancelar:

                Intent contratos = new Intent(getApplicationContext() ,   activity_lista_contratos.class);
                startActivity(contratos);
                finish();
                break;
            case R.id.btnCancelar2:
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
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, Arreglo);
        lvlistar.setAdapter(adapter);

    }
}
