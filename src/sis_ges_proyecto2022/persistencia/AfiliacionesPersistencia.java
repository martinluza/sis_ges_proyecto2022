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
import sis_ges_proyecto2022.logica.Afiliado;
import sis_ges_proyecto2022.logica.Afiliados;
import sis_ges_proyecto2022.logica.Fecha;

/**
 *
 * @author mauri
 */
public class AfiliacionesPersistencia {
    
    private static final String PS_SELECT_AFILIACIONES = "SELECT * FROM afiliciones where ID = ?";
    private static final String PS_UPDATE_AFILIACIONES = "UPDATE sis_ges_proyecto2022.afiliaciones SET estado = '?' WHERE (documento = '?')";
    private static final String PS_INSERT_AFILIACIONES = "INSERT INTO sis_ges_proyecto2022.afiliaciones (id, deuda, cuota, ultimo, alta, estado) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String PS_SELECT_LISTA_AFILIACIONES = "SELECT * FROM afiliaciones where estado='activo'";
    
    
     public static void ingresarAfiliacion(Afiliaciones afiliacion) throws AfiliacionesException, SQLException {

        PreparedStatement ps = null;

        Conexion conexion = new Conexion();
        Connection con = null;
        try {
            con = conexion.conectar();
            ps = con.prepareStatement(PS_INSERT_AFILIACIONES);
            ps.setString(1, afiliacion.getId());
            ps.setInt(2, afiliacion.getDeuda());
            ps.setInt(3, afiliacion.getCuota());
            
            ps.setDate(4, Fecha.convertirStringAFecha(afiliacion.getUltimo()));
            ps.setDate(5, Fecha.convertirStringAFecha(afiliacion.getAlta()));
            
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
            String sqlStm = "select * from sis_ges_proyecto2022.afiliaciones where id='" + id + "' and estado = 'activo';";
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
            String sqlStm = "UPDATE sis_ges_proyecto2022.afiliados SET estado = 'inactivo'  WHERE (id = '"+id+"')";
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
            String sqlStm = "UPDATE sis_ges_proyecto2022.afiliados SET estado = 'activo'  WHERE (id = '"+id+"')";
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
        String ultimo = afiliacion.getUltimo();
        String alta = afiliacion.getAlta();
        
        

        Conexion conexion = new Conexion();
        Connection con = null;
        try {
            con = conexion.conectar();
            String sqlStm = "UPDATE sis_ges_proyecto2022.afiliaciones SET deuda = '"+deuda+"'  WHERE (id = '"+id+"')";
            ps = con.prepareStatement(sqlStm);
            ps.executeUpdate();
            sqlStm = "UPDATE sis_ges_proyecto2022.afiliaciones SET cuota = '"+cuota+"'  WHERE (id = '"+id+"')";
            ps = con.prepareStatement(sqlStm);
            ps.executeUpdate();
            
            sqlStm = "UPDATE sis_ges_proyecto2022.afiliaciones SET ultimo = '"+Fecha.convertirStringAFecha(ultimo)+"'  WHERE (id = '"+id+"')";
            ps = con.prepareStatement(sqlStm);
            ps.executeUpdate();
            sqlStm = "UPDATE sis_ges_proyecto2022.afiliaciones SET alta = '"+Fecha.convertirStringAFecha(alta)+"'  WHERE (id = '"+id+"')";
            ps = con.prepareStatement(sqlStm);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new AfiliacionesException("Error");
        } catch (FechaException ex) {
            Logger.getLogger(AfiliacionPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw new AfiliacionesException("Error2");
        }
        
    }
    
    public static Afiliaciones buscarAfiliacion(String id) {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 4 : cargar los resultados en los objetos de la capa logica si es un select la consulta
        //paso 5 : cerrar la conexion a la base

        Conexion con = new Conexion();
        PreparedStatement ps = null;
        Afiliaciones afiliacion = new Afiliaciones();

        ResultSet rs = null;
        try {
            Connection conexion = con.conectar();
            String sqlStm = "select * from sis_ges_proyecto2022.afiliaciones where id='" + id + "' and estado = 'activo';";
            ps = conexion.prepareStatement(sqlStm);
            rs = ps.executeQuery();            
            rs.next();
            afiliacion.setId(rs.getString("id"));
            afiliacion.setDeuda(rs.getInt("deuda"));
            afiliacion.setCuota(rs.getInt("cuota"));
            afiliacion.setUltimo(rs.getString("ultimo"));
            afiliacion.setAlta(rs.getString("alta"));
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception ex){
        ex.printStackTrace();
        }

        return afiliacion;

    }
    
    public static Afiliados buscarDeudores() {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 4 : cargar los resultados en los objetos de la capa logica si es un select la consulta
        //paso 5 : cerrar la conexion a la base

        Conexion con = new Conexion();
        PreparedStatement ps = null;
        Afiliados afiliados = new Afiliados();

        ResultSet rs = null;
        try {
            Connection conexion = con.conectar();
            String sqlStm = "select * from sis_ges_proyecto2022.afiliaciones where deuda > 0;";
            ps = conexion.prepareStatement(sqlStm);
            rs = ps.executeQuery();            

            while (rs.next()) {
                Afiliado afiliado = new Afiliado();
                afiliado = AfiliacionPersistencia.buscarAfiliado(rs.getString("id"));
                if (AfiliacionPersistencia.estadoAfiliado(rs.getString("id")).equals("activo")) {
                    afiliados.agregarUsuario(afiliado);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception ex){
        ex.printStackTrace();
        }

        return afiliados;

    }
    
    public static Afiliados buscarDeudoresN() {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 4 : cargar los resultados en los objetos de la capa logica si es un select la consulta
        //paso 5 : cerrar la conexion a la base

        Conexion con = new Conexion();
        PreparedStatement ps = null;
        Afiliados afiliados = new Afiliados();

        ResultSet rs = null;
        try {
            Connection conexion = con.conectar();
            String sqlStm = "select * from sis_ges_proyecto2022.afiliaciones where deuda > 0;";
            ps = conexion.prepareStatement(sqlStm);
            rs = ps.executeQuery();            

            while (rs.next()) {
                Afiliado afiliado = new Afiliado();
                afiliado = AfiliacionPersistencia.buscarAfiliado(rs.getString("id"));
                if (AfiliacionPersistencia.estadoAfiliado(rs.getString("id")).equals("inactivo")) {
                    afiliados.agregarUsuario(afiliado);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception ex){
        ex.printStackTrace();
        }

        return afiliados;

    }
    
    public static Afiliados buscarFechas(String desde, String hasta) {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 4 : cargar los resultados en los objetos de la capa logica si es un select la consulta
        //paso 5 : cerrar la conexion a la base

        Conexion con = new Conexion();
        PreparedStatement ps = null;
        Afiliados afiliados = new Afiliados();

        ResultSet rs = null;
        try {
            Connection conexion = con.conectar();
            String sqlStm = "select * from sis_ges_proyecto2022.afiliaciones where alta >= '"+Fecha.convertirStringAFecha(desde)+"' and alta <= '"+Fecha.convertirStringAFecha(hasta)+"' ;";
            ps = conexion.prepareStatement(sqlStm);
            rs = ps.executeQuery();            

            while (rs.next()) {
                Afiliado afiliado = new Afiliado();
                afiliado = AfiliacionPersistencia.buscarAfiliado(rs.getString("id"));
                if (AfiliacionPersistencia.estadoAfiliado(rs.getString("id")).equals("activo")) {
                    afiliados.agregarUsuario(afiliado);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception ex){
        ex.printStackTrace();
        }

        return afiliados;

    }
    
    public static Afiliados buscarFechasN(String desde, String hasta) {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 4 : cargar los resultados en los objetos de la capa logica si es un select la consulta
        //paso 5 : cerrar la conexion a la base

        Conexion con = new Conexion();
        PreparedStatement ps = null;
        Afiliados afiliados = new Afiliados();

        ResultSet rs = null;
        try {
            Connection conexion = con.conectar();
            String sqlStm = "select * from sis_ges_proyecto2022.afiliaciones where alta >= '"+Fecha.convertirStringAFecha(desde)+"' and alta <= '"+Fecha.convertirStringAFecha(hasta)+"' ;";
            ps = conexion.prepareStatement(sqlStm);
            rs = ps.executeQuery();            

            while (rs.next()) {
                Afiliado afiliado = new Afiliado();
                afiliado = AfiliacionPersistencia.buscarAfiliado(rs.getString("id"));
                if (AfiliacionPersistencia.estadoAfiliado(rs.getString("id")).equals("inactivo")) {
                    afiliados.agregarUsuario(afiliado);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception ex){
        ex.printStackTrace();
        }

        return afiliados;

    }
}
