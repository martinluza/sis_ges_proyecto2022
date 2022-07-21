/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sis_ges_proyecto2022.logica;

import sis_ges_proyecto2022.excepciones.UsuarioException;
import sis_ges_proyecto2022.persistencia.UsuarioPersistencia;

/**
 *
 * @author 006588869
 */
public class FachadaLogica {

    public static Boolean existeUsuario(Usuario usuario) throws UsuarioException{

        Boolean existe = false;
        existe = UsuarioPersistencia.existeUsuario(usuario);
        return existe;
    }
    
    public static DobleBooleano existeUsuario1(Usuario usuario) throws UsuarioException{
        
        DobleBooleano dobleB = new DobleBooleano();
        dobleB.setPrimerBit(false);
        dobleB.setSegundoBit(false);
        dobleB = UsuarioPersistencia.existeUsuario1(usuario);
        return dobleB;
    }
    
    public static DobleBooleano existeUsuario2(Usuario usuario) throws UsuarioException{
        
        DobleBooleano dobleB = new DobleBooleano();
        dobleB.setPrimerBit(false);
        dobleB.setSegundoBit(false);
        dobleB = UsuarioPersistencia.existeUsuario2(usuario);
        return dobleB;
    }

    public static void ingresarUsuario(Usuario usuario) throws UsuarioException{

        UsuarioPersistencia.ingresarUsuario(usuario);
    }
    
    public static void bajaUsuario(Usuario usuario) throws UsuarioException{

        UsuarioPersistencia.bajaUsuario(usuario);
    }
    
    public static void altaUsuario(Usuario usuario) throws UsuarioException{

        UsuarioPersistencia.altaUsuario(usuario);
    }

}
