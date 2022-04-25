package com.example.demo.dao;

import com.example.demo.clases.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 * Clase UsuarioDao para manejar CrudRepository de Usuario
 *
 */
public interface UsuarioDao extends CrudRepository<Usuario, Long>{
    public Usuario findByNumeroEmpleado(String name);
}
