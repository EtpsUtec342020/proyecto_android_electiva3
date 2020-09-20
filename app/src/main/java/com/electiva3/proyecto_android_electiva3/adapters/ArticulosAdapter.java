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
import com.electiva3.proyecto_android_electiva3.detalle_orden;
import com.electiva3.proyecto_android_electiva3.entities.Articulo;
import com.electiva3.proyecto_android_electiva3.entities.Orden;

import java.util.ArrayList;

public class ArticulosAdapter extends RecyclerView.Adapter<ArticulosAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private ArrayList<Articulo> articulos;


    public ArticulosAdapter(Context context,ArrayList<Articulo> articulos) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.articulos  =  articulos;
    }

    @Override
    public ArticulosAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_lista, parent, false);
        ArticulosAdapter.MyViewHolder holder = new ArticulosAdapter.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ArticulosAdapter.MyViewHolder holder, int position) {
        holder.imgIcon.setImageResource(R.drawable.ic_filter_black_24dp);
        holder.tvTitulo.setText(  articulos.get(position).getServicio()  );
        holder.tvDetalle.setText(  articulos.get(position).getPrecio()  );
        holder.tvEstado.setText("");
    }


    @Override
    public int getItemCount() {
        return articulos.size();
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
