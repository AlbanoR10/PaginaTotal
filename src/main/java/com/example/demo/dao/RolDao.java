package com.example.demo.dao;

import com.example.demo.clases.Rol;
import org.springframework.data.repository.CrudRepository;

/**
 * Clase RolDao para manejar CrudRepository<> de Rol
 *
 */
public interface RolDao extends CrudRepository<Rol, Long>{
    
}
