package com.electiva3.proyecto_android_electiva3.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.electiva3.proyecto_android_electiva3.R;
import com.electiva3.proyecto_android_electiva3.activity_agregar_servicio_orden;
import com.electiva3.proyecto_android_electiva3.activity_lista_contratos;
import com.electiva3.proyecto_android_electiva3.activity_lista_planes;
import com.electiva3.proyecto_android_electiva3.activity_lista_reservas;
import com.electiva3.proyecto_android_electiva3.activity_lista_servicios;
import com.electiva3.proyecto_android_electiva3.activity_lista_usuarios;
import com.electiva3.proyecto_android_electiva3.activity_lista_vehiculos;
import com.electiva3.proyecto_android_electiva3.activity_ordenes;
import com.electiva3.proyecto_android_electiva3.adapters.DetalleOrdenAdapter;
import com.electiva3.proyecto_android_electiva3.entities.DetalleOrden;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FragmentOrdenOrden extends Fragment   {

    RecyclerView rvDetalleOrdenes;
    FloatingActionButton fabAgregarDetalleOrden;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View view=inflater.inflate(R.layout.fragment_orden_orden,container,false);

        rvDetalleOrdenes =  view.findViewById(R.id.rvDetalleOrdenes);
        fabAgregarDetalleOrden =  view.findViewById(R.id.fabAgregarDetalleOrden);


        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvDetalleOrdenes.setLayoutManager(linearLayoutManager);


        DetalleOrdenAdapter detalleOrdenAdapter =  new DetalleOrdenAdapter(getActivity() , buildDetails()   );
        rvDetalleOrdenes.setAdapter(detalleOrdenAdapter);


        fabAgregarDetalleOrden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            Intent intent = new Intent(getActivity() ,  activity_agregar_servicio_orden.class   );
            startActivity(intent);

            }
        });

        return view;
    }



    public ArrayList<DetalleOrden> buildDetails(){

        ArrayList<DetalleOrden>  detallesOrdenes =   new ArrayList<>();

        detallesOrdenes.add(new DetalleOrden("Cambio de aceite","Aprobado" , "$0" ));
        detallesOrdenes.add(new DetalleOrden("Revision de filtro de aceite","Aprobado" , "$0" ));
        detallesOrdenes.add(new DetalleOrden("Regular presion de llantas","Aprobado" , "$0" ));
        detallesOrdenes.add(new DetalleOrden("Regular presion de llantas","Aprobado" , "$0" ));

        return detallesOrdenes;

    }

}
