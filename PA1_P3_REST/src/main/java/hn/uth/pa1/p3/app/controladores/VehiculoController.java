/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa1.p3.app.controladores;

import hn.uth.pa1.p3.app.objetos.Vehiculo;
import hn.uth.pa1.p3.app.repositorios.VehiculoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pccinho
 */
@RestController
@RequestMapping(path = "/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoRepositorio repositorio;

    @GetMapping("/")
    public Object buscar() throws Exception {
        return repositorio.buscarTodo();
    }

    @GetMapping("/{placa}")
    public Object buscar(@PathVariable("placa") String placa) throws Exception {
        return repositorio.buscar(placa);
    }

    @PostMapping("/guardar")
    public Object guardar(@RequestBody Vehiculo vehiculo) throws Exception {
        repositorio.crear(vehiculo);
        return "Almacenado";
    }

    @PostMapping("/actualizar")
    public Object actualizar(@RequestBody Vehiculo vehiculo) throws Exception {
        repositorio.actualizar(vehiculo);
        return "Actualizado";
    }

    @PostMapping("/eliminar")
    public Object eliminar(@RequestBody Vehiculo vehiculo) throws Exception {
        repositorio.eliminar(vehiculo);
        return "Eliminado";
    }
}
