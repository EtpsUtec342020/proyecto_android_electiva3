package com.electiva3.proyecto_android_electiva3.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.electiva3.proyecto_android_electiva3.R;
import com.electiva3.proyecto_android_electiva3.entities.Usuario;

import java.util.ArrayList;


public class UsuariosAdapter extends RecyclerView.Adapter<UsuariosAdapter.MyViewHolder> implements View.OnClickListener
{
    private LayoutInflater inflater;
    private Context context;
    private ArrayList<Usuario> usuarios;
    private View.OnClickListener listener;

    public UsuariosAdapter(Context context , ArrayList<Usuario> usuarios ){
        inflater =  LayoutInflater.from(context);
        this.context= context;
        this.usuarios = usuarios;
    }

    @Override
    public UsuariosAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = inflater.inflate(R.layout.item_lista, parent, false);
        UsuariosAdapter.MyViewHolder holder = new UsuariosAdapter.MyViewHolder(view);
        view.setOnClickListener(this);
        return holder;

    }

    @Override
    public void onBindViewHolder(UsuariosAdapter.MyViewHolder holder, int position)
    {
        holder.imgIcon.setImageResource(R.drawable.ic_person);
        holder.tvTitulo.setText(  usuarios.get(position).getNombre());
        holder.tvDetalle.setText( usuarios.get(position).getCorreo() );
        holder.tvEstado.setText(  usuarios.get(position).getEstado());
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    @Override
    public void onClick(View v)
    {
        if(listener!=null)
        {
            listener.onClick(v);
        }
    }

    public void SetOnClickListener(View.OnClickListener Listener)
    {
        this.listener = Listener;
    }


    class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imgIcon;
        TextView tvTitulo;
        TextView tvDetalle;
        TextView tvEstado;

        public MyViewHolder(View itemView)
        {
            super(itemView);
            imgIcon = itemView.findViewById(R.id.imgIcon);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            tvDetalle =  itemView.findViewById(R.id.tvDetalle);
            tvEstado =  itemView.findViewById(R.id.tvEstado);
        }
    }

}
