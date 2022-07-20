/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sis_ges_proyecto2022.logica;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import sis_ges_proyecto2022.excepciones.FechaException;

/**
 *
 * @author mauri
 */
public class Fecha {
    
    public Date convertirStringAFecha(String fechaString)throws FechaException {
        Date fechaDate = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
       
        try {
            fechaDate = formateador.parse(fechaString);
            fechaDate.hashCode();
           
        } catch (ParseException e) {
       
            throw new FechaException();
        }
       
        return fechaDate;

    }
}
