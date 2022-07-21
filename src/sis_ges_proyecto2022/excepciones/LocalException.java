/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sis_ges_proyecto2022.excepciones;

/**
 *
 * @author mauri
 */
public class LocalException extends Exception {

    /**
     * Creates a new instance of <code>UsuarioException</code> without detail
     * message.
     */
    public LocalException() {
    }

    /**
     * Constructs an instance of <code>UsuarioException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public LocalException(String msg) {
        super(msg);
    }
    
}
