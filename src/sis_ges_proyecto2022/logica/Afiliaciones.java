/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sis_ges_proyecto2022.logica;

/**
 *
 * @author mauri
 */
public class Afiliaciones {
    
    private String id;
    private int deuda;
    private int cuota;
    private String fecha_ult_pago;
    private String fecha_alta;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDeuda() {
        return deuda;
    }

    public void setDeuda(int deuda) {
        this.deuda = deuda;
    }

    public int getCuota() {
        return cuota;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }

    public String getFecha_ult_pago() {
        return fecha_ult_pago;
    }

    public void setFecha_ult_pago(String fecha_ult_pago) {
        this.fecha_ult_pago = fecha_ult_pago;
    }

    public String getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(String fecha_alta) {
        this.fecha_alta = fecha_alta;
    }
    
    
    
    
}
