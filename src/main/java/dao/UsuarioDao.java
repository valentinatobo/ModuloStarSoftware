package dao;

import models.Usuario;
import presentacion.Modelo;


public class UsuarioDao {
    
    Modelo m;

    public UsuarioDao(Modelo m) {
        this.m = m;
    }

    
    public boolean insertar(String nombre, String contra){
        Usuario u = new Usuario(nombre, contra);
        return m.insertarUsuario(u);
    }

    public boolean validar(String nombre, String contra) {
        Usuario u = new Usuario(nombre, contra);
        return m.validarUsuario(u);
    }
    
    
}
