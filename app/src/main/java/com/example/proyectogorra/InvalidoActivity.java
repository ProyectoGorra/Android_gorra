package com.example.proyectogorra;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class InvalidoActivity extends AppCompatActivity implements View.OnClickListener {

    EditText ednombres, edapellido,edEdad,edTipoSangre;
    Button btnregistrarinv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invalido);
        ednombres = findViewById(R.id.ed_nombre);
        edapellido = findViewById(R.id.ed_apellidos);
        edEdad = findViewById(R.id.ed_edad);
        edTipoSangre = findViewById(R.id.ed_tipoSangre);

        btnregistrarinv = findViewById(R.id.btnregistrarinv);
        btnregistrarinv.setOnClickListener(this);
    }
            @Override
            public void onClick(View v) {
                final String nombre = ednombres.getText().toString();
                final String apellidos = edapellido.getText().toString();
                final int edad = Integer.parseInt(edEdad.getText().toString());
                final String tipo_sangre = edTipoSangre.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success){
                                Intent intent = new Intent(InvalidoActivity.this,PrincipalActivity.class);
                                Toast.makeText(InvalidoActivity.this,"Registro Exitoso",Toast.LENGTH_SHORT).show();
                                InvalidoActivity.this.startActivity(intent);

                                finish();
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

                InvalidoRequest registerinvRequest = new InvalidoRequest(nombre,apellidos,edad,tipo_sangre,responseListener);
                RequestQueue queue = Volley.newRequestQueue(InvalidoActivity.this);
                queue.add(registerinvRequest);
            }
        }


