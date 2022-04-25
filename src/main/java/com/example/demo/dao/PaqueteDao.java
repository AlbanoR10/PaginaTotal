package com.example.demo.dao;

import com.example.demo.clases.Paquete;
import org.springframework.data.repository.CrudRepository;

/**
 * Clase PaqueteDao para manejar CrudRepository de Paquetes
 *
 */
public interface PaqueteDao extends CrudRepository<Paquete, Long>{
    
}
