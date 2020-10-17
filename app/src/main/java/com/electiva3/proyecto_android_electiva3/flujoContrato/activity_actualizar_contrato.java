package com.electiva3.proyecto_android_electiva3.flujoContrato;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.electiva3.proyecto_android_electiva3.R;
import com.electiva3.proyecto_android_electiva3.adapters.EstadoAdapter;
import com.electiva3.proyecto_android_electiva3.entities.Conexion;
import com.electiva3.proyecto_android_electiva3.entities.Contrato;
import com.electiva3.proyecto_android_electiva3.flujoPlan.activity_lista_planes;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class activity_actualizar_contrato extends AppCompatActivity
{
    private EditText txtNombre, txtVehiculo, txtPlan, txtDuracion, txtFechaA, txtFechaV, txtNumManto, txtCostoT;
    private Spinner spnEstado;
    private Button btnActualizar, btnCancelar;

    private String title = "Ver Contrato";
    private String id;
    private String plan;
    private String cliente;
    private String vehiculo;

    private ArrayList<String> estadosList = new ArrayList<>();
    private ArrayList<String> planContrato = new ArrayList<>();
    private ArrayList<String> clienteContrato = new ArrayList<>();
    private ArrayList<String> vehiculoContrato = new ArrayList<>();

    private Contrato contrato = new Contrato();
    private Conexion conexion = new Conexion();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_contrato);

        txtNombre = findViewById(R.id.txtCliente);
        txtVehiculo = findViewById(R.id.txtVehiculo);
        txtPlan = findViewById(R.id.txtPlan);
        txtDuracion = findViewById(R.id.txtDuracion);
        txtFechaA = findViewById(R.id.txtFechaA);
        txtFechaV = findViewById(R.id.txtFechaV);
        txtNumManto = findViewById(R.id.txtNumManto);
        txtCostoT = findViewById(R.id.txtCostoT);
        spnEstado = findViewById(R.id.spnEstado);
        btnActualizar = findViewById(R.id.btnActualizar);
        btnCancelar = findViewById(R.id.btnCancelar);

        getSupportActionBar().setTitle(title);
        //establecer la conexion
        conexion.inicializarFirabase(this);
        //recuperar el id del objeto
        id = getIntent().getStringExtra("id");

        MostrarDatos();

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( getApplicationContext() , activity_lista_contratos.class);
                startActivity(i);
                finish();
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( getApplicationContext() , activity_lista_contratos.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void MostrarDatos()
    {
        conexion.getDatabaseReference().child("Contratos").child(id).addValueEventListener(new ValueEventListener() {
            DataSnapshot ds;
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ds = snapshot;
                if(ds.exists())
                {
                    contrato.setCostoTotal(Double.parseDouble(ds.child("costoTotal").getValue().toString()));
                    contrato.setDuracion(ds.child("duracion").getValue().toString());
                    contrato.setEstado(ds.child("estado").getValue().toString());
                    contrato.setFechaActivacion(ds.child("fechaActivacion").getValue().toString());
                    contrato.setFechaVencimiento(ds.child("fechaVencimiento").getValue().toString());
                    contrato.setNumeroContrato(Integer.parseInt(ds.child("numeroContrato").getValue().toString()));
                    contrato.setNumeroMantenimientos(Integer.parseInt(ds.child("numeroMantenimientos").getValue().toString()));

                    for (DataSnapshot sp: ds.child("plan").getChildren()) {
                    String i = sp.getKey();
                        if(i.equals("1")) {
                         plan =    ds.child("plan").child(i).getValue().toString();
                        }
                        planContrato.add(i);
                        planContrato.add(plan);
                    }
                    contrato.setPlan(planContrato);

                    mostrarEstados();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void mostrarEstados()
    {
        conexion.getDatabaseReference().child("estados").addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {
                    estadosList.clear();
                    for (DataSnapshot ds : snapshot.getChildren()) {
                        String estado = Objects.requireNonNull(ds.child("estado").getValue()).toString();
                        if(estado.equals(contrato.getEstado())) {
                            estadosList.add(estado);
                        }
                    }
                    CompararEstados();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void CompararEstados()
    {
        conexion.getDatabaseReference().child("estados").addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {
                    for (DataSnapshot ds : snapshot.getChildren()) {
                        String estado = Objects.requireNonNull(ds.child("estado").getValue()).toString();

                        if(estado.equals("Activo") || estado.equals("Inactivo")) {
                            if (!estadosList.contains(estado)) {
                                estadosList.add(estado);
                            }
                        }
                    }
                    EstadoAdapter estadoAdapter = new EstadoAdapter(getApplicationContext() , R.layout.custom_simple_spinner_item,estadosList);
                    spnEstado.setAdapter(estadoAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}
