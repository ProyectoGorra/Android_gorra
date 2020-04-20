package com.example.proyectogorra;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegistroRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://192.168.0.12/proyecto/Registro.php";
    private Map<String, String> params;

    public RegistroRequest(String name, String usuario, String password, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("usuario", usuario);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
