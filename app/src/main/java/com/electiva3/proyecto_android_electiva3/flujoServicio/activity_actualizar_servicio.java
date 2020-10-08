package com.electiva3.proyecto_android_electiva3.flujoServicio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.electiva3.proyecto_android_electiva3.R;
import com.electiva3.proyecto_android_electiva3.adapters.CategoriaAdapter;
import com.electiva3.proyecto_android_electiva3.adapters.EstadoAdapter;
import com.electiva3.proyecto_android_electiva3.entities.Conexion;
import com.electiva3.proyecto_android_electiva3.entities.Estado;
import com.electiva3.proyecto_android_electiva3.entities.Servicio;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class activity_actualizar_servicio extends AppCompatActivity
{

    private TextView tvTitulo, tvDescripcion, tvCosto;
    private Spinner spnCategoria, spnEstado;
    private Button btnActualizar, btnCancelar;

    private ArrayList<String> estadosServiciosList;
    private ArrayList<String> categoriaList = new ArrayList<>();
    Conexion conexion = new Conexion();
    Servicio servicio = new Servicio();

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_servicio);

        tvTitulo = findViewById(R.id.tvTitulo);
        tvDescripcion = findViewById(R.id.tvDescripcion);
        tvCosto = findViewById(R.id.tvCosto);
        spnCategoria = findViewById(R.id.spnCategoria);
        spnEstado = findViewById(R.id.spnEstado);
        btnActualizar = findViewById(R.id.btnActualizar);
        btnCancelar = findViewById(R.id.btnCancelar);

        estadosServiciosList = new ArrayList<>();

        conexion.inicializarFirabase(this);

        //recuperar el id del objeto
        id = getIntent().getStringExtra("id");

        MostrarDatos();


        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent( getApplicationContext() , activity_lista_servicios.class);
                startActivity(i);
                finish();
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String estado = spnEstado.getSelectedItem().toString();

                if(!estado.equals(servicio.getEstado()))
                {
                    servicio.setEstado(estado);
                    servicio.UpdateServicio();
                    conexion.getDatabaseReference().child("ArticulosServicios").child(id).updateChildren(servicio.getServicioMap());
                    Toast.makeText(getApplicationContext(), "Servicio Inactivo", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "No se realizaron Cambios", Toast.LENGTH_SHORT).show();
                }

                Intent i = new Intent( getApplicationContext() , activity_lista_servicios.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void MostrarDatos()
    {
        conexion.getDatabaseReference().child("ArticulosServicios").child(id).addValueEventListener(new ValueEventListener() {
            DataSnapshot ds;

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                ds = snapshot;
                if (ds.exists())
                {
                    servicio.setEstado(ds.child("estado").getValue().toString());
                    servicio.setTitulo(ds.child("titulo").getValue().toString());
                    servicio.setCategoria(ds.child("categoria").getValue().toString());
                    servicio.setDescripcion(ds.child("descripcion").getValue().toString());
                    servicio.setCosto(ds.child("costo").getValue().toString());

                    tvTitulo.setText(servicio.getTitulo());
                    tvDescripcion.setText(servicio.getDescripcion());
                    tvCosto.setText(servicio.getCosto());
                    mostrarEstados();
                    CategoriaServicios();
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

                if (snapshot.exists())
                {
                    estadosServiciosList.clear();

                    for (DataSnapshot ds : snapshot.getChildren())
                    {
                     //   int key = Integer.parseInt(ds.getKey());
                        String estado = Objects.requireNonNull(ds.child("estado").getValue()).toString();

                        if(estado.equals("Activo") || estado.equals("Inactivo"))
                        {
                            estadosServiciosList.add(estado);
                        }
                    }
                    EstadoAdapter estadoAdapter = new EstadoAdapter(getApplicationContext() , R.layout.custom_simple_spinner_item,estadosServiciosList);
                    spnEstado.setAdapter(estadoAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void CategoriaServicios()
    {
        conexion.getDatabaseReference().child("categoriaServicios").addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists())
                {
                    categoriaList.clear();

                    for (DataSnapshot ds : snapshot.getChildren())
                    {
                        String categoria = Objects.requireNonNull(ds.child("categoria").getValue()).toString();
                        if(categoria.equals(servicio.getCategoria()))
                        {
                            categoriaList.add(categoria);
                        }
                    }
                    CategoriaAdapter categoriaAdapter = new CategoriaAdapter(getApplicationContext() , R.layout.custom_simple_spinner_item, categoriaList);
                    spnCategoria.setAdapter(categoriaAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

}
