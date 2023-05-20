/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;



/**
 *
 * @author wilgortiz
 */
public class Alumno {
    
    private int id_alumno;
     private String dni;
      private String apellido;
      private String nombre;
     private LocalDate fechaNacimiento;
    private boolean estado;
      
      //CONSTRUCTORES VACÍOS, LLENO Y SIN EL ID

    public Alumno() {
    }

    public Alumno(int id_alumno, String dni, String apellido, String nombre, LocalDate fechaNacimiento, boolean estado) {
        this.id_alumno = id_alumno;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
    }

    public Alumno(String dni, String apellido, String nombre, LocalDate fechaNacimiento, boolean estado) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
    }
      
     
}
