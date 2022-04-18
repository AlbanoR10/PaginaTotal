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

@Component
public class ClientesModelo {
    @Autowired
    UsuarioDao usuarioDao;
    
    @Autowired
    ClientesDao clientesDao;
    
    public void guardar(@RequestBody Clientes cliente){
        Usuario x = usuarioDao.findByNumeroEmpleado(cliente.getUsuario().getNumeroEmpleado());
        cliente.setUsuario(x);
        clientesDao.save(cliente);
    }
    
    public List<Clientes> listar() {
        return (List<Clientes>)clientesDao.findAll();
    }
    
    public Clientes listarClientesPorId(@RequestBody Clientes clientes){
        return clientesDao.findById(clientes.getId()).get();
    }
    
    public List<Clientes> listarClientesPorUsuario(@RequestBody Usuario usuario) {
        Usuario x = usuarioDao.findByNumeroEmpleado(usuario.getNumeroEmpleado());
        return (List<Clientes>) clientesDao.findByUsuario(x);
    }
}
