/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sis_ges_proyecto2022.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sis_ges_proyecto2022.excepciones.UsuarioException;
import sis_ges_proyecto2022.logica.Usuario;
import sis_ges_proyecto2022.logica.Usuarios;

/**
 *
 * @author 006588869
 */
public class UsuarioPersistencia {

    private static final String PS_SELECT_USUARIO = "SELECT  FROM usuarios where nombre=? and clave=?";
    private static final String PS_UPDATE_USUARIO = "UPDATE grupo_centro.usuarios SET apellido = '?' WHERE (nombre = '?')";
    private static final String PS_INSERT_USUARIO = "INSERT INTO grupo_centro.usuarios (nombre, apellido,clave) VALUES (?, ?, ?)";

    public static void ingresarUsuario(Usuario usuario) throws UsuarioException {

        PreparedStatement ps = null;

        Conexion conexion = new Conexion();
        Connection con = null;
        try {
            con = conexion.conectar();
            ps = con.prepareStatement(PS_INSERT_USUARIO);
            ps.setString(1,usuario.getNombre() );
            //ps.setString(2, usuario.getApellido());
            ps.setString(2, usuario.getClave());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new UsuarioException("No pude insertar el usuario");
        } finally {

        }

    }

    //los metodos para poder realizar un ABM de usuarios ( usuario )
    public Usuarios listaUsuarios() {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 4 : cargar los resultados en los objetos de la capa logica si es un select la consulta
        //paso 5 : cerrar la conexion a la base
        Usuarios usuarios = new Usuarios();
       
        
        return usuarios;

    }

    public static Boolean existeUsuario(Usuario usuario) {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 4 : cargar los resultados en los objetos de la capa logica si es un select la consulta
        //paso 5 : cerrar la conexion a la base
        Boolean resultado = false;

        Conexion con = new Conexion();
        String nombre = usuario.getNombre();
        String clave = usuario.getClave();

        PreparedStatement ps = null;

        ResultSet rs = null;
        try {
            Connection conexion = con.conectar();
            String sqlStm = "select * from db_sis_ges_proyecto2022.usuarios where nombre='" + nombre + "' and clave='" + clave + "';";
            ps = conexion.prepareStatement(sqlStm);
            rs = ps.executeQuery();
            if (rs.next()) {
                resultado = true;
            }

        } catch (SQLException e) {

        }

        return resultado;

    }

    public void altaUsuario(Usuario usuario) {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la base
        
        Conexion con = new Conexion();
        String nombre = usuario.getNombre();
        String clave = usuario.getClave();

        PreparedStatement ps = null;

        ResultSet rs = null;
        try {
            Connection conexion = con.conectar();
            String sqlStm = "select * from db_sis_ges_proyecto2022.usuarios where nombre='" + nombre + "' and clave='" + clave + "';";
            ps = conexion.prepareStatement(sqlStm);
            rs = ps.executeQuery();

        } catch (SQLException e) {

        }

        
    }

    public void bajaUsuario(Usuario usuario) {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la base
    }

    public void modificacionUsuario(Usuario usuario) {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la base
    }

}
