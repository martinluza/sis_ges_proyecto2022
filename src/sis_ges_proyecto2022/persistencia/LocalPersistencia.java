/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sis_ges_proyecto2022.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sis_ges_proyecto2022.excepciones.LocalException;
import sis_ges_proyecto2022.logica.Local;

/**
 *
 * @author mauri
 */
public class LocalPersistencia {
    private static final String PS_SELECT_LOCAL = "SELECT * FROM locales where ID = ?";
    private static final String PS_UPDATE_LOCAL = "UPDATE sis_ges_proyecto2022.loclaes SET estado = '?' WHERE (ID = '?')";
    private static final String PS_INSERT_LOCAL = "INSERT INTO sis_ges_proyecto2022.afiliados (ID, direccion, numero_de_local, negocio, encargado, estado) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String PS_SELECT_LISTA_LOCALES = "SELECT * FROM afiliados where estado='activo'";
    
     public static void ingresarAfiliado(Local local) throws LocalException, SQLException {

        PreparedStatement ps = null;

        Conexion conexion = new Conexion();
        Connection con = null;
        try {
            con = conexion.conectar();
            ps = con.prepareStatement(PS_INSERT_LOCAL);
            ps.setString(1, local.getId() );
            ps.setString(2, local.getDireccion() );
            ps.setString(3, local.getNumero_de_local());
            ps.setString(4, local.getNegocio());
            ps.setString(5, local.getEncargado());
            ps.setString(6, "activo");

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new LocalException("No pude insertar el usuario");
        } finally {

        }

    }
    
}
