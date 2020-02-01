/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa1.parcial1.aplicacion.objetos;

/**
 *
 * @author uth
 */
public class Alumno {
    private String cuenta;
    private String nombre;
    private int anioNacimiento;

    public Alumno(String cuenta, String nombre, int anioNacimiento) {
        this.cuenta = cuenta;
        this.nombre = nombre;
        this.anioNacimiento = anioNacimiento;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(int anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    @Override
    public String toString() {
        return "Alumno{" + "cuenta=" + cuenta + ", nombre=" + nombre + ", anioNacimiento=" + anioNacimiento + '}';
    }
    
}
