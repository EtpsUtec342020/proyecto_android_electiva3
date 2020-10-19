package com.electiva3.proyecto_android_electiva3.flujoVehiculo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

import android.widget.ListView;
import android.widget.Spinner;

import com.electiva3.proyecto_android_electiva3.R;
import com.electiva3.proyecto_android_electiva3.adapters.MarcaSpinnerAdapter;
import com.electiva3.proyecto_android_electiva3.adapters.ModelosSpinnerAdapter;
import com.electiva3.proyecto_android_electiva3.entities.Conexion;
import com.electiva3.proyecto_android_electiva3.entities.Marca;
import com.electiva3.proyecto_android_electiva3.entities.Modelo;
import com.electiva3.proyecto_android_electiva3.entities.Vehiculo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class activity_new_vehiculo extends AppCompatActivity implements View.OnClickListener
{

    private EditText  edtPlaca, edtChasis, edtAnio, edtColor;
    private Spinner spnMarca, spnModelo;
    private ConstraintLayout vt2;
    private ListView lvlistar;
    private Button btnCrear, btnCancelar, btnCancelar2;
    private ArrayList<Marca> marcas;
    private ArrayList<Modelo> modelos;
    private DatabaseReference marcasReference;
    private DatabaseReference modelosReference;



    private Conexion conexion;




    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_vehiculo);

        conexion =  new Conexion();
        conexion.inicializarFirabase(this);
        marcas = new ArrayList<>();
        modelos =  new ArrayList<>();

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




        spnMarca.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cargarModelos(   marcas.get(position).getKey()  );
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btnCancelar.setOnClickListener(this);
        btnCancelar2.setOnClickListener(this);
        btnCrear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
               crearVehiculo();
            }
        });

        cargarMarcas();
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
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


    public  void  cargarMarcas(){

        marcasReference =  conexion.getDatabaseReference().child("marcas");
        marcasReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.exists()){

                    marcas.clear();
                    for( DataSnapshot ds: snapshot.getChildren() ){
                        String nombreMarca  =   ds.child("marca").getValue().toString();
                        String keyMarca  = ds.getKey();
                        Marca  marca = new Marca();
                        marca.setKey(keyMarca);
                        marca.setMarca(nombreMarca);
                        marcas.add(marca);
                    }

                    MarcaSpinnerAdapter marcaSpinnerAdapter =  new MarcaSpinnerAdapter(getApplicationContext() ,  R.layout.custom_simple_spinner_item ,    marcas  );
                    spnMarca.setAdapter(marcaSpinnerAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }



    public void cargarModelos(String keyMarca){


        modelos.clear();
        ModelosSpinnerAdapter modelosSpinnerAdapter =  new ModelosSpinnerAdapter( getApplicationContext() , R.layout.custom_simple_spinner_item ,  modelos );
        spnModelo.setAdapter( modelosSpinnerAdapter );

        modelosReference =  conexion.getDatabaseReference().child("modelos");


        modelosReference.getRef().orderByChild("keyMarca").equalTo(keyMarca).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.exists()){
                    for(DataSnapshot ds:  snapshot.getChildren()  ){

                     String keyModelo =  ds.getKey();
                     String nombreModelo = ds.child("modelo").getValue().toString();

                     Modelo modelo  =  new Modelo();

                     modelo.setKey(keyModelo);
                     modelo.setModelo(nombreModelo);

                     modelos.add(modelo);
                    }

                    ModelosSpinnerAdapter modelosSpinnerAdapter =  new ModelosSpinnerAdapter( getApplicationContext() , R.layout.custom_simple_spinner_item ,  modelos );
                    spnModelo.setAdapter( modelosSpinnerAdapter );
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    public void crearVehiculo(){

        String placa = edtPlaca.getText().toString();
        String chasis = edtChasis.getText().toString();
        String anio = edtAnio.getText().toString();
        String color = edtColor.getText().toString();


        if(TextUtils.isEmpty(placa)) {
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
        }else{

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String fecha =  dateFormat.format(date);

            String key = (UUID.randomUUID().toString());

            int indexMarca = spnMarca.getSelectedItemPosition();
            int indexModelo =  spnModelo.getSelectedItemPosition();

            Vehiculo vehiculo =  new Vehiculo();

            vehiculo.setMarca(marcas.get(indexMarca).getMarca());
            vehiculo.setKeyMarca(marcas.get(indexMarca).getKey());
            vehiculo.setModelo( modelos.get(indexModelo).getModelo());
            vehiculo.setKeyModelo( modelos.get(indexModelo).getKey());
            vehiculo.setPlaca(placa);
            vehiculo.setNumChasis( chasis);
            vehiculo.setAnio(anio);
            vehiculo.setColor(color);
            vehiculo.setFechaRegistro(fecha);

            conexion.getDatabaseReference().child("vehiculos").child(key).setValue(vehiculo);


        }


    }

}
