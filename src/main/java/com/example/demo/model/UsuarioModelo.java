package com.example.demo.model;

import com.example.demo.clases.Clientes;
import com.example.demo.clases.Cotizacion;
import com.example.demo.clases.Usuario;
import com.example.demo.dao.CotizacionDao;
import com.example.demo.dao.PaqueteDao;
import com.example.demo.dao.UsuarioDao;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.dao.ClientesDao;
import java.util.Set;

@Component 
public class UsuarioModelo {
    @Autowired
    UsuarioDao usuarioDao;
    
    @Autowired
    ClientesDao clienteDao;
    
    @Autowired
    CotizacionDao cotizacionDao;
    
    public void guardar(@RequestBody Usuario usuario){
        usuarioDao.save(usuario);
    }
    
    public List<Usuario> listarUsuario(){
        return (List<Usuario>)usuarioDao.findAll();
    } 
    
    public void eliminarUsuario(@RequestBody Usuario usuario){
        usuarioDao.delete(usuario);
    }
    
    public void actualizarUsuario(@RequestBody Usuario usuario){
        usuarioDao.save(usuario);
    }
    public Usuario listarUsuarioPorId(@RequestBody Usuario usuario){
        return usuarioDao.findById(usuario.getId()).get();
    }
    public Set<Cotizacion> listarCotizacionesPorUsuario(@RequestBody Usuario usuario){
        //return (Cotizacion) usuarioDao.findById(usuario.getId()).get().getCotizacion();
        return usuarioDao.findById(usuario.getId()).get().getCotizacion();
    }
    
    public Set<Clientes> listarClientesPorUsuario(@RequestBody Usuario usuario){
        //return (Cotizacion) usuarioDao.findById(usuario.getId()).get().getCotizacion();
        return usuarioDao.findById(usuario.getId()).get().getClientes();
    }
    
    public Usuario listarUsuarioPorNumeroEmpleado(@RequestBody Usuario usuario){
        return usuarioDao.findByNumeroEmpleado(usuario.getNumeroEmpleado());
    }
}