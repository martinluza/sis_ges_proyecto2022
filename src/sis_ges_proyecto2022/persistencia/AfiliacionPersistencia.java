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
import sis_ges_proyecto2022.logica.Afiliado;
import sis_ges_proyecto2022.excepciones.AfiliacionException;
import sis_ges_proyecto2022.logica.Fecha;
/**
 *
 * @author 006588869
 */
public class AfiliacionPersistencia {
    
    private static final String PS_SELECT_AFILIADO = "SELECT * FROM afiliados where documento = ?";
    private static final String PS_UPDATE_AFILIADO = "UPDATE sis_ges_proyecto2022.afiliados SET estado = '?' WHERE (documento = '?')";
    private static final String PS_INSERT_AFILIADO = "INSERT INTO sis_ges_proyecto2022.afiliados (documento, nombre, apellido, nacionalidad, direccion, telefono, mail, nacimiento, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String PS_SELECT_LISTA_AFILIADOS = "SELECT * FROM afiliados where estado='activo'";
    
    
    
     public static void ingresarUsuario(Afiliado afiliado) throws AfiliacionException {

        PreparedStatement ps = null;

        Conexion conexion = new Conexion();
        Connection con = null;
        try {
            con = conexion.conectar();
            ps = con.prepareStatement(PS_INSERT_AFILIADO);
            ps.setString(1, afiliado.getDocumento() );
            ps.setString(2, afiliado.getNombre() );
            ps.setString(3, afiliado.getApellido());
            ps.setString(4, afiliado.getNacionalidad());
            ps.setString(5, afiliado.getDireccion());
            ps.setInt(6, afiliado.getTelefono());
            ps.setString(7, afiliado.getMail());
            ps.setDate(8, fecha.convertirStringAFecha(afiliado.getNacimiento()));
            ps.setString(9, "activo");

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new AfiliacionException("No pude insertar el usuario");
        } finally {

        }

    }
    
}
