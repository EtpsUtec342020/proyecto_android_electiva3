package com.electiva3.proyecto_android_electiva3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.electiva3.proyecto_android_electiva3.adapters.SpinnerContratosAdapter;
import com.electiva3.proyecto_android_electiva3.entities.Contrato;
import com.electiva3.proyecto_android_electiva3.entities.Horario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class activity_agregar_reserva extends AppCompatActivity {

    private String keyCliente;
    private EditText txtCliente;
    private Spinner spnContrato;
    private Button btnSiguiente;
    private ArrayList<String> horariosOcupados;
    private ArrayList<String> horariosDisponibles;
    private String plan;
    private String cliente;
    private String vehiculo;


    private ArrayList<String> clienteContrato = new ArrayList<>();
    private ArrayList<String> planContrato = new ArrayList<>();
    private ArrayList<String> vehiculoContrato = new ArrayList<>();
    private ArrayList<String> estadosList = new ArrayList<>();

    private Contrato contrato = new Contrato();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_reserva);

        txtCliente =  findViewById(R.id.txtCliente);
        spnContrato =  findViewById(R.id.spnContrato);
        btnSiguiente   = findViewById(R.id.btnSiguiente);
        Intent prevIntent = getIntent();
        keyCliente =  prevIntent.getExtras().getString("keyCliente");

        obtenerDatosCliente(  keyCliente   );  //Obtiene el nombre del cliente para visualizacion
        obtenerContratosCliente();  //Obtiene los contratos del cliente y los lista
        //Obtendra los horarios de la fecha designada
        //generarHorario("2020-11-10");

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fecha  = "2020-11-11";
                Intent seleccionarHorario  =  new Intent( getApplicationContext() ,  SeleccionarHorarioReserva.class );
                seleccionarHorario.putExtra("fecha" , fecha);
                startActivity(seleccionarHorario);
            }
        });

    }



    private void obtenerContratosCliente(){

            final ArrayList<Contrato> contratosCliente  =  new ArrayList<>();

            FirebaseDatabase.getInstance().getReference().child("Contratos").addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {



                    if(snapshot.exists()){

                        for(DataSnapshot ds : snapshot.getChildren()) {

                            if( ds.child("cliente").child("0").getValue().toString().equals(keyCliente)  ){
                                String key = null;
                                contrato  = new Contrato();
                                contrato.setCostoTotal(Double.parseDouble(ds.child("costoTotal").getValue().toString()));
                                contrato.setDuracion(ds.child("duracion").getValue().toString());
                                contrato.setEstado(ds.child("estado").getValue().toString());
                                contrato.setFechaActivacion(ds.child("fechaActivacion").getValue().toString());
                                contrato.setFechaVencimiento(ds.child("fechaVencimiento").getValue().toString());
                                contrato.setNumeroContrato(Integer.parseInt(ds.child("numeroContrato").getValue().toString()));
                                contrato.setNumeroMantenimientos(Integer.parseInt(ds.child("numeroMantenimientos").getValue().toString()));


                                key = ds.child("plan").child("0").getValue().toString();
                                plan = ds.child("plan").child("1").getValue().toString();
                                planContrato.add(key);
                                planContrato.add(plan);

                                key = ds.child("cliente").child("0").getValue().toString();
                                cliente = ds.child("cliente").child("1").getValue().toString();
                                clienteContrato.add(key);
                                clienteContrato.add(cliente);

                                key = ds.child("vehiculo").child("0").getValue().toString();
                                vehiculo = ds.child("vehiculo").child("1").getValue().toString();
                                vehiculoContrato.add(key);
                                vehiculoContrato.add(vehiculo);

                                contrato.setCliente(clienteContrato);
                                contrato.setVehiculo(vehiculoContrato);
                                contrato.setPlan(planContrato);

                                contratosCliente.add(contrato);


                            }


                        }


                        SpinnerContratosAdapter spinnerContratosAdapter  =  new SpinnerContratosAdapter(  getApplicationContext() , R.layout.custom_simple_spinner_item ,  contratosCliente     );
                        spnContrato.setAdapter(  spinnerContratosAdapter   );

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });

    }

    private void  obtenerDatosCliente(String keyCliente){

        DatabaseReference cliente = FirebaseDatabase.getInstance().getReference().child("usuarios").child(keyCliente);

        cliente.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                DataSnapshot ds = snapshot;
                if (ds.exists()) {
                    //Nombre del cliente
                    txtCliente.setText(  ds.child("nombre").getValue().toString()   );
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void generarHorario(String fecha){

        ArrayList<Horario>  horariosDisponibles = new ArrayList<>();

        int horariosFin =20; //Horario de finalizacion hasta las 8pm

        for( int horariosInicio = 8 ; horariosInicio < horariosFin ; horariosInicio++  ){
            String hora  = ( horariosInicio < 10 ) ? "0"+horariosInicio+":00:00"  :  horariosInicio+":00:00";
            Horario  horario  =  new Horario();
            horario.setHora(hora);
            horariosDisponibles.add(horario);
        }
        System.out.println(   horariosDisponibles   );

    }


    public void obtenerHorariosDia(String fecha){

        FirebaseDatabase.getInstance().getReference().child("reservacion")
                .orderByChild("fechaSolicitada").equalTo(fecha)
                .orderByChild("estado").equalTo("En Proceso")
                .addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


}