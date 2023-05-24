/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo12;

import accesoAdatos.AlumnoData;
import accesoAdatos.InscripcionData;
import accesoAdatos.MateriaData;
import java.time.LocalDate;
import modelo.Alumno;
import modelo.Inscripcion;
import modelo.Materia;

/**
 *
 * @author wilgortiz
 */
public class Universidadgrupo12 {

    public static void main(String[] args) {

        //instancia de alumno y alumnodata
        Alumno al = new Alumno(7, "30258697", "koka", "martin", LocalDate.parse("1986-12-05"), true);
        AlumnoData alD = new AlumnoData();
        alD.guardarAlumno(al);
        //instancia de materia y materiadata
        MateriaData md = new MateriaData();
        Materia m1 = new Materia(4, "LENGUA", 3, true);
        md.guardarMateria(m1);
      
        Materia m2 = new Materia(6, "Algebra", 1, false);
        md.guardarMateria(m2);
       
        System.out.println(md.buscarMateria(3).toString());

        //modificar estado
        md.modificarEstado(2); 
        
        //instancia de Inscripcion e InscripcionData
        Inscripcion ins = new Inscripcion(9, al, m1);
        InscripcionData insD = new InscripcionData();
        insD.inscribir(ins);

        System.out.println("busca");
        System.out.println(md.buscarMateria(3).toString());
        System.out.println("modifica");
        System.out.println(md.modificarMateria(m2));
        System.out.println("lista de materias");
        System.out.println(md.listarMaterias().toString());

        
        System.out.println("lista de inscriptos");
        System.out.println(insD.materiasInscripto(al).toString());
        //insD.materiasInscripto(al).toString();
    }
}
