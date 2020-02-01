/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa1.parcial1.aplicacion;

import hn.uth.pa1.parcial1.aplicacion.objetos.Alumno;

/**
 *
 * @author uth
 */
public class alumnoController {
    private static Alumno alumnoActual;
    
    public static void configurarAlumnoActual(Alumno alumno){
        alumnoActual=alumno;
    }
    
    public static Alumno getAlumnoActual(){
        return alumnoActual;
    }
    
}
