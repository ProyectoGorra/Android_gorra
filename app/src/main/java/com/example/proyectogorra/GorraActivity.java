package com.example.proyectogorra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.android.volley.Request.*;

public class GorraActivity extends AppCompatActivity {

    ArrayList<String> listdatos;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gorra);

        recyclerView = findViewById(R.id.RVgorra);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        listdatos=new ArrayList<>();
        String url = "https://io.adafruit.com/api/v2/VictorGP/feeds/counter/data";

            JsonObjectRequest request = new JsonObjectRequest(Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        int getcentimetros = response.getInt("value");
                        String envcentimetros = getcentimetros + "cms";
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("OnErrorResponse: ", error.toString());
                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();

                    params.put("X-AIO-Key", "aio_SaIw01zkDnR8SFZIKmeOvrJLwuyt");

                    return params;
                }
            };
            ArrayList<JsonObjectRequest> fRequestQueue = null;
            fRequestQueue.add(request);
        }
    }
