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

    private static final String PS_SELECT_USUARIO = "SELECT * FROM usuarios where nombre=? and clave=?";
    // private static final String PS_UPDATE_USUARIO = "UPDATE db_sis_ges_proyecto2022.usuarios SET apellido = '?' WHERE (nombre = '?')";
    private static final String PS_INSERT_USUARIO = "INSERT INTO sis_ges_proyecto2022.usuarios (nombre, clave, estado) VALUES (?, ?, ?)";
    private static final String PS_SELECT_LISTA_USUARIO = "SELECT * FROM usuarios where estado='activo'";

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
            ps.setString(3, "activo");

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new UsuarioException("No pude insertar el usuario");
        } finally {

        }

    }

    //los metodos para poder realizar un ABM de usuarios ( usuario )
    public Usuarios listaUsuarios() throws UsuarioException {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 4 : cargar los resultados en los objetos de la capa logica si es un select la consulta
        //paso 5 : cerrar la conexion a la base
        Usuarios usuarios = new Usuarios();
        
        PreparedStatement ps = null;
        
        Conexion conexion = new Conexion();
        Connection con = null;
        ResultSet rs = null;
        try {
            con = conexion.conectar();
            ps = con.prepareStatement(PS_SELECT_LISTA_USUARIO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setNombre(rs.getString("nombre"));
                user.setClave(rs.getString("clave"));    
                usuarios.agregarUsuario(user);
            }
        
        } catch (SQLException e){
            throw new UsuarioException("Error");
        }
        
        return usuarios;

    }

    public static Boolean existeUsuario(Usuario usuario) throws UsuarioException {

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
            String sqlStm = "select * from sis_ges_proyecto2022.usuarios where nombre='" + nombre + "' and clave='" + clave + "' and estado = 'activo';";
            ps = conexion.prepareStatement(sqlStm);
            rs = ps.executeQuery();
            if (rs !=null&& rs.next()) {
                resultado = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception ex){
        ex.printStackTrace();
        }

        return resultado;

    }

    public void bajaUsuario(Usuario usuario) throws UsuarioException {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la 
       
        PreparedStatement ps = null;
        
        String nombre = usuario.getNombre();
        String clave = usuario.getClave();

        Conexion conexion = new Conexion();
        Connection con = null;
        try {
            con = conexion.conectar();
            String sqlStm = "UPDATE sis_ges_proyecto2022.usuarios SET estado = 'inactivo' WHERE (nombre = '"+nombre+"' and clave = '"+clave+"')";
            ps = conexion.prepareStatement(sqlStm);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new UsuarioException("Error");
        }
        
    }

}
