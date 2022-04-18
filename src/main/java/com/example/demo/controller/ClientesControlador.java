package com.example.demo.controller;

import com.example.demo.clases.Clientes;
import com.example.demo.clases.Cotizacion;
import com.example.demo.clases.Usuario;
import com.example.demo.model.ClientesModelo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class ClientesControlador {
    
    @Autowired
    ClientesModelo clientesModelo;
    
    public void guardar(@RequestBody Clientes cliente) {
        clientesModelo.guardar(cliente);
    }
    
    public List<Clientes> listar() {
        return clientesModelo.listar();
    }
    
    public Clientes listarClientesPorId(@RequestBody Clientes clientes){
        return clientesModelo.listarClientesPorId(clientes);
    }
    
    public List<Clientes> listarClientesPorUsuario(@RequestBody Usuario usuario) {
        return (List<Clientes>) clientesModelo.listarClientesPorUsuario(usuario);
    }
}
