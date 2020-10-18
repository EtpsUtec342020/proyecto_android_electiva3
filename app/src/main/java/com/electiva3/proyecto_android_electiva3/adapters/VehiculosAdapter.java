package com.electiva3.proyecto_android_electiva3.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.electiva3.proyecto_android_electiva3.R;
import com.electiva3.proyecto_android_electiva3.entities.DetalleOrden;
import com.electiva3.proyecto_android_electiva3.entities.Vehiculo;

import java.util.ArrayList;

public class VehiculosAdapter extends RecyclerView.Adapter<VehiculosAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private ArrayList<Vehiculo> vehiculos;

    public VehiculosAdapter(Context context , ArrayList<Vehiculo> vehiculos){
            inflater = LayoutInflater.from(context);
            this.context =  context;
            this.vehiculos =  vehiculos;
    }


    @Override
    public VehiculosAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_lista, parent, false);
        VehiculosAdapter.MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(VehiculosAdapter.MyViewHolder holder, int position) {
        holder.imgIcon.setImageResource(R.drawable.ic_check);
        holder.tvTitulo.setText(  vehiculos.get(position).getMarca()+ "  - " +vehiculos.get(position).getModelo() );
        holder.tvDetalle.setText(  vehiculos.get(position).getPlaca() );
        holder.tvEstado.setText(  vehiculos.get(position).getAnio()  );
    }


    @Override
    public int getItemCount() {
        return vehiculos.size();
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