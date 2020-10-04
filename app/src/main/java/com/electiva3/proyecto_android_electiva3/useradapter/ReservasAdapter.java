package com.electiva3.proyecto_android_electiva3.useradapter;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.electiva3.proyecto_android_electiva3.R;
import com.electiva3.proyecto_android_electiva3.userentities.Reserva;

import java.util.ArrayList;

public class ReservasAdapter extends ArrayAdapter<String>  {

    private Activity context;
    private ArrayList<Reserva> reservas;


    public ReservasAdapter(@NonNull Activity context, ArrayList<Reserva> reservas)
    {
        super(context, R.layout.item_reserva_lista);

        this.context = context;
        this.reservas = reservas;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.item_reserva_lista,null);

        TextView tvReserva = rowView.findViewById(R.id.tvNoReserva);
        TextView tvFecha = rowView.findViewById(R.id.tvFecha);

        tvReserva.setText(reservas.get(position).getReserva());
        tvFecha.setText(reservas.get(position).getFecha());

        return rowView;
    }
}
