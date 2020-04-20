/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa1.p3.app.repositorios;

import hn.uth.pa1.p3.app.objetos.Vehiculo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Alumno
 */
@Component
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

            PreparedStatement ps = cnx.prepareStatement(sql);
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
    public void eliminar(Vehiculo t) throws Exception {

        try {
            //Traer la conexion o la session
            Connection cnx = getConnection();

            String sql = "DELETE FROM VEHICULOS "
                    + "WHERE PLACA=?";

            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setString(1, t.getPlaca());

            //ejecuta la sentencia
            ps.execute();

            //IMPORTANTE:  cerrar sesiones
            ps.close();
            cnx.close();
        } catch (Exception e) {
            throw new Exception("Error al eliminar: " + e.toString());
        }
    }

    @Override
    public void actualizar(Vehiculo t) throws Exception {

        try {
            //Traer la conexion o la session
            Connection cnx = getConnection();

            String sql = "UPDATE VEHICULOS "
                    + "SET MARCA=?,MODELO=?, ID_DUENIO=?  "
                    + "WHERE PLACA=?";

            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setString(4, t.getPlaca());
            ps.setString(1, t.getMarca());
            ps.setString(2, t.getModelo());
            ps.setInt(3, t.getId_duenio());

            //ejecuta la sentencia
            ps.execute();

            //IMPORTANTE:  cerrar sesiones
            ps.close();
            cnx.close();
        } catch (Exception e) {
            throw new Exception("Error al actualizar: " + e.toString());
        }
    }

    @Override
    public Vehiculo buscar(Object id) throws Exception {
        Vehiculo valorRetorno = new Vehiculo();
        try {
            //Traer la conexion o la session
            Connection cnx = getConnection();

            String sql = "select * from VEHICULOS where  placa = '"+id+"' ";

            Statement st = cnx.createStatement();

            //ejecuta la sentencia
            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                String placa = resultado.getString("PLACA");
                String marca= resultado.getString("MARCA");
                String modelo= resultado.getString("MODELO");
                int id_duenio= resultado.getInt("ID_DUENIO");
                                
                valorRetorno.setPlaca(placa);
                valorRetorno.setMarca(marca);
                valorRetorno.setModelo(modelo);
                valorRetorno.setId_duenio(id_duenio);                
            }

            //IMPORTANTE:  cerrar sesiones
            st.close();
            cnx.close();
                        
        } catch (Exception e) {
            throw new Exception("Error al buscar todos: " + e.toString());
        }
        return valorRetorno;
    }

    @Override
    public List<Vehiculo> buscarTodo()throws Exception {
         List<Vehiculo> listaRetorno=new ArrayList<>();
        try {
            //Traer la conexion o la session
            Connection cnx = getConnection();

            String sql = "select * from VEHICULOS ";

            Statement st = cnx.createStatement();

            //ejecuta la sentencia
            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                String placa = resultado.getString("PLACA");
                String marca= resultado.getString("MARCA");
                String modelo= resultado.getString("MODELO");
                int id_duenio= resultado.getInt("ID_DUENIO");
                
                Vehiculo v = new Vehiculo();
                v.setPlaca(placa);
                v.setMarca(marca);
                v.setModelo(modelo);
                v.setId_duenio(id_duenio);
                
                listaRetorno.add(v);
            }

            //IMPORTANTE:  cerrar sesiones
            st.close();
            cnx.close();
        } catch (Exception e) {
            throw new Exception("Error al buscar todos: " + e.toString());
        }
        return listaRetorno;
    }
}
