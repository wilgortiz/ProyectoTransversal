/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo12;

import accesoAdatos.MateriaData;
import modelo.Materia;


/**
 *
 * @author wilgortiz
 */
public class Universidadgrupo12 {

    public static void main(String[] args) {

        MateriaData md = new MateriaData();
        Materia m1 = new Materia("Algebra", 3, true);
        
        
        System.out.println(md.buscarMateria(3).toString());  
     //   md.guardarMateria(m1);
     
     md.modificarEstado(2); //modificando el estado, funciona
     
     
     
        
        
        
        /*  try {
          Class.forName("org.mariadb.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/universidadulp", "root", "");

            //insertamos un alumno a la base de datos
            String sql = "INSERT INTO alumno(nombre,apellido,dni,fecha_nacimiento) VALUES ('Ricardo','Arjona',22222220,1964-01-19)";
            PreparedStatement ps = con.prepareStatement(sql);
            int resultado = ps.executeUpdate();

            if (resultado > 0) {

                JOptionPane.showMessageDialog(null, "agregado");
            } else {
                JOptionPane.showMessageDialog(null, "error al agregar alumno");

            }

          
          String sql2= "SELECT idAlumno, dni, apellido,nombre,fechaNacimiento, estado From alumno WHERE "
        } catch (ClassNotFoundException ex) {

            JOptionPane.showMessageDialog(null, "Error al cargar los Drivers");
        } catch (SQLException ex) {

            System.out.println(ex.getErrorCode());

            if (ex.getErrorCode() == 1062) {

                JOptionPane.showMessageDialog(null, "error, dni duplicado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al conectarse a la BD");

            }
        }
    }
}*/
    }
}