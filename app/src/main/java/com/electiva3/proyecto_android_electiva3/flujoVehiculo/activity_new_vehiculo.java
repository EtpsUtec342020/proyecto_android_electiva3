package com.electiva3.proyecto_android_electiva3.flujoVehiculo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import com.electiva3.proyecto_android_electiva3.R;

public class activity_new_vehiculo extends AppCompatActivity implements View.OnClickListener
{
    private  ImageView imvImagen;
    private EditText edtCliente, edtPlaca, edtChasis, edtAnio, edtColor;
    private Spinner spnMarca, spnModelo;
    private ConstraintLayout vt2;
    private ListView lvlistar;
    private Button btnCrear, btnCancelar, btnCancelar2;

    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_vehiculo);

        imvImagen = findViewById(R.id.imvImagen);
        edtCliente = findViewById(R.id.edtCliente);
        edtPlaca = findViewById(R.id.edtPlaca);
        edtChasis = findViewById(R.id.edtChasis);
        edtAnio = findViewById(R.id.edtAnio);
        edtColor = findViewById(R.id.edtColor);
        spnMarca = findViewById(R.id.spnMarca);
        spnModelo = findViewById(R.id.spnModelo);
        btnCrear = findViewById(R.id.btnCrear);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnCancelar2 = findViewById(R.id.btnCancelar2);
        vt2 = findViewById(R.id.vt2);
        lvlistar = findViewById(R.id.lvlistar);


        btnCancelar.setOnClickListener(this);
        edtCliente.setOnClickListener(this);
        btnCancelar2.setOnClickListener(this);

        btnCrear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String cliente = edtCliente.getText().toString();
                String placa = edtPlaca.getText().toString();
                String chasis = edtChasis.getText().toString();
                String anio = edtAnio.getText().toString();
                String color = edtColor.getText().toString();

                if(TextUtils.isEmpty(cliente)) {
                    edtCliente.setError("Campo Requerido");
                }
                else if(TextUtils.isEmpty(placa)) {
                    edtPlaca.setError("Campo Requerido");
                }
                else if(TextUtils.isEmpty(chasis)) {
                    edtChasis.setError("Campo Requerido");
                }
                else if(TextUtils.isEmpty(anio)) {
                    edtAnio.setError("Campo Requerido");
                }
                else if(TextUtils.isEmpty(color)) {
                    edtColor.setError("Campo Requerido");
                }
            }
        });

    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.edtCliente:
                vt2.setVisibility(View.VISIBLE);
                String[] Arreglo = {"dato 1", "dato 2", "dato 3", "dato 4", "dato 5"};

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, Arreglo);
                lvlistar.setAdapter(adapter);

                lvlistar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        edtCliente.setText(lvlistar.getItemAtPosition(position).toString());

                        vt2.setVisibility(View.INVISIBLE);
                    }
                });

                break;
            case R.id.btnCancelar:
                Intent vehiculos = new Intent(getApplicationContext() ,   activity_lista_vehiculos.class);
                startActivity(vehiculos);
                finish();
                break;
            case R.id.btnCancelar2:
                vt2.setVisibility(View.INVISIBLE);
                break;
        }
    }

}








































