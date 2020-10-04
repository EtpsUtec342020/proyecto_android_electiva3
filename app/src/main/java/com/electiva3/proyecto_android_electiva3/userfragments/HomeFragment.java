package com.electiva3.proyecto_android_electiva3.userfragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.electiva3.proyecto_android_electiva3.R;
import com.electiva3.proyecto_android_electiva3.activity_user_ordenes;
import com.electiva3.proyecto_android_electiva3.activity_lista_user_reservas;

public class HomeFragment extends Fragment  implements View.OnClickListener  {


    ImageView imgReserva, imgOrden, imgContrato, imgNotificacion;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_user_home,container,false);

        imgOrden = view.findViewById(R.id.imgOrdenServicio);
        imgContrato = view.findViewById(R.id.imgContrato);
        imgReserva = view.findViewById(R.id.imgReserva);
        imgNotificacion = view.findViewById(R.id.imgNotificaciones);

        imgOrden.setOnClickListener(this);
        imgContrato.setOnClickListener(this);
        imgReserva.setOnClickListener(this);
        imgNotificacion.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.imgOrdenServicio:
                Intent ordenes  =  new Intent( getActivity() , activity_user_ordenes.class);
                startActivity(ordenes);
                break;

            case R.id.imgReserva:
                Intent reservas =  new Intent(getActivity() , activity_lista_user_reservas.class);
                startActivity(reservas);
                break;
        }
    }
}
