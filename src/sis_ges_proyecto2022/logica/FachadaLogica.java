/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sis_ges_proyecto2022.logica;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sis_ges_proyecto2022.excepciones.AfiliacionException;
import sis_ges_proyecto2022.excepciones.AfiliacionesException;
import sis_ges_proyecto2022.excepciones.LocalException;
import sis_ges_proyecto2022.excepciones.UsuarioException;
import sis_ges_proyecto2022.persistencia.AfiliacionPersistencia;
import sis_ges_proyecto2022.persistencia.AfiliacionesPersistencia;
import sis_ges_proyecto2022.persistencia.LocalPersistencia;
import sis_ges_proyecto2022.persistencia.UsuarioPersistencia;

/**
 *
 * @author 006588869
 */
public class FachadaLogica {

    public static Boolean existeUsuario(Usuario usuario) throws UsuarioException{

        Boolean existe = false;
        existe = UsuarioPersistencia.existeUsuario(usuario);
        return existe;
    }
    
    public static DobleBooleano existeUsuario1(Usuario usuario) throws UsuarioException{
        
        DobleBooleano dobleB = new DobleBooleano();
        dobleB.setPrimerBit(false);
        dobleB.setSegundoBit(false);
        dobleB = UsuarioPersistencia.existeUsuario1(usuario);
        return dobleB;
    }
    
    public static DobleBooleano existeUsuario2(Usuario usuario) throws UsuarioException{
        
        DobleBooleano dobleB = new DobleBooleano();
        dobleB.setPrimerBit(false);
        dobleB.setSegundoBit(false);
        dobleB = UsuarioPersistencia.existeUsuario2(usuario);
        return dobleB;
    }

    public static void ingresarUsuario(Usuario usuario) throws UsuarioException{

        UsuarioPersistencia.ingresarUsuario(usuario);
    }
    
    public static void bajaUsuario(Usuario usuario) throws UsuarioException{

        UsuarioPersistencia.bajaUsuario(usuario);
    }
    
    public static void altaUsuario(Usuario usuario) throws UsuarioException{

        UsuarioPersistencia.altaUsuario(usuario);
    }
    
    public static Boolean existeAfiliado(Afiliado afiliado) throws AfiliacionException{

        Boolean existe = false;
        existe = AfiliacionPersistencia.existeAfiliado(afiliado);
        return existe;
    }
    
    public static String estadoAfiliado(String documento) throws AfiliacionException{

        String estado = AfiliacionPersistencia.estadoAfiliado(documento);
        return estado;
    }
    
    public static void ingresarAfiliado(Afiliado afiliado) throws AfiliacionException{

        AfiliacionPersistencia.ingresarAfiliado(afiliado);
    }
    
    public static Afiliados listaAfiliados(){
        Afiliados afiliados = new Afiliados();
        try {
            afiliados = AfiliacionPersistencia.listaAfiliados();
        } catch (AfiliacionException ex) {
            Logger.getLogger(FachadaLogica.class.getName()).log(Level.SEVERE, null, ex);
        }
        return afiliados;
    }
    
    public static Afiliados listaAfiliadosN(){
        Afiliados afiliados = new Afiliados();
        try {
            afiliados = AfiliacionPersistencia.listaAfiliadosN();
        } catch (AfiliacionException ex) {
            Logger.getLogger(FachadaLogica.class.getName()).log(Level.SEVERE, null, ex);
        }
        return afiliados;
    }
    
    public static Afiliado buscarAfiliado(String documento){
        Afiliado afiliado = AfiliacionPersistencia.buscarAfiliado(documento);
        return afiliado;
    }
    
    public static void modificarAfiliado(Afiliado afiliado) throws AfiliacionException{
        AfiliacionPersistencia.modificarAfiliado(afiliado);
    }
    
    public static Locales listaLocales(String documento) throws LocalException {
        Locales locales = LocalPersistencia.listaLocalesRestringida(documento);
        return locales;
    }
    
    public static Local buscarLocal(String id) throws LocalException {
        Local local = LocalPersistencia.buscarLocal(id);
        return local;
    }
    
    public static void bajaAfiliado(String documento) throws AfiliacionException {
        AfiliacionPersistencia.bajaAfiliado(documento);
    }
    
    public static void altaAfiliado(String documento) throws AfiliacionException {
        AfiliacionPersistencia.altaAfiliado(documento);
    }
    
    public static void ingresarLocal(Local local) throws LocalException, SQLException {
        LocalPersistencia.ingresarLocal(local);
    }
    
    public static Boolean existeLocal(String id) throws LocalException {
        Boolean resultado = false;
        LocalPersistencia.existeLocal(id);
        return resultado;
    }
<<<<<<< Updated upstream
=======
    
    public static void modificarLocal(Local local) throws LocalException, SQLException {
        LocalPersistencia.modificarLocal(local);
    }
    
    public static void bajaLocal(String id) throws LocalException, SQLException {
        LocalPersistencia.bajaLocal(id);
    }
    
    public static void altaLocal(String id) throws LocalException, SQLException {
        LocalPersistencia.altaLocal(id);
    }
    
    public static void ingresarAfiliacion(Afiliaciones afiliacion) throws AfiliacionesException, SQLException {
        AfiliacionesPersistencia.ingresarAfiliacion(afiliacion);
    }
>>>>>>> Stashed changes
}
