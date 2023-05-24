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

//        //instancia de alumno y alumnodata

        Alumno al = new Alumno("21589754", "pascual", "darius", LocalDate.parse("1980-12-12"), true);
        AlumnoData alD = new AlumnoData();
        alD.guardarAlumno(al);
        //instancia de materia y materiadata
        MateriaData md = new MateriaData();
        Materia m1 = new Materia("Algebra", 3, true);

        //   md.guardarMateria(m1);
        System.out.println(md.buscarMateria(3).toString());
        
        md.modificarEstado(2); //modificando el estado, funciona

        //PRUEBA DE MATERIADATA
        Materia m2 = new Materia(6, "Algebra", 1, false);
        md.guardarMateria(m1);

//        instancia de Inscripcion e InscripcionData
        Inscripcion ins = new Inscripcion(9, al, m2);
        InscripcionData insD = new InscripcionData();
        insD.inscribir(ins);
        
        
        System.out.println(md.buscarMateria(3).toString());
        
        System.out.println(md.modificarMateria(m2));
        
        System.out.println(md.listarMaterias().toString());

        //prueba inscripcion data
        System.out.println();
    }
}
