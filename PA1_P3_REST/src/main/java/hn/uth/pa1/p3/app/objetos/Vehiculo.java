/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa1.p3.app.objetos;

/**
 *
 * @author pccinho
 */
public class Vehiculo {

    private String placa;
    private String marca;
    private String modelo;
    private int id_duenio;

    public Vehiculo(String placa, String marca, String modelo, int id_duenio) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.id_duenio = id_duenio;
    }

    public Vehiculo() {
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getId_duenio() {
        return id_duenio;
    }

    public void setId_duenio(int id_duenio) {
        this.id_duenio = id_duenio;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", id_duenio=" + id_duenio + '}';
    }

}
