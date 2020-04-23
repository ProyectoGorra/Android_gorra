package com.example.proyectogorra;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ContactosRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://192.168.0.12/proyecto/RegistroContacto.php";
    private Map<String, String> params;

    public ContactosRequest(String nombres, String ap_paterno,String ap_materno, int edad, String direccion,String correo,String telefono, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("nombres", nombres);
        params.put("ap_paterno",ap_paterno);
        params.put("ap_materno",ap_materno);
        params.put("edad", edad+"");
        params.put("direccion",direccion);
        params.put("correo",correo);
        params.put("telefono",telefono);
    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
