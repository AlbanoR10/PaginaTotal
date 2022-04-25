package com.example.demo.controller;

import com.example.demo.clases.Clientes;
import com.example.demo.clases.Cotizacion;
import com.example.demo.clases.Usuario;
import com.example.demo.model.ClientesModelo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

/**
* Clase ClientesControlador que es el controlador de la clase cliente
**/
@Component
public class ClientesControlador {
    
    @Autowired
    ClientesModelo clientesModelo;
    
    /**
    * Método para guardar cliente
    * @param cliente objeto de la cliente
    **/
    public void guardar(@RequestBody Clientes cliente) {
        clientesModelo.guardar(cliente);
    }

    /**
    * Método para listar clientes
    **/
    public List<Clientes> listar() {
        return clientesModelo.listar();
    }
    
    /**
    * Método para listar clientes por id
    * @param clientes objeto de la cliente
    **/
    public Clientes listarClientesPorId(@RequestBody Clientes clientes){
        return clientesModelo.listarClientesPorId(clientes);
    }

    /**
    * Método para listar clientes por usuario
    * @param usuario objeto de la usuario
    **/
    public List<Clientes> listarClientesPorUsuario(@RequestBody Usuario usuario) {
        return (List<Clientes>) clientesModelo.listarClientesPorUsuario(usuario);
    }

    /**
    * Método para eliminar cliente
    * @param cliente objeto de la cliente
    **/
    public void eliminar(Clientes clientes){
        System.out.println("Apunto de eliminar");
        clientesModelo.eliminar(clientes);
    }
}
