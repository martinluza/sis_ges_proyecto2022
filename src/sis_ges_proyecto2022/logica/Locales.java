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
public class Locales {
    ArrayList<Local> locales = new ArrayList();

    public ArrayList<Local> getLocales() {
        return locales;
    }

    public void setLocales(ArrayList<Local> locales) {
        this.locales = locales;
    }
    
    public void agregarLocal(Local local) {
        this.locales.add(local); 
    }
    
}
