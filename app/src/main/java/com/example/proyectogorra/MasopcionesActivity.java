package com.example.proyectogorra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MasopcionesActivity extends AppCompatActivity {

    ImageButton btnlista,btngorra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masopciones);

        btnlista = findViewById(R.id.lista);
        btngorra = findViewById(R.id.gorra);

        btnlista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentlist = new Intent(getApplicationContext(),ListaActivity.class);
                startActivity(intentlist);
            }
        });
        btngorra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentgorra = new Intent(getApplicationContext(),GorraActivity.class);
                startActivity(intentgorra);
            }
        });
    }
}
