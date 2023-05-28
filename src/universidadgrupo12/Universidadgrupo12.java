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
        //PRUEBA DE ALUMNO
        System.out.println("PRUEBA DE ALUMNO:");
        Alumno al = new Alumno(1, "21589754", "pascual", "darius", LocalDate.parse("1980-12-12"), true);
        AlumnoData alD = new AlumnoData();
        alD.guardarAlumno(al);
        System.out.println("Alumno creado y guardado con exito en BD");
        System.out.println("Buscar Alumno id=1:");
        System.out.println(alD.buscarAlumno(1).toString());

        //PRUEBA DE MATERIA
        System.out.println("PRUEBA DE MATERIA:");
        MateriaData md = new MateriaData();
        Materia m1 = new Materia(1, "Algebra", 1, true);
        md.guardarMateria(m1);
        Materia m2 = new Materia(1, "Ingles", 2, true);
        System.out.println("Materias creadas y guardadas con exito en BD");
        System.out.println("Buscar materia id=1:");
        System.out.println(md.buscarMateria(1).toString());
        System.out.println("Modificar materia " + m1.getNombre() + ":");
        System.out.println("ahora es: " + md.modificarMateria(m2).toString());
        System.out.println("Listar materias:" + md.listarMaterias().toString());

        //PRUEBA INSCRIPCION
        System.out.println("PRUEBA INSCRIPCION:");
        Inscripcion ins = new Inscripcion(1,9, al, m1);
        InscripcionData insD = new InscripcionData();
        insD.inscribir(ins);
        System.out.println("Inscripcion completada");
        System.out.println("Inscripcion de alumno id=1:");
        System.out.println(insD.inscripcionesPorAlumno(1).toString());
        System.out.println("Todas las inscripciones:");
        System.out.println(insD.inscripciones().toString());
        System.out.println("Eliminar inscripcion id=1:");
        insD.borrarInscripcion(1,1);
        System.out.println("Inscripcion borrada");
//     
    }
}
