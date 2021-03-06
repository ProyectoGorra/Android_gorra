package com.example.proyectogorra;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class InvalidoRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://192.168.0.12/proyecto/RegistroInvidente.php";
    private Map<String, String> params;

    public InvalidoRequest(String nombres, String apellidos, int edad, String tipo_sangre, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("nombres", nombres);
        params.put("apellidos",apellidos);
        params.put("edad", edad+"");
        params.put("tipo_sangre",tipo_sangre);
    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
