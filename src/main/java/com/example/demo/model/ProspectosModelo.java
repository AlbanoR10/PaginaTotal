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


@Component
public class ProspectosModelo {
    @Autowired
    ProspectoDao prospectoDao;
    public List<Prospecto> listar(){
        return (List<Prospecto>) prospectoDao.findAll();
    }
    
    public void guardar(Prospecto prospecto){
        prospectoDao.save(prospecto);
    }
    
    public void eliminar(Prospecto prospecto){
        prospectoDao.delete(prospecto);
    }
    
    public void actualizar(Prospecto prospecto){
        prospectoDao.save(prospecto);
    }
}
