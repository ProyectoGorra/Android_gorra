
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

public class RegistroContacto extends AppCompatActivity implements View.OnClickListener {

    EditText ednombres, edap_paterno,edap_materno,edEdad,eddireccion,edcorreo,edtelefono;
    Button btnregistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_contacto);

        ednombres = findViewById(R.id.ed_nombre);
        edap_paterno = findViewById(R.id.ed_apPaterno);
        edap_materno = findViewById(R.id.ed_apMaterno);
        edEdad = findViewById(R.id.ed_edad);
        eddireccion = findViewById(R.id.ed_direccino);
        edcorreo = findViewById(R.id.ed_correo);
        edtelefono = findViewById(R.id.ed_telefono);

        btnregistrar = findViewById(R.id.btnregistrarcont);
        btnregistrar.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        final String nombres = ednombres.getText().toString();
        final String ap_paterno = edap_paterno.getText().toString();
        final String ap_materno = edap_materno.getText().toString();
        final int edad = Integer.parseInt(edEdad.getText().toString());
        final String direccion = eddireccion.getText().toString();
        final String correo = edcorreo.getText().toString();
        final String telefono = edtelefono.getText().toString();
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        Intent intent = new Intent(RegistroContacto.this, PrincipalActivity.class);
                        Toast.makeText(RegistroContacto.this, "Registro Exitoso", Toast.LENGTH_SHORT).show();
                        RegistroContacto.this.startActivity(intent);

                        finish();
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(RegistroContacto.this);
                        builder.setMessage("Error en el registro del contacto")
                                .setNegativeButton("Retry", null)
                                .create().show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        };

        ContactosRequest contactosRequest = new ContactosRequest(nombres,ap_paterno,ap_materno,edad,direccion,correo,telefono,responseListener);
        RequestQueue queue = Volley.newRequestQueue(RegistroContacto.this);
        queue.add(contactosRequest);
    }
}
