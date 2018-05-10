package com.losdistribuidos.turestaurante;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.losdistribuidos.turestaurante.Adapter.RestaurantAdapter;
import com.losdistribuidos.turestaurante.models.Restaurant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.losdistribuidos.turestaurante.utilities.Constants.URL_RESTAURANT;

/**
 * Created by hadpa on 19/04/2018.
 */

public class RestaurantActivity extends AppCompatActivity {

    private static final String TAG = RestaurantActivity.class.getSimpleName();
    private List<Restaurant> restaurants;
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayout;
    private RestaurantAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        recyclerView = (RecyclerView) findViewById(R.id.rvRestaurants);
        restaurants = new ArrayList<>();
        loadUrlDataRestaurant();

        gridLayout = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayout);

        adapter = new RestaurantAdapter(this, restaurants);
        recyclerView.setAdapter(adapter);

    }

    private void loadUrlDataRestaurant() {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.GET,
                URL_RESTAURANT, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                progressDialog.dismiss();

                try {

                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("data");

                    for (int i = 0; i < array.length(); i++){

                        JSONObject jo = array.getJSONObject(i);

                        Restaurant dataRestaurant =
                                new Restaurant( jo.getInt("id"),
                                        jo.getString("razon_social"),
                                        "RUC: "+jo.getString("ruc"),
                                        "Categoria: "+jo.getString("categoria"));
                        restaurants.add(dataRestaurant);
                    }

                    adapter = new RestaurantAdapter(getApplicationContext(), restaurants);
                    recyclerView.setAdapter(adapter);

                } catch (JSONException e) {

                    e.printStackTrace();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(RestaurantActivity.this, "Error" + error.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
