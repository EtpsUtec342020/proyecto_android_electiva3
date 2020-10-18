package com.electiva3.proyecto_android_electiva3.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.electiva3.proyecto_android_electiva3.R;
import com.electiva3.proyecto_android_electiva3.entities.Modelo;
import com.electiva3.proyecto_android_electiva3.flujoMarcas.actualizar_marca;

import java.util.ArrayList;

public class ModelosAdapter extends RecyclerView.Adapter< ModelosAdapter.MyViewHolder    >   {

    private LayoutInflater inflater;
    private Context context;
    private ArrayList<Modelo> modelos;


    public ModelosAdapter( Context context ,  ArrayList<Modelo>  modelos ){
        this.inflater  =  LayoutInflater.from(context);
        this.context = context;
        this.modelos  = modelos;
    }

    @Override
    public ModelosAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_lista, parent, false);
        ModelosAdapter.MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ModelosAdapter.MyViewHolder holder, final int position) {
        holder.imgIcon.setImageResource(R.drawable.ic_check);
        holder.tvTitulo.setText(  modelos.get(position).getModelo());
        holder.tvDetalle.setText(  "" );
        holder.tvEstado.setText(  modelos.get(position).getEstado()  );

        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                /*
                String key =  modelos.get(position).getKey();
                Intent actualizarMarca =  new Intent( context   , actualizar_marca.class     );
                actualizarMarca.putExtra("keyModelo" , key   );
                context.startActivity(actualizarMarca);
                */
            }
        });
    }


    @Override
    public int getItemCount() {
        return modelos.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imgIcon;
        TextView tvTitulo;
        TextView tvDetalle;
        TextView tvEstado;


        public MyViewHolder(View itemView) {
            super(itemView);
            //serial_number = (TextView)itemView.findViewById(R.id.serialNo_CL);
            imgIcon = itemView.findViewById(R.id.imgIcon);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            tvDetalle =  itemView.findViewById(R.id.tvDetalle);
            tvEstado =  itemView.findViewById(R.id.tvEstado);
        }
    }

}