package com.electiva3.proyecto_android_electiva3.userfragments;

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
import com.electiva3.proyecto_android_electiva3.useradapter.DetalleOrdenAdapter;
import com.electiva3.proyecto_android_electiva3.userentities.UserDetalleOrden;

import java.util.ArrayList;

public class FragmentDetalleOrden extends Fragment {

    RecyclerView rvDetalleOrdenes;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View view=inflater.inflate(R.layout.fragment_user_detalle_orden,container,false);

        rvDetalleOrdenes =  view.findViewById(R.id.rvDetalleOrdenes);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvDetalleOrdenes.setLayoutManager(linearLayoutManager);


        DetalleOrdenAdapter detalleOrdenAdapter =  new DetalleOrdenAdapter(getActivity() , buildDetails());
        rvDetalleOrdenes.setAdapter(detalleOrdenAdapter);

        return view;
    }

    public ArrayList<UserDetalleOrden> buildDetails(){

        ArrayList<UserDetalleOrden>  detallesOrdenes =   new ArrayList<>();

        detallesOrdenes.add(new UserDetalleOrden("Cambio de aceite","0.5" , "true" ));
        detallesOrdenes.add(new UserDetalleOrden("Revision de filtro de aceite","12.45" , "false"));
        detallesOrdenes.add(new UserDetalleOrden("Regular presion de llantas","15.4" , "true" ));
        detallesOrdenes.add(new UserDetalleOrden("Regular presion de llantas","3.4" , "false" ));

        return detallesOrdenes;
    }

}
