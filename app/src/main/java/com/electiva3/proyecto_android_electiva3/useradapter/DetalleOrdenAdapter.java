package com.electiva3.proyecto_android_electiva3.useradapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.electiva3.proyecto_android_electiva3.R;
import com.electiva3.proyecto_android_electiva3.user_detalle_orden;
import com.electiva3.proyecto_android_electiva3.userentities.UserDetalleOrden;

import java.util.ArrayList;

public class DetalleOrdenAdapter extends RecyclerView.Adapter<DetalleOrdenAdapter.MyViewHolder>  {
    private LayoutInflater inflater;
    private Context context;
    private ArrayList<UserDetalleOrden> detordenes;

    public DetalleOrdenAdapter(Context context,ArrayList<UserDetalleOrden> detordenes) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.detordenes  =  detordenes;
    }

    @Override
    public DetalleOrdenAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_detalle_orden_lista, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(DetalleOrdenAdapter.MyViewHolder holder, int position) {
        holder.tvServicio.setText(detordenes.get(position).getNombreServicio());
        holder.tvPrecio.setText(detordenes.get(position).getPrecio());
        holder.imgIcon.setImageResource(R.drawable.ic_check);
    }

    @Override
    public int getItemCount() {
        return detordenes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvServicio;
        TextView tvPrecio;
        ImageView imgIcon;


        public MyViewHolder(View itemView) {
            super(itemView);
            tvServicio = itemView.findViewById(R.id.tvOrden);
            tvPrecio   = itemView.findViewById(R.id.tvSupervisor);
            imgIcon = itemView.findViewById(R.id.imgIcon);

        }
    }
}
