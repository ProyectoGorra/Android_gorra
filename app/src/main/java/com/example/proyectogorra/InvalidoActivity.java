package com.example.proyectogorra;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class InvalidoActivity extends AppCompatActivity implements View.OnClickListener {

    EditText ednombres, edapellido,edEdad,edDireccion;
    Button btnregistrarinv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invalido);
        ednombres = findViewById(R.id.ed_nombre);
        edapellido = findViewById(R.id.ed_apellidos);
        edEdad = findViewById(R.id.ed_edad);
        edDireccion = findViewById(R.id.ed_direccion);

        btnregistrarinv = findViewById(R.id.btnregistrarinv);
        btnregistrarinv.setOnClickListener(this);
    }
            @Override
            public void onClick(View v) {
                final String nombre = ednombres.getText().toString();
                final String apellidos = edapellido.getText().toString();
                final int edad = Integer.parseInt(edEdad.getText().toString());
                final String direccion = edDireccion.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success){
                                Intent intent = new Intent(InvalidoActivity.this,PrincipalActivity.class);
                                InvalidoActivity.this.startActivity(intent);
                            }else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(InvalidoActivity.this);
                                builder.setMessage("Error en el registro del invidente")
                                        .setNegativeButton("Retry",null)
                                        .create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                InvalidoRequest registerinvRequest = new InvalidoRequest(nombre,apellidos,edad,direccion,responseListener);
                RequestQueue queue = Volley.newRequestQueue(InvalidoActivity.this);
                queue.add(registerinvRequest);
            }
        }


