package com.losdistribuidos.turestaurante.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.losdistribuidos.turestaurante.R;
import com.losdistribuidos.turestaurante.SedeActivity;
import com.losdistribuidos.turestaurante.models.Restaurant;

import java.util.List;

/**
 * Created by hadpa on 19/04/2018.
 */

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder>{
    private Context context;
    private List<Restaurant> restaurants;

    public RestaurantAdapter(Context context, List<Restaurant> restaurants) {
        this.context = context;
        this.restaurants = restaurants;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_restaurant,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.RazonSocial.setText(restaurants.get(position).getRazon_social());
        holder.Ruc.setText(restaurants.get(position).getRuc());
        holder.Categoria.setText(restaurants.get(position).getCategoria());
        //Glide.with(context).load(restaurants.get(position).getAvatar_url ()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView RazonSocial, Ruc, Categoria;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            RazonSocial = (TextView) itemView.findViewById(R.id.tv_razon_social);
            Ruc = (TextView) itemView.findViewById(R.id.tv_ruc);
            Categoria = (TextView) itemView.findViewById(R.id.tv_categoria);
            //imageView = (ImageView) itemView.findViewById(R.id.image_restaurant);
            RazonSocial.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            Intent intent  = new Intent(context.getApplicationContext(), SedeActivity.class);
            intent.putExtra("idRestaurant", restaurants.get(getAdapterPosition()).getId());
            intent.putExtra("razonSocial", restaurants.get(getAdapterPosition()).getRazon_social());
            context.getApplicationContext().startActivity(intent);

            //esto es para el menu
            //int position = getAdapterPosition();
            //showPopupMenu(v,position);
        }
    }

    private void showPopupMenu(View view, int poaition) {
        PopupMenu popup = new PopupMenu(context, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_context, popup.getMenu());
        popup.setOnMenuItemClickListener(new MenuClickListener(poaition));
        popup.show();
    }


    class MenuClickListener implements PopupMenu.OnMenuItemClickListener {
        Integer pos;
        public MenuClickListener(int pos) {
            this.pos=pos;
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_favourite:
                    Toast.makeText(context, restaurants.get(pos).getId() +" se agrega a favoritos", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_watch:
                    //Toast.makeText(context, restaurants.get(pos).getName()+" se agrega a la lista de seguimiento", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_book:
                    //Toast.makeText(context, "Boleto reservado para "+restaurants.get(pos).getName(), Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }
}
