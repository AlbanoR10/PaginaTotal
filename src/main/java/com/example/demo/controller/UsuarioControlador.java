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

@Component
public class UsuarioControlador {
    @Autowired
    UsuarioModelo usuarioModelo;
    
    public void guardar(Usuario usuario) {
        usuarioModelo.guardar(usuario);
    }
    
    public List<Usuario> listarUsuario() {
        return usuarioModelo.listarUsuario();
    }

    public void eliminarUsuario(Usuario usuario) {
        usuarioModelo.eliminarUsuario(usuario);
    }

    public void actualizarUsuario(Usuario usuario) {
        usuarioModelo.actualizarUsuario(usuario);
    }
    
    public Usuario listarUsuarioPorId(@RequestBody Usuario usuario){
        return usuarioModelo.listarUsuarioPorId(usuario);
    }
    
    public Set<Cotizacion> listarCotizacionesPorUsuario(@RequestBody Usuario usuario){
        return usuarioModelo.listarCotizacionesPorUsuario(usuario);
    }
    public Set<Clientes> listarClientesPorUsuario(@RequestBody Usuario usuario){
        return usuarioModelo.listarClientesPorUsuario(usuario);
    }
    public Usuario listarUsuarioPorNumeroEmpleado(@RequestBody Usuario usuario){

        return usuarioModelo.listarUsuarioPorNumeroEmpleado(usuario);
    }
}

