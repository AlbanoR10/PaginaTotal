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

@Component 
public class CotizacionModelo {
    @Autowired
    CotizacionDao cotizacionDao;
    
    @Autowired
    PaqueteDao paqueteDao;
    
    @Autowired
    UsuarioDao usuarioDao;
    
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
    
    public List<Cotizacion> listarCotizacion(){
        return (List<Cotizacion>) cotizacionDao.findAll();
    } 
    
    public void eliminar(Cotizacion cotizacion){
        System.out.println("Apunto de eliminar");
        cotizacionDao.delete(cotizacion);
    }
    
    public void actualizarCotizacion(Cotizacion cotizacion){
        cotizacionDao.save(cotizacion);
    }
    
    public Cotizacion listarCotizacionPorId(@RequestBody Cotizacion cotizacion) {
        return cotizacionDao.findById(cotizacion.getIdCotizacion()).get();
    }
    public List<Cotizacion> listarCotizacionPorUsuario(@RequestBody Usuario usuario) {
        Usuario x = usuarioDao.findByNumeroEmpleado(usuario.getNumeroEmpleado());
        return (List<Cotizacion>) cotizacionDao.findByUsuario(x);
    }
}
