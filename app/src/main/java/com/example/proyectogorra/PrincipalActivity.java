package com.example.proyectogorra;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity {

    Button btncerrar;
    ImageButton btnreg,btnstatus,btncontacto,btnmodificar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btncerrar = findViewById(R.id.btnCerrar);
        btnreg = findViewById(R.id.registro);
        btnmodificar = findViewById(R.id.modificar);
        btncontacto = findViewById(R.id.contactos);
        btnstatus = findViewById(R.id.status);

        btncerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("preferenciasLogin", Context.MODE_PRIVATE);
                preferences.edit().clear().apply();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                Toast toast = Toast.makeText(getApplicationContext(),"Sesion Cerrada",Toast.LENGTH_SHORT);
                toast.show();
                finish();
            }
        });
        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentreg = new Intent(getApplicationContext(),InvalidoActivity.class);
                startActivity(intentreg);
            }
        });

        btnstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentstatus = new Intent(getApplicationContext(),MasopcionesActivity.class);
                startActivity(intentstatus);
            }
        });
    }
}
