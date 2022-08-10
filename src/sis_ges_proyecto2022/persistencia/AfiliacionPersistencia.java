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
import sis_ges_proyecto2022.logica.Afiliado;
import sis_ges_proyecto2022.excepciones.AfiliacionException;
import sis_ges_proyecto2022.excepciones.FechaException;
import sis_ges_proyecto2022.logica.Afiliados;
import sis_ges_proyecto2022.logica.Fecha;
/**
 *
 * @author 006588869
 */
public class AfiliacionPersistencia {
    
    private static final String PS_SELECT_AFILIADO = "SELECT * FROM afiliados where documento = ?";
    private static final String PS_UPDATE_AFILIADO = "UPDATE sis_ges_proyecto2022.afiliados SET estado = '?' WHERE (documento = '?')";
    private static final String PS_INSERT_AFILIADO = "INSERT INTO sis_ges_proyecto2022.afiliados (documento, nombre, apellido, nacionalidad, direccion, telefono, mail, nacimiento, rubro, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String PS_SELECT_LISTA_AFILIADOS = "SELECT * FROM afiliados where estado='activo'";
    private static final String PS_SELECT_LISTA_AFILIADOS_N = "SELECT * FROM afiliados where estado='inactivo'";
    
    
    
     public static void ingresarAfiliado(Afiliado afiliado) throws AfiliacionException {

        PreparedStatement ps = null;

        Conexion conexion = new Conexion();
        Connection con = null;
        try {
            con = conexion.conectar();
            ps = con.prepareStatement(PS_INSERT_AFILIADO);
            ps.setString(1, afiliado.getDocumento() );
            ps.setString(2, afiliado.getNombre() );
            ps.setString(3, afiliado.getApellido());
            ps.setString(4, afiliado.getNacionalidad());
            ps.setString(5, afiliado.getDireccion());
            ps.setInt(6, afiliado.getTelefono());
            ps.setString(7, afiliado.getMail());
            ps.setDate(8, Fecha.convertirStringAFecha(afiliado.getNacimiento()));
            ps.setString(9, afiliado.getRubro());
            ps.setString(10, "activo");

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new AfiliacionException("No pude insertar el afiliado");
        } catch (FechaException ex) {
            Logger.getLogger(AfiliacionPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw new AfiliacionException("No pude insertar la fecha");
        } finally {

        }

    }
     
     public static Afiliados listaAfiliados() throws AfiliacionException {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 4 : cargar los resultados en los objetos de la capa logica si es un select la consulta
        //paso 5 : cerrar la conexion a la base
        Afiliados afiliados = new Afiliados();
        
        PreparedStatement ps = null;
        
        Conexion conexion = new Conexion();
        Connection con = null;
        ResultSet rs = null;
        try {
            con = conexion.conectar();
            ps = con.prepareStatement(PS_SELECT_LISTA_AFILIADOS);
            rs = ps.executeQuery();
            while (rs.next()) {
                Afiliado afiliado = new Afiliado();
                afiliado.setDocumento(rs.getString("documento"));
                afiliado.setNombre(rs.getString("nombre"));
                afiliado.setApellido(rs.getString("apellido"));
                afiliado.setNacionalidad(rs.getString("nacionalidad"));
                afiliado.setDireccion(rs.getString("direccion"));
                afiliado.setTelefono(rs.getInt("telefono"));
                afiliado.setMail(rs.getString("mail"));
                afiliado.setNacimiento(rs.getDate("nacimiento").toString());
                afiliado.setRubro(rs.getString("rubro"));
                afiliados.agregarUsuario(afiliado);
            }
        
        } catch (SQLException e){
            throw new AfiliacionException("Error");
        }
        
        return afiliados;

    }
     
      public static Afiliados listaAfiliadosN() throws AfiliacionException {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 4 : cargar los resultados en los objetos de la capa logica si es un select la consulta
        //paso 5 : cerrar la conexion a la base
        Afiliados afiliados = new Afiliados();
        
        PreparedStatement ps = null;
        
        Conexion conexion = new Conexion();
        Connection con = null;
        ResultSet rs = null;
        try {
            con = conexion.conectar();
            ps = con.prepareStatement(PS_SELECT_LISTA_AFILIADOS_N);
            rs = ps.executeQuery();
            while (rs.next()) {
                Afiliado afiliado = new Afiliado();
                afiliado.setDocumento(rs.getString("documento"));
                afiliado.setNombre(rs.getString("nombre"));
                afiliado.setApellido(rs.getString("apellido"));
                afiliado.setNacionalidad(rs.getString("nacionalidad"));
                afiliado.setDireccion(rs.getString("direccion"));
                afiliado.setTelefono(rs.getInt("telefono"));
                afiliado.setMail(rs.getString("mail"));
                afiliado.setNacimiento(rs.getDate("nacimiento").toString());
                afiliado.setRubro(rs.getString("rubro"));
                afiliados.agregarUsuario(afiliado);
            }
        
        } catch (SQLException e){
            throw new AfiliacionException("Error");
        }
        
        return afiliados;

    }
    
     public static Boolean existeAfiliado(Afiliado afiliado) {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 4 : cargar los resultados en los objetos de la capa logica si es un select la consulta
        //paso 5 : cerrar la conexion a la base
        Boolean resultado = false;

        Conexion con = new Conexion();
        String documento = afiliado.getDocumento();
        

        PreparedStatement ps = null;

        ResultSet rs = null;
        try {
            Connection conexion = con.conectar();
            //String sqlStm = "select * from sis_ges_proyecto2022.afiliados where documento='" + documento + "' and estado = 'activo';";
            String sqlStm = "select * from sis_ges_proyecto2022.afiliados where documento='" + documento + "';";
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
     
    public static String estadoAfiliado(String documento) throws AfiliacionException {
        String estado = new String();
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection conexion = con.conectar();
            //String sqlStm = "select * from sis_ges_proyecto2022.afiliados where documento='" + documento + "' and estado = 'activo';";
            String sqlStm = "select * from sis_ges_proyecto2022.afiliados where documento='" + documento + "';";
            ps = conexion.prepareStatement(sqlStm);
            rs = ps.executeQuery();
            rs.next();
            estado = rs.getString("estado");

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception ex){
        ex.printStackTrace();
        }

        return estado;
    }
     
     public static void bajaAfiliado(String documento) throws AfiliacionException {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la 
       
        PreparedStatement ps = null;
        
        
        

        Conexion conexion = new Conexion();
        Connection con = null;
        try {
            con = conexion.conectar();
            String sqlStm = "UPDATE sis_ges_proyecto2022.afiliados SET estado = 'inactivo'  WHERE (documento = '"+documento+"')";
            ps = con.prepareStatement(sqlStm);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new AfiliacionException("Error");
        }
        
    }
     
     public static void altaAfiliado(String documento) throws AfiliacionException {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la 
       
        PreparedStatement ps = null;
        
        
        

        Conexion conexion = new Conexion();
        Connection con = null;
        try {
            con = conexion.conectar();
            String sqlStm = "UPDATE sis_ges_proyecto2022.afiliados SET estado = 'activo'  WHERE (documento = '"+documento+"')";
            ps = con.prepareStatement(sqlStm);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new AfiliacionException("Error");
        }
        
    }
    
     public static void modificarAfiliado(Afiliado afiliado) throws AfiliacionException {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la 
       
        PreparedStatement ps = null;
        
        String documento = afiliado.getDocumento();
        String nombre = afiliado.getNombre();
        String apellido = afiliado.getApellido();
        String nacionalidad = afiliado.getNacionalidad();
        String direccion = afiliado.getDireccion();
        int telefono = afiliado.getTelefono();
        String mail = afiliado.getMail();
        String nacimiento = afiliado.getNacimiento();
        String rubro = afiliado.getRubro();
        

        Conexion conexion = new Conexion();
        Connection con = null;
        try {
            con = conexion.conectar();
            String sqlStm = "UPDATE sis_ges_proyecto2022.afiliados SET nombre = '"+nombre+"'  WHERE (documento = '"+documento+"')";
            ps = con.prepareStatement(sqlStm);
            ps.executeUpdate();
            sqlStm = "UPDATE sis_ges_proyecto2022.afiliados SET apellido = '"+apellido+"'  WHERE (documento = '"+documento+"')";
            ps = con.prepareStatement(sqlStm);
            ps.executeUpdate();
            sqlStm = "UPDATE sis_ges_proyecto2022.afiliados SET nacionalidad = '"+nacionalidad+"'  WHERE (documento = '"+documento+"')";
            ps = con.prepareStatement(sqlStm);
            ps.executeUpdate();
            sqlStm = "UPDATE sis_ges_proyecto2022.afiliados SET direccion = '"+direccion+"'  WHERE (documento = '"+documento+"')";
            ps = con.prepareStatement(sqlStm);
            ps.executeUpdate();
            sqlStm = "UPDATE sis_ges_proyecto2022.afiliados SET telefono = '"+telefono+"'  WHERE (documento = '"+documento+"')";
            ps = con.prepareStatement(sqlStm);
            ps.executeUpdate();
            sqlStm = "UPDATE sis_ges_proyecto2022.afiliados SET mail = '"+mail+"'  WHERE (documento = '"+documento+"')";
            ps = con.prepareStatement(sqlStm);
            ps.executeUpdate();
            sqlStm = "UPDATE sis_ges_proyecto2022.afiliados SET nacimiento = '"+Fecha.convertirStringAFecha(nacimiento)+"'  WHERE (documento = '"+documento+"')";
            ps = con.prepareStatement(sqlStm);
            ps.executeUpdate();
            sqlStm = "UPDATE sis_ges_proyecto2022.afiliados SET rubro = '"+rubro+"'  WHERE (documento = '"+documento+"')";
            ps = con.prepareStatement(sqlStm);
            ps.executeUpdate();
            
            
        } catch (SQLException e) {
            throw new AfiliacionException("Error");
        } catch (FechaException ex) {
            Logger.getLogger(AfiliacionPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw new AfiliacionException("Error2");
        }
        
    }
     
      public static Afiliado buscarAfiliado(String documento) {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 4 : cargar los resultados en los objetos de la capa logica si es un select la consulta
        //paso 5 : cerrar la conexion a la base
       

        Conexion con = new Conexion();
        
        

        PreparedStatement ps = null;

        ResultSet rs = null;
        Afiliado afiliado = new Afiliado();
        try {
            Connection conexion = con.conectar();
            //String sqlStm = "select * from sis_ges_proyecto2022.afiliados where documento='" + documento + "' and estado = 'activo';";
            String sqlStm = "select * from sis_ges_proyecto2022.afiliados where documento='" + documento + "';";
            ps = conexion.prepareStatement(sqlStm);
            rs = ps.executeQuery();
            rs.next();
            
            afiliado.setDocumento(rs.getString("documento"));
            afiliado.setNombre(rs.getString("nombre"));
            afiliado.setApellido(rs.getString("apellido"));
            afiliado.setNacionalidad(rs.getString("nacionalidad"));
            afiliado.setDireccion(rs.getString("direccion"));
            afiliado.setTelefono(rs.getInt("telefono"));
            afiliado.setMail(rs.getString("mail"));
            afiliado.setNacimiento(rs.getDate("nacimiento").toString());
            afiliado.setRubro(rs.getString("rubro"));
            

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception ex){
        ex.printStackTrace();
        }

        return afiliado;

    }
     
}
