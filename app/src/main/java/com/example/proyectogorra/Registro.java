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

public class Registro extends AppCompatActivity implements View.OnClickListener {

    EditText ednombre, edusuario,edpassword;
    Button btn_registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        ednombre = findViewById(R.id.ed_nom);
        edusuario = findViewById(R.id.ed_usu);
        edpassword = findViewById(R.id.ed_pass);

        btn_registrar = findViewById(R.id.btnregistrar);
        btn_registrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        final String name = ednombre.getText().toString();
        final String username = edusuario.getText().toString();
        final String password = edpassword.getText().toString();

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success){
                        Intent intent = new Intent(Registro.this,PrincipalActivity.class);
                        Toast.makeText(Registro.this,"Registro Exitoso",Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        finish();
                    }else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(Registro.this);
                        builder.setMessage("Error en el registro")
                                .setNegativeButton("Retry",null)
                                .create().show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        RegistroRequest registerRequest = new RegistroRequest(name,username,password,responseListener);
        RequestQueue queue = Volley.newRequestQueue(Registro.this);
        queue.add(registerRequest);
    }
}

