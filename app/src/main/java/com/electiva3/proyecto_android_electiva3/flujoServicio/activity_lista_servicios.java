package com.electiva3.proyecto_android_electiva3.flujoServicio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.electiva3.proyecto_android_electiva3.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class activity_lista_servicios extends AppCompatActivity
{

    private FloatingActionButton faAgregarServicio;
    private ListView lvlista;
    private ConstraintLayout Vt2;
    private EditText edtTitulo, edtDescripcion, edtCosto;
    private Spinner spnCategoria;
    private Button btnAgregar, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_servicios);

        //variables lista layout
        faAgregarServicio = findViewById(R.id.fabAgregarServicio);
        lvlista = findViewById(R.id.lvlista);
        Vt2 = findViewById(R.id.Vt2);

        //variables crear servicio
        edtTitulo = findViewById(R.id.edtTitulo);
        edtDescripcion = findViewById(R.id.edtDescripcion);
        edtCosto = findViewById(R.id.edtCosto);
        spnCategoria = findViewById(R.id.spnCategoria);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnCancelar = findViewById(R.id.btnCancelar2);


        lvlista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent i = new Intent( getApplicationContext() , activity_actualizar_servicio.class);
                startActivity(i);
            }
        });

        faAgregarServicio.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Vt2.setVisibility(View.VISIBLE);
                faAgregarServicio.setVisibility(View.INVISIBLE);

            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Vt2.setVisibility(View.INVISIBLE);
                faAgregarServicio.setVisibility(View.VISIBLE);

            }
        });
    }


}
