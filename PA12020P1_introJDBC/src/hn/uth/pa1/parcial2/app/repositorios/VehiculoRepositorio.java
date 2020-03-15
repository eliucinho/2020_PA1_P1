/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa1.parcial2.app.repositorios;

import hn.uth.pa1.parcial2.app.objetos.Vehiculo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class VehiculoRepositorio implements Repositorio<Vehiculo> {

    public Connection getConnection() throws Exception {
        try {
            String lib = "jdbc";
            String base = "derby";
            String servidor = "localhost";
            String puerto = "1527";
            String nombreBase = "uth";

            //String cadenaConexion="jdbc:derby://localhost:1527/uth";
            String cadenaConexion = String.format("%s:%s://%s:%s/%s", lib, base, servidor, puerto, nombreBase
            );
            String usuario = "uth";
            String contrasenia = "uth";

            return DriverManager.getConnection(cadenaConexion, usuario, contrasenia);
        } catch (Exception e) {
            throw new Exception("No se pudo establecer la conexión: " + e.toString());
        }
    }

    @Override
    public void crear(Vehiculo t) throws Exception {
        try {
            //Traer la conexion o la session
            Connection cnx = getConnection();

            String sql = "INSERT INTO VEHICULOS(PLACA, MARCA,MODELO,ID_DUENIO) "
                    + " VALUES "
                    + "(?,?,?,?) ";
            
            PreparedStatement ps=cnx.prepareStatement(sql);
            ps.setString(1, t.getPlaca());
            ps.setString(2, t.getMarca());
            ps.setString(3, t.getModelo());
            ps.setInt(4, t.getId_duenio());
            
            //ejecuta la sentencia
            ps.execute();
            
            //IMPORTANTE:  cerrar sesiones
            ps.close();
            cnx.close();
        } catch (Exception e) {
            throw new Exception("Error al insertar: " + e.toString());
        }
    }

    @Override
    public void eliminar(Vehiculo t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Vehiculo t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vehiculo buscar(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vehiculo> buscarTodo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
