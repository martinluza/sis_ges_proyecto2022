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
import sis_ges_proyecto2022.excepciones.LocalException;
import sis_ges_proyecto2022.logica.Afiliado;
import sis_ges_proyecto2022.logica.Local;
import sis_ges_proyecto2022.logica.Locales;

/**
 *
 * @author mauri
 */
public class LocalPersistencia {
    private static final String PS_SELECT_LOCAL = "SELECT * FROM locales where id = ?";
    private static final String PS_UPDATE_LOCAL = "UPDATE sis_ges_proyecto2022.locales SET estado = '?' WHERE (id = '?')";
    private static final String PS_INSERT_LOCAL = "INSERT INTO sis_ges_proyecto2022.locales (id, direccion, numero, negocio, encargado, afiliado ,estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String PS_SELECT_LISTA_LOCALES = "SELECT * FROM locales where estado='activo'";
    
     public static void ingresarLocal(Local local) throws LocalException, SQLException {

        PreparedStatement ps = null;

        Conexion conexion = new Conexion();
        Connection con = null;
        try {
            con = conexion.conectar();
            ps = con.prepareStatement(PS_INSERT_LOCAL);
            ps.setString(1, local.getId() );
            ps.setString(2, local.getDireccion() );
            ps.setString(3, local.getNumero());
            ps.setString(4, local.getNegocio());
            ps.setString(5, local.getEncargado());
            ps.setString(6, local.getAfiliado());
            ps.setString(7, "activo");

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new LocalException("No pude insertar el local");
        } finally {

        }

    }
     
      public Locales listaLocales() throws LocalException {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 4 : cargar los resultados en los objetos de la capa logica si es un select la consulta
        //paso 5 : cerrar la conexion a la base
        Locales locales = new Locales();
        
        PreparedStatement ps = null;
        
        Conexion conexion = new Conexion();
        Connection con = null;
        ResultSet rs = null;
        try {
            con = conexion.conectar();
            ps = con.prepareStatement(PS_SELECT_LISTA_LOCALES);
            rs = ps.executeQuery();
            while (rs.next()) {
                Local local = new Local();
                local.setId(rs.getString("id"));
                local.setDireccion(rs.getString("direccion"));
                local.setNumero(rs.getString("numero"));
                local.setNegocio(rs.getString("negocio"));
                local.setEncargado(rs.getString("encargado"));
                local.setAfiliado(rs.getString("afiliado"));
                locales.agregarLocal(local);
            }
        
        } catch (SQLException e){
            throw new LocalException("Error");
        }
        
        return locales;

      }
      
      public static Locales listaLocalesRestringida(String documento) throws LocalException {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 4 : cargar los resultados en los objetos de la capa logica si es un select la consulta
        //paso 5 : cerrar la conexion a la base
        Locales locales = new Locales();
        
        PreparedStatement ps = null;
        
        Conexion conexion = new Conexion();
        Connection con = null;
        ResultSet rs = null;
        try {
            con = conexion.conectar();
            ps = con.prepareStatement("SELECT * FROM locales where estado='activo' AND afiliado = '" + documento + "'");
            rs = ps.executeQuery();
            while (rs.next()) {
                Local local = new Local();
                local.setId(rs.getString("id"));
                local.setDireccion(rs.getString("direccion"));
                local.setNumero(rs.getString("numero"));
                local.setNegocio(rs.getString("negocio"));
                local.setEncargado(rs.getString("encargado"));
                local.setAfiliado(rs.getString("afiliado"));
                locales.agregarLocal(local);
            }
        
        } catch (SQLException e){
            throw new LocalException("Error");
        }
        
        return locales;

    }
      
    public static void bajalocal(Local local) throws LocalException {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la 
       
        PreparedStatement ps = null;
        
        String id = local.getId();
        

        Conexion conexion = new Conexion();
        Connection con = null;
        try {
            con = conexion.conectar();
            String sqlStm = "UPDATE sis_ges_proyecto2022.locales SET estado = 'inactivo'  WHERE (id = '"+id+"')";
            ps = con.prepareStatement(sqlStm);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new LocalException("Error");
        }
        
    }
      
    public static void altaLocal(Local local) throws LocalException {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la 
       
        PreparedStatement ps = null;
        
        String id = local.getId();
        

        Conexion conexion = new Conexion();
        Connection con = null;
        try {
            con = conexion.conectar();
            String sqlStm = "UPDATE sis_ges_proyecto2022.locales SET estado = 'activo'  WHERE (id = '"+id+"')";
            ps = con.prepareStatement(sqlStm);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new LocalException("Error");
        }
        
    } 
    
    public static void modificarLocal(Local local) throws LocalException {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la 
       
        PreparedStatement ps = null;
        
        String id = local.getId();
        String direccion = local.getDireccion();
        String numero = local.getNumero();
        String negocio = local.getNegocio();
        String encargado = local.getEncargado();
        String afiliado = local.getAfiliado();
        
        

        Conexion conexion = new Conexion();
        Connection con = null;
        try {
            con = conexion.conectar();
            String sqlStm = "UPDATE sis_ges_proyecto2022.locales SET direccion = '"+direccion+"'  WHERE (id = '"+id+"')";
            ps = con.prepareStatement(sqlStm);
            ps.executeUpdate();
            sqlStm = "UPDATE sis_ges_proyecto2022.locales SET numero = '"+numero+"'  WHERE (id = '"+id+"')";
            ps = con.prepareStatement(sqlStm);
            ps.executeUpdate();
            sqlStm = "UPDATE sis_ges_proyecto2022.locales SET negocio = '"+negocio+"'  WHERE (id = '"+id+"')";
            ps = con.prepareStatement(sqlStm);
            ps.executeUpdate();
            sqlStm = "UPDATE sis_ges_proyecto2022.locales SET encargado = '"+encargado+"'  WHERE (id = '"+id+"')";
            ps = con.prepareStatement(sqlStm);
            ps.executeUpdate();
            sqlStm = "UPDATE sis_ges_proyecto2022.locales SET afiliado = '"+afiliado+"'  WHERE (id = '"+id+"')";
            ps = con.prepareStatement(sqlStm);
            ps.executeUpdate();
            

        } catch (SQLException e) {
            throw new LocalException("Error");
        }
        
    }
    
    public static Local buscarLocal(String id) throws LocalException {
        Local local = new Local();
        
        PreparedStatement ps = null;
        
        Conexion conexion = new Conexion();
        Connection con = null;
        ResultSet rs = null;
        try {
            con = conexion.conectar();
            ps = con.prepareStatement("SELECT * FROM locales where estado='activo' AND id = '" + id + "'");
            rs = ps.executeQuery();
            rs.next();
            local.setId(rs.getString("id"));
            local.setDireccion(rs.getString("direccion"));
            local.setNumero(rs.getString("numero"));
            local.setNegocio(rs.getString("negocio"));
            local.setEncargado(rs.getString("encargado"));
            local.setAfiliado(rs.getString("afiliado"));
            
            
        
        } catch (SQLException e){
            throw new LocalException("Error");
        }
        
        return local;
    }
    
    public static Boolean existeLocal(String id){
        Boolean resultado = false;

        Conexion con = new Conexion();

        PreparedStatement ps = null;

        ResultSet rs = null;
        try {
            Connection conexion = con.conectar();
            String sqlStm = "select * from sis_ges_proyecto2022.locales where id='" + id + "';";
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
}
