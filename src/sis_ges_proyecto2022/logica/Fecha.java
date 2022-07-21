/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sis_ges_proyecto2022.logica;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import sis_ges_proyecto2022.excepciones.FechaException;

/**
 *
 * @author mauri
 */
public class Fecha {
    
    public static java.sql.Date convertirStringAFecha(String fechaString)throws FechaException {
        java.util.Date fechaDate = new java.util.Date();
        
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date fechaSql = null;
       
        try {
            fechaDate = formateador.parse(fechaString);
            fechaSql = new java.sql.Date(fechaDate.getTime());
           
        } catch (ParseException e) {
       
            throw new FechaException();
        }
       
        return fechaSql;

    }
}
