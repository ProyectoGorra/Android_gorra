package com.example.proyectogorra;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView tv_registrar;
    EditText edusu,edpass;
    Button btn_log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_registrar = findViewById(R.id.tv_registrar);
        btn_log = findViewById(R.id.btnini);
        edusu = findViewById(R.id.tv_usuario);
        edpass = findViewById(R.id.tv_pass);
        tv_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intregistro = new Intent(MainActivity.this,Registro.class);
                MainActivity.this.startActivity(intregistro);
            }
        });
        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = edusu.getText().toString();
                final String password = edpass.getText().toString();
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success){
                                String name = jsonResponse.getString("name");
                                int age = jsonResponse.getInt("age");
                                Intent intent = new Intent(MainActivity.this,Usuario.class);
                                intent.putExtra("name",name);
                                intent.putExtra("username",username);
                                intent.putExtra("age",age);
                                intent.putExtra("password",password);
                                MainActivity.this.startActivity(intent);
                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                builder.setMessage("Error al Logear")
                                        .setNegativeButton("Retry",null)
                                        .create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(username,password,responseListener);
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(loginRequest);
            }
        });
    }
}
