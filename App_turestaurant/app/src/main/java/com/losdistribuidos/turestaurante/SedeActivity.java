package com.losdistribuidos.turestaurante;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.losdistribuidos.turestaurante.Adapter.SedeAdapter;
import com.losdistribuidos.turestaurante.models.Sede;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.losdistribuidos.turestaurante.utilities.Constants.URL_SEDESRESTAURANT;

public class SedeActivity extends AppCompatActivity {

    private List<Sede> sedes;
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private SedeAdapter sedeAdapter;
    private String strParament = "";

    private TextView valRazonSocial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sede);

        Bundle dataRestaurant = this.getIntent().getExtras();
        int idRestaurant = dataRestaurant.getInt("idRestaurant");
        strParament = Integer.toString(idRestaurant)+"/sedes";

        String razonSocial = dataRestaurant.getString("razonSocial");
        valRazonSocial = (TextView) findViewById(R.id.tv_restaurant);
        valRazonSocial.setText(String.valueOf("Restaurante: "+razonSocial));

        recyclerView = (RecyclerView) findViewById(R.id.rvSedes);
        sedes = new ArrayList<>();
        loadUrlDataSede(strParament);

        gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        sedeAdapter = new SedeAdapter(this,sedes);
        recyclerView.setAdapter(sedeAdapter);
    }

    private void loadUrlDataSede(String parament) {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.GET,
                URL_SEDESRESTAURANT+parament, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                progressDialog.dismiss();

                try {

                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("data");

                    for (int i = 0; i < array.length(); i++){

                        JSONObject jo = array.getJSONObject(i);

                        Sede dataSede =
                                new Sede( jo.getInt("id"),
                                        jo.getString("direccion"),
                                        "Mesas Disponibles: "+jo.getString("cantidad_de_mesas"));
                        sedes.add(dataSede);
                    }

                    sedeAdapter = new SedeAdapter(getApplicationContext(), sedes);
                    recyclerView.setAdapter(sedeAdapter);

                } catch (JSONException e) {

                    e.printStackTrace();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(SedeActivity.this, "Error" + error.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
