package com.losdistribuidos.turestaurante.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.losdistribuidos.turestaurante.R;
import com.losdistribuidos.turestaurante.models.Sede;

import java.util.List;

/**
 * Created by hadpa on 06/05/2018.
 */

public class SedeAdapter extends RecyclerView.Adapter<SedeAdapter.ViewHolder> {
    private Context context;
    private List<Sede> sedes;

    public SedeAdapter(Context context, List<Sede> sedes) {
        this.context = context;
        this.sedes = sedes;
    }

    @Override
    public SedeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_sede,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SedeAdapter.ViewHolder holder, int position) {
        holder.Direccion.setText(sedes.get(position).getDireccion());
        holder.CantMesa.setText(sedes.get(position).getCantidad_de_mesas());
    }

    @Override
    public int getItemCount() {
        return sedes.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{

        public TextView Direccion, CantMesa;

        public ViewHolder(View itemView) {
            super(itemView);
            Direccion = (TextView) itemView.findViewById(R.id.tv_direccion);
            CantMesa = (TextView) itemView.findViewById(R.id.tv_cantmesas);
        }
    }
}
