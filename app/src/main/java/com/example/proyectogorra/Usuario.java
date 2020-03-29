package com.example.proyectogorra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Usuario extends AppCompatActivity {

    TextView tvnombre,tvusuario,tvedad,tvpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        tvnombre = findViewById(R.id.nombre);
        tvusuario = findViewById(R.id.usuario);
        tvedad = findViewById(R.id.edad);
        tvpassword = findViewById(R.id.password);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String username = intent.getStringExtra("username");
        String password = intent.getStringExtra("password");
        int age = intent.getIntExtra("age",-1);

        tvnombre.setText(name);
        tvusuario.setText(username);
        tvpassword.setText(password);
        tvedad.setText(age+"");
    }
}
