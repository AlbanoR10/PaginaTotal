package com.example.demo.model;

import com.example.demo.clases.Cotizacion;
import com.example.demo.clases.Usuario;
import com.example.demo.dao.CotizacionDao;
import com.example.demo.dao.PaqueteDao;
import com.example.demo.dao.UsuarioDao;
import java.util.List;
import javax.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

/**
* Clase CotizacionModelo que es el controlador de la clase Cotizacion
**/
@Component 
public class CotizacionModelo {
    @Autowired
    CotizacionDao cotizacionDao;
    
    @Autowired
    PaqueteDao paqueteDao;
    
    @Autowired
    UsuarioDao usuarioDao;
    
    /**
    * Método para guardar cotizacion
    * @param cotizacion objeto de la Cotizacion
    **/
    public void guardar(@RequestBody Cotizacion cotizacion){
        Usuario usua  = null;
        if (cotizacion.getUsuario()!=null) {            
            usua = usuarioDao.findByNumeroEmpleado(cotizacion.getUsuario().getNumeroEmpleado());
            cotizacion.setUsuario(usua);
            cotizacion.getPaquete().setCotizacion(cotizacion);
            paqueteDao.save(cotizacion.getPaquete());
        }else{
            cotizacion.getPaquete().setCotizacion(cotizacion);
            paqueteDao.save(cotizacion.getPaquete());
        }
    }
    
    /**
    * Método para listar cotizacion
    * @return List<Cotizacion>
    **/
    public List<Cotizacion> listarCotizacion(){
        return (List<Cotizacion>) cotizacionDao.findAll();
    } 
    
    /**
    * Método para eliminar cotizacion
    * @param cotizacion objeto de la Cotizacion
    **/
    public void eliminar(Cotizacion cotizacion){
        System.out.println("Apunto de eliminar");
        cotizacionDao.delete(cotizacion);
    }

    /**
    * Método para actualizar cotizacion
    * @param cotizacion objeto de la Cotizacion
    **/    
    public void actualizarCotizacion(Cotizacion cotizacion){
        cotizacionDao.save(cotizacion);
    }
    
    /**
    * Método para listar cotizacion por id
    * @param cotizacion objeto de la Cotizacion
    **/
    public Cotizacion listarCotizacionPorId(@RequestBody Cotizacion cotizacion) {
        return cotizacionDao.findById(cotizacion.getIdCotizacion()).get();
    }

    /**
    * Método para listar cotizaciones por usuario
    * @param usuario objeto de la Usuario
    **/
    public List<Cotizacion> listarCotizacionPorUsuario(@RequestBody Usuario usuario) {
        Usuario x = usuarioDao.findByNumeroEmpleado(usuario.getNumeroEmpleado());
        return (List<Cotizacion>) cotizacionDao.findByUsuario(x);
    }
}
