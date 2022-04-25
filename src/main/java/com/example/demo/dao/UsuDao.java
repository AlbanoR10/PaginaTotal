package com.example.demo.dao;

import com.example.demo.clases.Usu;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Clase UsuDao para manejar CrudRepository<> de Usu
 *
 */
public interface UsuDao extends JpaRepository<Usu, Long>{
    Usu findByUsername(String username);
}
