package com.electiva3.proyecto_android_electiva3.flujoServicio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.electiva3.proyecto_android_electiva3.R;
import com.electiva3.proyecto_android_electiva3.activity_principal;
import com.electiva3.proyecto_android_electiva3.adapters.CategoriaAdapter;
import com.electiva3.proyecto_android_electiva3.adapters.ServiciosAdapter;

import com.electiva3.proyecto_android_electiva3.entities.Conexion;
import com.electiva3.proyecto_android_electiva3.entities.Servicio;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class activity_lista_servicios extends AppCompatActivity
{

    private FloatingActionButton faAgregarServicio;
    private RecyclerView rvServicio;
    private String title="Lista Servicios";
    //para listar servicios
    private ArrayList<Servicio> serList = new ArrayList<>();
    //para llenar spinner
    private ArrayList<String> servicioslist = new ArrayList<>();

    private ConstraintLayout Vt2;
    private EditText edtTitulo, edtDescripcion, edtCosto;
    private Spinner spnCategoria;
    private Button btnCrear, btnCancelar;

    Conexion conexion = new Conexion();
    Servicio servicio = new Servicio();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_servicios);

        //variables lista layout
        faAgregarServicio = findViewById(R.id.fabAgregarServicio);
        rvServicio = findViewById(R.id.rvServicio);
        Vt2 = findViewById(R.id.vt2);

        //variables crear servicio
        edtTitulo = findViewById(R.id.edtTitulo);
        edtDescripcion = findViewById(R.id.edtDescripcion);
        edtCosto = findViewById(R.id.edtCosto);
        spnCategoria = findViewById(R.id.spnCategoria);
        btnCrear = findViewById(R.id.btnCrear);
        btnCancelar = findViewById(R.id.btnCancelar);

        getSupportActionBar().setTitle(title);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager( getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvServicio.setLayoutManager(linearLayoutManager);

        conexion.inicializarFirabase(this);
        ListarServicios();


        faAgregarServicio.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Vt2.setVisibility(View.VISIBLE);
                faAgregarServicio.setVisibility(View.INVISIBLE);
                CategoriaServicios();
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

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String titulo = edtTitulo.getText().toString();
                String descripcion = edtDescripcion.getText().toString();
                String costo = edtCosto.getText().toString();
                String categoria = spnCategoria.getSelectedItem().toString();

                if(TextUtils.isEmpty(titulo)){
                    edtTitulo.setError("Campo Requerido");
                }
                else if(TextUtils.isEmpty(descripcion)){
                    edtDescripcion.setError("Campo Requerido");
                }
                else if(TextUtils.isEmpty(costo)){
                    edtCosto.setError("Campo Requerido");
                }
                else if(categoria.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "seleccione una categoria", Toast.LENGTH_LONG).show();
                }
                else
                {
                    String key = (UUID.randomUUID().toString());
                    servicio.setTitulo(titulo);
                    servicio.setCategoria(categoria);
                    servicio.setCosto(costo);
                    servicio.setDescripcion(descripcion);
                    servicio.setEstado("Activo");

                    conexion.getDatabaseReference().child("ArticulosServicios").child(key).setValue(servicio);
                    Toast.makeText(getApplicationContext(), "Servicio creado Exitozamente!!", Toast.LENGTH_LONG).show();

                    Vt2.setVisibility(View.INVISIBLE);
                    faAgregarServicio.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void ListarServicios()
    {
        conexion.getDatabaseReference().child("ArticulosServicios").addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists())
                {
                    serList.clear();
                    for (DataSnapshot ds : snapshot.getChildren()) {
                        String titulo = ds.child("titulo").getValue().toString();
                        String descripcion = ds.child("descripcion").getValue().toString();
                        String costo = ds.child("costo").getValue().toString();
                        String key = ds.getKey();

                        serList.add(new Servicio(key, titulo, descripcion, costo));
                    }

                    ServiciosAdapter servicioAdapter = new ServiciosAdapter(getApplicationContext(), serList);
                    rvServicio.setAdapter(servicioAdapter);
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
                    servicioslist.clear();

                    for (DataSnapshot ds : snapshot.getChildren())
                    {

                        String categoria = Objects.requireNonNull(ds.child("categoria").getValue()).toString();
                        servicioslist.add(categoria);
                    }
                    CategoriaAdapter categoriaAdapter = new CategoriaAdapter(getApplicationContext() , R.layout.custom_simple_spinner_item, servicioslist);
                    spnCategoria.setAdapter(categoriaAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent= new Intent(getApplicationContext() , activity_principal.class);
        startActivity(intent);
        finish();
    }

}
