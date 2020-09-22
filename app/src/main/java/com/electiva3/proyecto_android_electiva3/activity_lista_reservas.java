package com.electiva3.proyecto_android_electiva3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.electiva3.proyecto_android_electiva3.adapters.ReservasAdapter;
import com.electiva3.proyecto_android_electiva3.entities.Reserva;

import java.util.ArrayList;

public class activity_lista_reservas extends AppCompatActivity {



    String title="Reservas";
    RecyclerView rvReservas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_reservas);


        rvReservas =  findViewById(R.id.rvReservas);

        getSupportActionBar().setTitle(title);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager( getApplicationContext()     );
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvReservas.setLayoutManager(linearLayoutManager);

        ReservasAdapter reservasAdapter =  new ReservasAdapter( getApplicationContext() ,  buildReservas()  );
        rvReservas.setAdapter( reservasAdapter  );


    }


    public ArrayList<Reserva> buildReservas(){
        ArrayList<Reserva>  reservas =  new ArrayList<Reserva>();
        reservas.add( new Reserva("Jorge De La Cruz" , "HM12020201"   , "202/09/2020" , "Pendiente aprobación" ) );
        reservas.add( new Reserva( "Douglas Guzman", "HMQ2020902" , "22/09/2020" , "Procesada"));
        reservas.add( new Reserva( "Juan Perez", "HMQ2020902" , "22/09/2020" , "Pendiente aprobación"));
        return reservas;
    }

    @Override
    public void onBackPressed() {
        Intent intent= new Intent(getApplicationContext() , activity_principal.class);
        startActivity(intent);
        finish();
    }
}
