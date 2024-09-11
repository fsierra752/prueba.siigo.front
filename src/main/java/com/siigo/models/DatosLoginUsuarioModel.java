package com.siigo.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DatosLoginUsuarioModel {

    private String user;
    private String password;

    private DatosLoginUsuarioModel(Map<String, String> datosUsuario){
        this.user = datosUsuario.get("user");
        this.password = datosUsuario.get("password");
    }

    private List<DatosLoginUsuarioModel> lstUsuarios = new ArrayList<>();

    private void asignarDatos(List<Map<String, String>> datosUsuario){
        for (Map<String, String> dato : datosUsuario){
            lstUsuarios.add(new DatosLoginUsuarioModel(dato));
        }
    }

    public DatosLoginUsuarioModel(List<Map<String, String>> datosUsuario){
        asignarDatos(datosUsuario);
    }

    public List<DatosLoginUsuarioModel> getLstUsuarios(){
        return lstUsuarios;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
