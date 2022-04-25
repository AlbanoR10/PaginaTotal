package com.example.demo.controller;

import com.example.demo.clases.Clientes;
import com.example.demo.clases.Cotizacion;
import com.example.demo.clases.Usuario;
import static com.example.demo.controller.CotizacionControlador.numeroTelefonoValido;
import com.example.demo.model.CotizacionModelo;
import com.example.demo.model.UsuarioModelo;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

/**
* Clase UsuarioControlador que es el controlador de la clase Usuario
**/
@Component
public class UsuarioControlador {
    @Autowired
    UsuarioModelo usuarioModelo;
    
    /**
    * Método para guardar usuario
    * @param usuario objeto de la Usuario
    **/
    public void guardar(Usuario usuario) {
        usuarioModelo.guardar(usuario);
    }
    
    /**
    * Método para listar usaurios
    * @return lista usuarios
    **/
    public List<Usuario> listarUsuario() {
        return usuarioModelo.listarUsuario();
    }

    /**
    * Método para eliminar usuario
    * @param usuario objeto de la Usuario
    **/
    public void eliminarUsuario(Usuario usuario) {
        usuarioModelo.eliminarUsuario(usuario);
    }

    /**
    * Método para actualizar usuarios
    * @param usuario objeto de la Usuario
    **/
    public void actualizarUsuario(Usuario usuario) {
        usuarioModelo.actualizarUsuario(usuario);
    }
    
    /**
    * Método para listar usaurios
    * @param usuario objeto de la clase usaurio
    * @return Usuario
    **/
    public Usuario listarUsuarioPorId(@RequestBody Usuario usuario){
        return usuarioModelo.listarUsuarioPorId(usuario);
    }
    
    /**
    * Método para listar usuarios
    * @param usuario objeto de la Usuario
    * @return set de cotizaciones
    **/
    public Set<Cotizacion> listarCotizacionesPorUsuario(@RequestBody Usuario usuario){
        return usuarioModelo.listarCotizacionesPorUsuario(usuario);
    }

    /**
    * Método para listar clientes por usuario
    * @param usuario objeto de la Usuario
    * @return set de clientes
    **/
    public Set<Clientes> listarClientesPorUsuario(@RequestBody Usuario usuario){
        return usuarioModelo.listarClientesPorUsuario(usuario);
    }

    /**
    * Método para listar usuario por numero empleado
    * @param usuario objeto de la Usuario
    * @return Usuario
    **/
    public Usuario listarUsuarioPorNumeroEmpleado(@RequestBody Usuario usuario){

        return usuarioModelo.listarUsuarioPorNumeroEmpleado(usuario);
    }
}

