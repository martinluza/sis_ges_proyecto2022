/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sis_ges_proyecto2022.logica;

import java.util.ArrayList;

/**
 *
 * @author 006588869
 */
public class Usuarios {

    ArrayList<Usuario> usuarios = new ArrayList();

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public void agregarUsuario(Usuario usuario) {
        this.usuarios.add(usuario); 
    }
}
