package com.electiva3.proyecto_android_electiva3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.electiva3.proyecto_android_electiva3.adapters.HorariosAdapter;
import com.electiva3.proyecto_android_electiva3.entities.Horario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SeleccionarHorarioReserva extends AppCompatActivity {

    private RecyclerView rvHorarios;
    private ArrayList<Horario> horarios;
    private ArrayList<Horario> horariosDisponibles;
    private String fechaSeleccionada;
    private HorariosAdapter horariosAdapter;
    private AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_horario_reserva);

        horarios  =  new ArrayList<>();
        rvHorarios  = findViewById(R.id.rvHorarios);

        fechaSeleccionada = getIntent().getStringExtra("fecha");

        //Evaluar rol y establecer el usuario al cual se le realizara la reserva
        builder= new AlertDialog.Builder(this);
        builder.setTitle("Realizar reserva");
        builder.setCancelable(false);
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Deseas realizar la reserva");
        builder.setCancelable(false);
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(getApplicationContext(), "Reserva realizada satisfactoriamente", Toast.LENGTH_SHORT).show();
                realizarReserva();
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        LinearLayoutManager linearLayoutManager   = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvHorarios.setLayoutManager(  linearLayoutManager );
        crearHoras();
    }

    private void realizarReserva() {
    }

    private void crearHoras(){

       horariosDisponibles = new ArrayList<>();

        int horariosFin =20; //Horario de finalizacion hasta las 8pm

        for( int horariosInicio = 8 ; horariosInicio < horariosFin ; horariosInicio++  ){
            String hora  = ( horariosInicio < 10 ) ? "0"+horariosInicio+":00:00"  :  horariosInicio+":00:00";
            Horario  horario  =  new Horario();
            horario.setHora(hora);
            horariosDisponibles.add(horario);
        }

        consultarDisponibilidadHoras(fechaSeleccionada);
    }

    private void consultarDisponibilidadHoras(String fecha){

        FirebaseDatabase.getInstance().getReference().child("reservacion")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if(snapshot.exists()){
                            for(DataSnapshot ds: snapshot.getChildren()){
                                int searchIndex = search( ds.child("hora").getValue().toString() );
                                horariosDisponibles.remove(searchIndex);
                            }

                            horariosAdapter =  new HorariosAdapter(getApplicationContext(), horariosDisponibles );
                            horariosAdapter.SetOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    String hora =  horariosDisponibles.get(rvHorarios.getChildAdapterPosition(v)).getHora();

                                    builder.setMessage("Tu reserva sera realizada para el dia "+fechaSeleccionada+" a las "+hora+" horas"  );
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();

                                }
                            });

                            rvHorarios.setAdapter(horariosAdapter);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }});
    }

    private int search(String hour ){
        int left = 0 ;
        int size = horariosDisponibles.size();
        int rigth = size - 1;
        int middle = ((rigth + left) / 2);

        int searchValue = Integer.parseInt(hour.substring(0 ,2 )) ;

        while( left < rigth ){
            if( Integer.parseInt(horariosDisponibles.get(middle).getHora().substring(0,2))==searchValue ){
                return middle;
            }else{
                if(Integer.parseInt(horariosDisponibles.get(middle).getHora().substring(0 ,2 ))  >  searchValue  ){
                    rigth = middle-1;
                }else {
                    left = middle+1;
                }
                middle = ((rigth + left) / 2);
            }
        }
        return -1;
    }
}