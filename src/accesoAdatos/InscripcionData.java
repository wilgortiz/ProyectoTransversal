package accesoAdatos;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Alumno;
import modelo.Inscripcion;
import modelo.Materia;

public class InscripcionData {

    private Connection con = null;
    private MateriaData mData;
    private AlumnoData aData; //estos atributos agregue(dario)

    public InscripcionData() {
        con = Conexion.getConexion();
        mData = new MateriaData();
        aData = new AlumnoData();

    }

    public void inscribir(Inscripcion insc) {
        //inscribir al alumno
        String sql = "INSERT INTO inscripcion(nota, idAlumno, idMateria) VALUES (?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, insc.getNota());
            //esto si nosotros creamos la inscripcion y su repectivo idalumno 
            //e idmateria desde el evento de la vista
//            ps.setInt(2, 7); //buscar otra manera de setear los parametros
//            ps.setInt(3, 4);//buscar otra manera de setear los parametros

            ps.setInt(2, insc.getAlumnoI().getId_alumno());
            ps.setInt(3, insc.getMateriaI().getId_materia());
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

    public List<Inscripcion> inscripcionesPorAlumno(int id) {
        //que muestre las materias que esta inscripto el alumno, una lista.
//        String sql = "SELECT idInscripcion, nota, idAlumno, idMateria FROM materia "
//                + "JOIN inscripcion ON (materia.idMateria = inscripcion.idMateria)"
//                + " WHERE idAlumno=?";

        String sql = "SELECT inscripcion.* FROM inscripcion WHERE idAlumno=(?)"; //agregue esto (dario)

        List<Inscripcion> inscripciones = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Inscripcion materiaInsc = new Inscripcion();
                materiaInsc.setIdInscripcion(rs.getInt("idInscripcion"));
                materiaInsc.setNota(rs.getInt("nota"));
//                materiaInsc.getAlumnoI().setId_alumno(rs.getInt("idAlumno"));
//                materiaInsc.getMateriaI().setId_materia(rs.getInt("idMateria"));

                materiaInsc.setAlumnoI(aData.buscarAlumno(rs.getInt("idAlumno")));  //agregue esto, es lo mismo del profe pero sin hacer un metodo 
                materiaInsc.setMateriaI(mData.buscarMateria(rs.getInt("idMateria")));//de regeneracion, en su lugar cree los atributos alumnoData y 
                //materiaData en esta clase inicializados en el contructore de esta clase,
//                materiaInsc.set
                inscripciones.add(materiaInsc);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Inscripcion" + ex.getMessage());
        }
        return inscripciones;
    }

    public List<Materia> noInscriptas(int id) {

        String sql = "SELECT * FROM materia WHERE idMateria NOT IN (SELECT idMateria FROM inscripcion WHERE idAlumno = ?);";

        List<Materia> materias = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Materia m1 = new Materia();
                m1.setId_materia(rs.getInt("idMateria"));
                m1.setAño(rs.getInt("año"));
//                materiaInsc.getAlumnoI().setId_alumno(rs.getInt("idAlumno"));
//                materiaInsc.getMateriaI().setId_materia(rs.getInt("idMateria"));

                m1.setNombre(rs.getString("nombre"));  //agregue esto, es lo mismo del profe pero sin hacer un metodo 
                m1.setEstado(rs.getBoolean("estado"));//de regeneracion, en su lugar cree los atributos alumnoData y 
                //materiaData en esta clase inicializados en el contructore de esta clase,
//                materiaInsc.set
                materias.add(m1);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Materia" + ex.getMessage());
        }
        return materias;
    }

    public List<Inscripcion> inscripciones() {

        String sql = "SELECT inscripcion.* FROM inscripcion";

        List<Inscripcion> inscripciones = new ArrayList();
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Inscripcion materiaInsc;
            while (rs.next()) {
                materiaInsc = new Inscripcion();

                materiaInsc.setIdInscripcion(rs.getInt("idInscripcion"));
                materiaInsc.setNota(rs.getInt("nota"));
                materiaInsc.setAlumnoI(aData.buscarAlumno(rs.getInt("idMateria")));
                materiaInsc.setMateriaI(mData.buscarMateria(rs.getInt("idMateria")));

                inscripciones.add(materiaInsc);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla inscripcion");
        }
        return inscripciones;
    }

    public void borrarInscripcion(int idAlumno, int idMateria) {

        String sql = "DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria = ?";

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, " Inscipcion anulada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla inscripcion");
        }

    }

    public void modificarNota(int id, int nota) {

        String sql = "UPDATE `inscripcion` SET `nota` = ? WHERE `inscripcion`.`idInscripcion` = ?;";

        PreparedStatement ps;
        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, nota);
            ps.setInt(2, id);
            int fila = ps.executeUpdate();
            ps.close();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, " nota modificada");
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Inscripcion" + ex.getMessage());
        }

    }

    public List<Alumno> alumnosPorMateria(int idMateria) {
        List<Alumno> listaAlumnos = new ArrayList<>();
        String sql = "SELECT alumno.* FROM alumno JOIN inscripcion on (alumno.idAlumno = inscripcion.idAlumno) JOIN materia on (materia.idMateria = inscripcion.idMateria) WHERE materia.idMateria = ?;";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();

            

            while (rs.next()) {
                Alumno a1 = new Alumno();
                a1.setNombre(rs.getString("nombre"));
                a1.setApellido(rs.getString("apellido"));
                a1.setDni(rs.getString("dni"));
                
                listaAlumnos.add(a1);

            }
            ps.close();
        } catch (SQLException ex) {
           
        }
      return listaAlumnos;
    }
}
