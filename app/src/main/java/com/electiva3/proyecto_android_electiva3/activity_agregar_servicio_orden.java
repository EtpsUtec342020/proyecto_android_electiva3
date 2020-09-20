package com.electiva3.proyecto_android_electiva3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.electiva3.proyecto_android_electiva3.adapters.ArticulosAdapter;
import com.electiva3.proyecto_android_electiva3.entities.Articulo;

import java.util.ArrayList;

public class activity_agregar_servicio_orden extends AppCompatActivity {

    ImageView filtroServicios;
    RecyclerView rvArticulosServicios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_servicio_orden);

        filtroServicios =  findViewById(R.id.filtroServicios);
        rvArticulosServicios =  findViewById(R.id.rvArticulosServicios);



        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvArticulosServicios.setLayoutManager(linearLayoutManager);


        ArticulosAdapter articulosAdapter =  new ArticulosAdapter( getApplicationContext() ,   buildArticulos()  );

        rvArticulosServicios.setAdapter(articulosAdapter);

    }

    public ArrayList<Articulo> buildArticulos(){

        ArrayList<Articulo> articulos  = new ArrayList<>();

        articulos.add(new Articulo( "Cambio de rin"  , "$50.5" ));
        articulos.add(new Articulo( "Llanta x"  , "$25.99" ));
        articulos.add(new Articulo( "Liquido de frenos"  , "$10.35" ));
        articulos.add(new Articulo( "Bateria x"  , "$75.87" ));

        return  articulos;

    }
}
