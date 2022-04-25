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

/**
* Clase UsuarioMOdelo que es el modelo de la clase Usuario
**/
@Component 
public class UsuarioModelo {
    @Autowired
    UsuarioDao usuarioDao;
    
    @Autowired
    ClientesDao clienteDao;
    
    @Autowired
    CotizacionDao cotizacionDao;
    
    /**
    * Método para guardar usuario
    * @param usuario objeto de la Usuario
    **/
    public void guardar(@RequestBody Usuario usuario){
        usuarioDao.save(usuario);
    }
    
    /**
    * Método para listar usaurios
    * @return lista usuarios
    **/
    public List<Usuario> listarUsuario(){
        return (List<Usuario>)usuarioDao.findAll();
    } 
    
    /**
    * Método para eliminar usuario
    * @param usuario objeto de la Usuario
    **/
    public void eliminarUsuario(@RequestBody Usuario usuario){
        usuarioDao.delete(usuario);
    }
    
    /**
    * Método para actualizar usuarios
    * @param usuario objeto de la Usuario
    **/
    public void actualizarUsuario(@RequestBody Usuario usuario){
        usuarioDao.save(usuario);
    }

    /**
    * Método para listar usaurios
    * @param usuario objeto de la clase usaurio
    * @return Usuario
    **/
    public Usuario listarUsuarioPorId(@RequestBody Usuario usuario){
        return usuarioDao.findById(usuario.getId()).get();
    }

    /**
    * Método para listar usuarios
    * @param usuario objeto de la Usuario
    * @return set de cotizaciones
    **/
    public Set<Cotizacion> listarCotizacionesPorUsuario(@RequestBody Usuario usuario){
        //return (Cotizacion) usuarioDao.findById(usuario.getId()).get().getCotizacion();
        return usuarioDao.findById(usuario.getId()).get().getCotizacion();
    }
    
    /**
    * Método para listar clientes por usuario
    * @param usuario objeto de la Usuario
    * @return set de clientes
    **/
    public Set<Clientes> listarClientesPorUsuario(@RequestBody Usuario usuario){
        //return (Cotizacion) usuarioDao.findById(usuario.getId()).get().getCotizacion();
        return usuarioDao.findById(usuario.getId()).get().getClientes();
    }
    
    /**
    * Método para listar usuario por numero empleado
    * @param usuario objeto de la Usuario
    * @return Usuario
    **/
    public Usuario listarUsuarioPorNumeroEmpleado(@RequestBody Usuario usuario){
        return usuarioDao.findByNumeroEmpleado(usuario.getNumeroEmpleado());
    }
}
