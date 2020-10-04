package com.electiva3.proyecto_android_electiva3.useradapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.electiva3.proyecto_android_electiva3.R;
import com.electiva3.proyecto_android_electiva3.user_detalle_orden;
import com.electiva3.proyecto_android_electiva3.userentities.UserOrden;

import java.util.ArrayList;

public class OrdenAdapter extends RecyclerView.Adapter<OrdenAdapter.MyViewHolder>   {

    private LayoutInflater inflater;
    private Context context;
    private ArrayList<UserOrden>  ordenes;

    public OrdenAdapter(Context context,ArrayList<UserOrden> ordenes) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.ordenes  =  ordenes;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_orden_lista, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvOrden.setText(ordenes.get(position).getNumeroOrden());
        holder.tvSupervisor.setText(ordenes.get(position).getSupervisor());

        holder.itemView.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent detalleuserOrden  =  new Intent(context , user_detalle_orden.class);
                detalleuserOrden.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(detalleuserOrden);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ordenes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvOrden;
        TextView tvSupervisor;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvOrden = itemView.findViewById(R.id.tvOrden);
            tvSupervisor =  itemView.findViewById(R.id.tvSupervisor);
        }
    }
}
