package com.electiva3.proyecto_android_electiva3.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.electiva3.proyecto_android_electiva3.R;

class UpdateServicioAdapter extends RecyclerView.Adapter<UpdateServicioAdapter.MyViewHolder>
{

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvTitulo;
        TextView tvDescripcion;
        Spinner spnCategoria;
        TextView tvCosto;
        Spinner spnEstado;

        public MyViewHolder(View itemView)
        {
            super(itemView);

            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            tvDescripcion =  itemView.findViewById(R.id.tvDescripcion);
            spnCategoria = itemView.findViewById(R.id.spnCategoria);
            tvCosto = itemView.findViewById(R.id.tvCosto);
            spnEstado = itemView.findViewById(R.id.spnEstado);
            
        }
    }
}
