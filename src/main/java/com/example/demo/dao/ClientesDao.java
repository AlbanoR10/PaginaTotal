package com.example.demo.dao;

import com.example.demo.clases.Clientes;
import com.example.demo.clases.Cotizacion;
import com.example.demo.clases.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * Clase ClientesDao para manejar CrudRepository<> de clientes
 *
 */
public interface ClientesDao extends CrudRepository<Clientes, Long>{
    public List<Clientes> findByUsuario(Usuario usuario);
}
