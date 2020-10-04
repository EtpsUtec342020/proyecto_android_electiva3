package com.electiva3.proyecto_android_electiva3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.electiva3.proyecto_android_electiva3.useradapter.DetalleOrdenAdapter;
import com.electiva3.proyecto_android_electiva3.useradapter.OrdenAdapter;
import com.electiva3.proyecto_android_electiva3.useradapter.ReservasAdapter;
import com.electiva3.proyecto_android_electiva3.userentities.Reserva;
import com.electiva3.proyecto_android_electiva3.userentities.UserDetalleOrden;
import com.electiva3.proyecto_android_electiva3.userentities.UserOrden;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class activity_lista_user_reservas extends AppCompatActivity {

    String title ="detalle orden";
    private ListView lvlista;
    private FloatingActionButton fabAgregarConcontrato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_user_reservas);


        lvlista = findViewById(R.id.lvlista);
        fabAgregarConcontrato = findViewById(R.id.fabAgregarContrato);

        ArrayList<Reserva> reservas =   new ArrayList<>();

        reservas.add(new Reserva("#00392","01/12/2020"));
        reservas.add(new Reserva("#54223","04/10/2020"));
        reservas.add(new Reserva("#55224","12/08/2020"));
        reservas.add(new Reserva("#89225","06/11/2019"));

        ReservasAdapter adapter =  new ReservasAdapter(this ,reservas);
        lvlista.setAdapter(adapter);



        lvlista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent( getApplicationContext() , activity_actualizar_user_reserva.class);
                startActivity(i);
            }
        });


        fabAgregarConcontrato.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext() , activity_nuevo_user_reserva.class);
                startActivity(i);
                finish();
            }
        });

    }
}