/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sis_ges_proyecto2022.logica;

import java.util.ArrayList;

/**
 *
 * @author mauri
 */
public class Afiliados {
    
    ArrayList<Afiliado> afiliados = new ArrayList();

    public ArrayList<Afiliado> getAfiliados() {
        return afiliados;
    }

    public void setAfiliados(ArrayList<Afiliado> afiliados) {
        this.afiliados = afiliados;
    }
    
    public void agregarUsuario(Afiliado afiliado) {
        this.afiliados.add(afiliado); 
    }
}
