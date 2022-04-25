package com.example.demo.model;

import com.example.demo.clases.Cotizacion;
import com.example.demo.clases.Prospecto;
import com.example.demo.dao.ProspectoDao;
import java.util.List;
import javax.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

/**
* Clase ProspectoModelo que es el modelo de la clase Prospecto
**/
@Component
public class ProspectosModelo {

    /**
    * Método para listar prospectos
    * @return List<Prospectos>
    **/
    @Autowired
    ProspectoDao prospectoDao;
    public List<Prospecto> listar(){
        return (List<Prospecto>) prospectoDao.findAll();
    }

    /**
    * Método para guardar prospecto
    * @param prospecto objeto de la Prospecto
    **/
    public void guardar(Prospecto prospecto){
        prospectoDao.save(prospecto);
    }

    /**
    * Método para elimin prospectos
    * @param prospecto objeto de la Prospecto
    **/        
    public void eliminar(Prospecto prospecto){
        prospectoDao.delete(prospecto);
    }
    
    /**
    * Método para actualizar prospectos
    * @param prospecto objeto de la Prospecto
    **/    
    public void actualizar(Prospecto prospecto){
        prospectoDao.save(prospecto);
    }
}
