/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa1.parcial2.app;

import hn.uth.pa1.parcial2.app.objetos.Vehiculo;
import hn.uth.pa1.parcial2.app.repositorios.VehiculoRepositorio;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alumno
 */
public class FrmHumanosController {
    static VehiculoRepositorio vr=new VehiculoRepositorio();
    
    static String[] columnasTablaHumanos=new String [] {
                    "Placa", "Marca", "Modelo", "Dueño"
                };
    
    public static DefaultTableModel getTblHumanos() throws Exception{
        List<Vehiculo> listaVehiculosBD = vr.buscarTodo();
        
        DefaultTableModel defaultTableModel = new DefaultTableModel(
                convertirLista(listaVehiculosBD),
                columnasTablaHumanos
        );
        
        return defaultTableModel;
    }
    
    public static Object [][] convertirLista(List<Vehiculo> lista){
        int tamanioLista=lista.size();
        int numeroColumnas=columnasTablaHumanos.length;
        
        Object [][] tablaRetorno=new Object[tamanioLista][numeroColumnas];
        
        for (int i = 0; i < tamanioLista; i++) {
            tablaRetorno[i][0]=lista.get(i).getPlaca();
            tablaRetorno[i][1]=lista.get(i).getMarca();
            tablaRetorno[i][2]=lista.get(i).getModelo();
            tablaRetorno[i][3]=lista.get(i).getId_duenio();            
        }
        return tablaRetorno;
    }
}
