package com.example.proyectogorra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {

    private static final String URL_invidentes = "http://192.168.0.12/proyecto/lista.php";

    ArrayList<Invidentes> listInv;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listInv = new ArrayList<Invidentes>();

        cargarinvidentes();
    }

    private void cargarinvidentes(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_invidentes, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);

                    for (int i = 0; i < array.length(); i++) {
                        JSONObject invidente = array.getJSONObject(i);

                        listInv.add(new Invidentes(
                                invidente.getString("Nombre"),
                                invidente.getString("Apellidos")
                        ));
                    }
                    InvidentesAdapter invidentesAdapter = new InvidentesAdapter(ListaActivity.this, listInv);
                    recyclerView.setAdapter(invidentesAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(this).add(stringRequest);
}
}
