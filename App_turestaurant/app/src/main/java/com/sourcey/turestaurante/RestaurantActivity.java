package com.sourcey.turestaurante;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.sourcey.turestaurante.Adapter.RestaurantAdapter;
import com.sourcey.turestaurante.Entity.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantActivity extends AppCompatActivity {
    protected List<Restaurant> restaurantList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RestaurantAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant );
/*
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);*/

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new RestaurantAdapter(restaurantList);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Restaurant restaurant = restaurantList.get(position);
                Toast.makeText(getApplicationContext(), restaurant.getName()+ " SELECCIONADO!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareMovieData();

        //Intent intent = new Intent(this, LoginActivity.class);
        //startActivity(intent);
    }

    private void prepareMovieData(){
        Restaurant restaurant = new Restaurant(R.drawable.norkis,"Norkis", "Av. Abancay - Cercado de Lima", "947847205");
        restaurantList.add(restaurant);
        restaurant = new Restaurant(R.drawable.pardos, "Pardos", "Av. Arequipa - San Isidro", "947874201");
        restaurantList.add(restaurant);
        restaurant = new Restaurant(R.drawable.begui, "Begui", "Av. Arequipa - Lince", "947847202");
        restaurantList.add(restaurant);
        restaurant = new Restaurant(R.drawable.pardos, "Pardos", "Av. Arequipa - San Isidro", "947874201");
        restaurantList.add(restaurant);
        restaurant = new Restaurant(R.drawable.begui, "Begui", "Av. Arequipa - Lince", "947847202");
        restaurantList.add(restaurant);
        restaurant = new Restaurant(R.drawable.pardos, "Pardos", "Av. Arequipa - San Isidro", "947874201");
        restaurantList.add(restaurant);
        restaurant = new Restaurant(R.drawable.begui, "Begui", "Av. Arequipa - Lince", "947847202");
        restaurantList.add(restaurant);

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}