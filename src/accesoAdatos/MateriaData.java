/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoAdatos;

import AccesoADatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Materia;

/**
 *
 * @author wilgortiz
 */
public class MateriaData {

    private Connection con = null;
//        con = Conexion.getConexion();

    public MateriaData() {

        con = Conexion.getConexion();
    }

    public void guardarMateria(Materia m1) {
        String sql = "INSERT INTO materia( nombre, año, estado) VALUES (?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, m1.getNombre());
            ps.setInt(2, m1.getAño());
            ps.setBoolean(3, m1.isEstado());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                m1.setNombre(rs.getString(1));
                JOptionPane.showMessageDialog(null, "Materia añadida con exito.");
            } else {
                JOptionPane.showMessageDialog(null, "La Materia no fue añadida.");
            }

            ps.close();

        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1062) {
                JOptionPane.showMessageDialog(null, "ya existe ");
            } else {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia" + ex.getErrorCode());
            }

        }
    }

    public Materia buscarMateria(int id) {

        Materia materia = new Materia();

        String sql = "SELECT nombre, año, estado FROM materia WHERE idMateria=? AND estado = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                materia.setId_materia(id);
//                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                materia.setEstado(rs.getBoolean("estado"));
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
        }

        return materia;
    }

    public void modificarEstado(int id) {

        String sql = "UPDATE `materia`  SET estado=0 WHERE idMateria=?";

        PreparedStatement ps;
        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();
            ps.close();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, " estado modificado");
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Materia");
        }

    }
    // return ;
    public void modificar(Materia datos){
    
        String sql=  "UPDATE `materia` SET `idMateria`='?'"
                + ", `nombre`='?',`año`='?',`estado`='?' WHERE 1";
        
        
    }
}
