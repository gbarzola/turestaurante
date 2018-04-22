package com.sourcey.turestaurante.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sourcey.turestaurante.Entity.Restaurant;
import com.sourcey.turestaurante.R;

import java.util.List;

/**
 * Created by Usuario on 9/04/2018.
 */

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder>{
    //private Restaurant[] restaurants;
    private List<Restaurant> restaurantList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgViewIcon;
        public TextView txtViewName, txtViewAddress, txtViewMobile;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            imgViewIcon = (ImageView) itemLayoutView.findViewById(R.id.item_icon);
            txtViewName = (TextView) itemLayoutView.findViewById(R.id.item_name);
            txtViewAddress = (TextView) itemLayoutView.findViewById(R.id.item_address);
            txtViewMobile = (TextView) itemLayoutView.findViewById(R.id.item_mobile);
        }
    }

    public RestaurantAdapter(List<Restaurant> restaurantList) {this.restaurantList = restaurantList;}

    @Override
    public RestaurantAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RestaurantAdapter.ViewHolder viewHolder, int position) {
        Restaurant restaurant = restaurantList.get(position);
        viewHolder.imgViewIcon.setImageResource(restaurant.getPhoto());
        viewHolder.txtViewName.setText(restaurant.getName());
        viewHolder.txtViewAddress.setText(restaurant.getAddress());
        viewHolder.txtViewMobile.setText(restaurant.getMobile());
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }
}
