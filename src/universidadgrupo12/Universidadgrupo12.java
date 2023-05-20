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

        //PRUEBA DE MATERIADATA
        Materia m2 = new Materia(6, "Algebra", 1, false);
        md.guardarMateria(m1);

        System.out.println(md.buscarMateria(3).toString());

        System.out.println(md.modificarMateria(m2));

        System.out.println(md.listarMaterias().toString());

    }
}
