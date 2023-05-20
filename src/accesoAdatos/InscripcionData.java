
package accesoAdatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Inscripcion;


public class InscripcionData {
    
    private Connection con = null;

    public InscripcionData() {
        con = Conexion.getConexion();
    }
    
    
    public void inscribir(Inscripcion insc){
        
        String sql = "INSERT INTO inscripcion(nota, idAlumno, idMateria) VALUES (?,?,?)";
        
        

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, insc.getNota());
            //esto si nosotros creamos la inscripcion y su repectivo idalumno e idmateria desde el evento de la vista
            ps.setInt(2, insc.getAlumnoI().getIdAlumno());
            ps.setInt(3, insc.getMateriaI().getIdMateria());
            
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                insc.setIdInscripcion(rs.getInt("idInscripcion"));
                JOptionPane.showMessageDialog(null, "Inscripcion completada.");
            }
            
            ps.close();

        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1062) {
                JOptionPane.showMessageDialog(null, "Ya se encuentra inscripto.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de inscripciones." + ex.getMessage());
            }
        }
    }
    
   public List<Inscripcion> materiasInscripto(Alumno alumno){

 String sql = "SELECT idInscripcion, nota, idAlumno, idMateria * FROM materia join inscripcion on(materia.idMateria=inscripcion.idMateria) WHERE idAlumno=?";
           
        List<Inscripcion> inscripciones = new ArrayList();
        try {
                
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion materiaInsc = new Inscripcion();

                materiaInsc.setIdInscripcion(rs.getInt("idInscripcion"));
               materiaInsc.setNota(rs.getInt("nota"));
               materiaInsc.getAlumnoI().setIdAlumno(rs.getInt("idAlumno"));
               materiaInsc.getMateriaI().setIdMateria(rs.getInt("idMateria"));
              

                inscripciones.add(materiaInsc);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno");
        }
        return inscripciones;
    }
    
}
