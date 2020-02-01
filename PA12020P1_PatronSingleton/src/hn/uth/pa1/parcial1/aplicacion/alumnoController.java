/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa1.parcial1.aplicacion;

import hn.uth.pa1.parcial1.aplicacion.objetos.Alumno;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author uth
 */
public class alumnoController {
    private static Alumno alumnoActual;
    private static List<Alumno> listaAlumnos
            = new ArrayList<>();
    
    public static void agregarAlumnoLista(Alumno alumno){
        listaAlumnos.add(alumno);
    }
    
    public static Object[][] getListaAlumnosComoArreglo(){
        Object arreglo[][]=new Object[listaAlumnos.size()][3];
        
        int indice=0;
        for (Alumno alumnoTmp : listaAlumnos) {
            arreglo[indice][0]=alumnoTmp.getCuenta();
            arreglo[indice][1]=alumnoTmp.getNombre();
            arreglo[indice][2]=alumnoTmp.getAnioNacimiento();
            indice++;
        }
        
        return  arreglo;
    }
    
    public static void configurarAlumnoActual(Alumno alumno){
        alumnoActual=alumno;
    }
    
    public static Alumno getAlumnoActual(){
        return alumnoActual;
    }
    
}
