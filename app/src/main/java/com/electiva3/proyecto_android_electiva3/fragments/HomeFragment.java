package com.electiva3.proyecto_android_electiva3.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.electiva3.proyecto_android_electiva3.R;
import com.electiva3.proyecto_android_electiva3.activity_lista_contratos;
import com.electiva3.proyecto_android_electiva3.activity_lista_planes;
import com.electiva3.proyecto_android_electiva3.activity_lista_reservas;
import com.electiva3.proyecto_android_electiva3.activity_lista_servicios;
import com.electiva3.proyecto_android_electiva3.activity_lista_usuarios;
import com.electiva3.proyecto_android_electiva3.activity_lista_vehiculos;
import com.electiva3.proyecto_android_electiva3.activity_ordenes;

public class HomeFragment extends Fragment  implements View.OnClickListener  {


    ImageView imgUsuario, imgContrato, imgMarca, imgVehiculo, imgServicio, imgPlan, imgOrdenServicio, imgReserva;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_home,container,false);



        imgUsuario = view.findViewById(R.id.imgUsuario);
        imgContrato = view.findViewById(R.id.imgContrato);
        imgMarca = view.findViewById(R.id.imgMarca);
        imgVehiculo = view.findViewById(R.id.imgVehiculo);
        imgServicio = view.findViewById(R.id.imgServicio);
        imgPlan =  view.findViewById(R.id.imgPlan);
        imgOrdenServicio =  view.findViewById(R.id.imgOrdenServicio);
        imgReserva =  view.findViewById(R.id.imgReserva);

        imgUsuario.setOnClickListener(this);
        imgContrato.setOnClickListener(this);
        imgMarca.setOnClickListener(this);
        imgVehiculo.setOnClickListener(this);
        imgServicio.setOnClickListener(this);
        imgPlan.setOnClickListener(this);
        imgOrdenServicio.setOnClickListener(this);
        imgReserva.setOnClickListener(this);



        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.imgUsuario:
                Intent usuarios = new Intent(getActivity() ,   activity_lista_usuarios.class);
                startActivity(usuarios);
                break;
            case R.id.imgContrato:
                Intent contratos = new Intent(getActivity() ,   activity_lista_contratos.class);
                startActivity(contratos);
                break;
            case R.id.imgVehiculo:
                Intent vehiculos = new Intent(getActivity() ,   activity_lista_vehiculos.class);
                startActivity(vehiculos);
                break;
            case R.id.imgServicio:
                Intent servicios = new Intent(getActivity() ,   activity_lista_servicios.class);
                startActivity(servicios);
                break;
            case R.id.imgPlan:
                Intent planes = new Intent(getActivity() ,   activity_lista_planes.class);
                startActivity(planes);
                break;

            case R.id.imgReserva:

                Intent reservas =  new Intent(getActivity() , activity_lista_reservas.class);
                startActivity(reservas);
                break;

            case R.id.imgOrdenServicio:
                Intent ordenes  =  new Intent( getActivity() , activity_ordenes.class);
                startActivity(ordenes);
                break;
        }
    }
}