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
import sis_ges_proyecto2022.excepciones.AfiliacionesException;
import sis_ges_proyecto2022.excepciones.FechaException;
import sis_ges_proyecto2022.logica.Afiliaciones;
import sis_ges_proyecto2022.logica.Fecha;

/**
 *
 * @author mauri
 */
public class AfiliacionesPersistencia {
    
    private static final String PS_SELECT_AFILIACIONES = "SELECT * FROM afiliciones where ID = ?";
    private static final String PS_UPDATE_AFILIACIONES = "UPDATE sis_ges_proyecto2022.afiliaciones SET estado = '?' WHERE (documento = '?')";
    private static final String PS_INSERT_AFILIACIONES = "INSERT INTO sis_ges_proyecto2022.afiliaciones (ID, deuda, cuota, fecha_ult_pago, fecha_alta, estado) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String PS_SELECT_LISTA_AFILIACIONES = "SELECT * FROM afiliaciones where estado='activo'";
    
    
     public static void ingresarAfiliacion(Afiliaciones afiliacion) throws AfiliacionesException, SQLException {

        PreparedStatement ps = null;

        Conexion conexion = new Conexion();
        Connection con = null;
        try {
            con = conexion.conectar();
            ps = con.prepareStatement(PS_INSERT_AFILIACIONES);
            ps.setString(1, afiliacion.getId());
            ps.setInt(2, afiliacion.getCuota());
            ps.setInt(3, afiliacion.getCuota());
            
            ps.setDate(4, Fecha.convertirStringAFecha(afiliacion.getFecha_ult_pago()));
            ps.setDate(5, Fecha.convertirStringAFecha(afiliacion.getFecha_alta()));
            
            ps.setString(6, "activo");
            
            

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new AfiliacionesException("No pudo realizar la afiliacion");
        } catch (FechaException ex) {
            Logger.getLogger(AfiliacionesPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw new AfiliacionesException("No pude insertar la fecha");
        } finally {

        }

    }
     
     public static Boolean existeAfiliacion(Afiliaciones afiliacion) {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 4 : cargar los resultados en los objetos de la capa logica si es un select la consulta
        //paso 5 : cerrar la conexion a la base
        Boolean resultado = false;

        Conexion con = new Conexion();
        String id = afiliacion.getId();
        

        PreparedStatement ps = null;

        ResultSet rs = null;
        try {
            Connection conexion = con.conectar();
            String sqlStm = "select * from sis_ges_proyecto2022.afiliaciones where ID='" + id + "' and estado = 'activo';";
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
     
    public static void bajaAfiliacion(Afiliaciones afiliacion) throws AfiliacionesException {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la 
       
        PreparedStatement ps = null;
        
        String id = afiliacion.getId();
        

        Conexion conexion = new Conexion();
        Connection con = null;
        try {
            con = conexion.conectar();
            String sqlStm = "UPDATE sis_ges_proyecto2022.afiliados SET estado = 'inactivo'  WHERE (ID = '"+id+"')";
            ps = con.prepareStatement(sqlStm);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new AfiliacionesException("Error");
        }
        
    }
    
    public static void altaAfiliacion(Afiliaciones afiliacion) throws AfiliacionesException {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la 
       
        PreparedStatement ps = null;
        
        String id = afiliacion.getId();
        

        Conexion conexion = new Conexion();
        Connection con = null;
        try {
            con = conexion.conectar();
            String sqlStm = "UPDATE sis_ges_proyecto2022.afiliados SET estado = 'activo'  WHERE (documento = '"+id+"')";
            ps = con.prepareStatement(sqlStm);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new AfiliacionesException("Error");
        }
        
    }
    
    public static void modificarAfiliacion(Afiliaciones afiliacion) throws AfiliacionesException {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la 
       
        PreparedStatement ps = null;
        
        String id = afiliacion.getId();
        int deuda = afiliacion.getDeuda();
        int cuota = afiliacion.getCuota();
        String fecha_ult_pago = afiliacion.getFecha_ult_pago();
        String fecha_alta = afiliacion.getFecha_alta();
        
        

        Conexion conexion = new Conexion();
        Connection con = null;
        try {
            con = conexion.conectar();
            String sqlStm = "UPDATE sis_ges_proyecto2022.afiliaciones SET deuda = '"+deuda+"'  WHERE (ID = '"+id+"')";
            ps = con.prepareStatement(sqlStm);
            ps.executeUpdate();
            sqlStm = "UPDATE sis_ges_proyecto2022.afiliaciones SET cuota = '"+cuota+"'  WHERE (ID = '"+id+"')";
            ps = con.prepareStatement(sqlStm);
            ps.executeUpdate();
            
            sqlStm = "UPDATE sis_ges_proyecto2022.afiliaciones SET fecha_ult_pago = '"+Fecha.convertirStringAFecha(fecha_ult_pago)+"'  WHERE (documento = '"+id+"')";
            ps = con.prepareStatement(sqlStm);
            ps.executeUpdate();
            sqlStm = "UPDATE sis_ges_proyecto2022.afiliaciones SET fecha_alta = '"+Fecha.convertirStringAFecha(fecha_alta)+"'  WHERE (documento = '"+id+"')";
            ps = con.prepareStatement(sqlStm);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new AfiliacionesException("Error");
        } catch (FechaException ex) {
            Logger.getLogger(AfiliacionPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw new AfiliacionesException("Error2");
        }
        
    }
}
