/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author 54266
 */
public class Inscripcion {
    private int idInscripcion;
    private int nota;
    
    //Consultar o averiguar como seria la relacion de esta clase con el idAlumno e idMateria
    private Alumno alumnoI;
    private Materia materiaI;

    public Inscripcion() {
    }
    
    

    public Inscripcion(int idInscripcion, int nota, Alumno alumnoI, Materia materiaI) {
        this.idInscripcion = idInscripcion;
        this.nota = nota;
        this.alumnoI = alumnoI;
        this.materiaI = materiaI;
    }

    public Inscripcion(int nota, Alumno alumnoI, Materia materiaI) {
        this.nota = nota;
        this.alumnoI = alumnoI;
        this.materiaI = materiaI;
    }
    
    

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Alumno getAlumnoI() {
        return alumnoI;
    }

    public void setAlumnoI(Alumno alumnoI) {
        this.alumnoI = alumnoI;
    }

    public Materia getMateriaI() {
        return materiaI;
    }

    public void setMateriaI(Materia materiaI) {
        this.materiaI = materiaI;
    }
    
    
    
    
}
