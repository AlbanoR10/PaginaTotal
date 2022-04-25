package com.example.demo.model;

import com.example.demo.clases.Clientes;
import com.example.demo.clases.Cotizacion;
import com.example.demo.clases.Usuario;
import com.example.demo.dao.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.dao.ClientesDao;
import java.util.List;

/**
* Clase ClientesModelo que es el modelo de la clase cliente
**/
@Component
public class ClientesModelo {
    @Autowired
    UsuarioDao usuarioDao;
    
    @Autowired
    ClientesDao clientesDao;
    
    /**
    * Método para guardar cliente
    * @param cliente objeto de la cliente
    **/
    public void guardar(@RequestBody Clientes cliente){
        Usuario x = usuarioDao.findByNumeroEmpleado(cliente.getUsuario().getNumeroEmpleado());
        cliente.setUsuario(x);
        clientesDao.save(cliente);
    }
    
    /**
    * Método para listar clientes
    * @return lista clientes
    **/
    public List<Clientes> listar() {
        return (List<Clientes>)clientesDao.findAll();
    }

    /**
    * Método para listar clientes por id
    * @param clientes objeto de la cliente
    * @return Clientes
    **/
    public Clientes listarClientesPorId(@RequestBody Clientes clientes){
        return clientesDao.findById(clientes.getId()).get();
    }

    /**
    * Método para listar clientes por usuario
    * @param usuario objeto de la usuario
    * @return lista de clientes
    **/   
    public List<Clientes> listarClientesPorUsuario(@RequestBody Usuario usuario) {
        Usuario x = usuarioDao.findByNumeroEmpleado(usuario.getNumeroEmpleado());
        return (List<Clientes>) clientesDao.findByUsuario(x);
    }

    /**
    * Método para eliminar cliente
    * @param clientes objeto de la cliente
    **/
    public void eliminar(Clientes clientes){
        System.out.println("Apunto de eliminar");
        clientesDao.delete(clientes);
    }
}
