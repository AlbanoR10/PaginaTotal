package com.example.demo.dao;

import com.example.demo.clases.Prospecto;
import org.springframework.data.repository.CrudRepository;

/**
 * Clase ProspectoDao para manejar CrudRepository de Prospectos
 *
 */
public interface ProspectoDao extends CrudRepository<Prospecto, Long>{
    
}
