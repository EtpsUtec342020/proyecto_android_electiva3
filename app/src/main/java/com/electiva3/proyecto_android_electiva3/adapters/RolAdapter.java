package com.electiva3.proyecto_android_electiva3.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.electiva3.proyecto_android_electiva3.R;
import com.electiva3.proyecto_android_electiva3.entities.Rol;

import java.util.List;

public class RolAdapter extends ArrayAdapter<Rol>
{

    private Context context;
    private List<Rol> rolesUsuarios;

    public RolAdapter(@NonNull Context context, int resource, @NonNull List<Rol> objects) {
        super(context, resource, objects);
        this.context = context;
        rolesUsuarios = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;


        if(view == null){
            view = LayoutInflater.from(this.context).inflate(R.layout.custom_simple_spinner_item , null);
        }

        TextView texto = view.findViewById(R.id.customSpinnerItem);
        Rol rolUsuario =  rolesUsuarios.get(position);
        texto.setText(  rolUsuario.getRol()     );

        return view;
    }
}
