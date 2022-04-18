package com.example.demo.dao;

import com.example.demo.clases.Cotizacion;
import com.example.demo.clases.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CotizacionDao extends CrudRepository<Cotizacion, Long>{
    public List<Cotizacion> findByUsuario(Usuario usuario);
}
