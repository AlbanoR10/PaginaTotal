package com.example.demo.controller;

import com.example.demo.clases.Prospecto;
import com.example.demo.model.ProspectosModelo;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class ProspectosControlador {
    @Autowired
    ProspectosModelo prospectosModelo;
    
    public void guardar(Prospecto prospecto){
        
        //Verificacion Numero Telefono
        if(prospecto.getTelefono()!=""){
            numeroTelefonoValido(prospecto.getTelefono());
        }
        
        prospectosModelo.guardar(prospecto);
    }
    
    public List<Prospecto> listar(){
        return (List<Prospecto>) prospectosModelo.listar();
    }
    
    public void eliminar(Prospecto prospecto){
        prospectosModelo.eliminar(prospecto);
    }
    
    public void actualizar(Prospecto prospecto){
        prospectosModelo.guardar(prospecto);
    }
    
    public static void numeroTelefonoValido(String numero) {
        //Phone validation
        String TELEFONO_VERIFICACION = "^[+0-9-\\(\\)\\s]*{6,14}$";
        Pattern p;
        Matcher m;

        p  = Pattern.compile(TELEFONO_VERIFICACION);
        m  = p.matcher(numero);
        boolean isPhoneValid = m.matches();

        if(!isPhoneValid){
            throw new RuntimeException("Numero Telefonico invalido");
        }
    }
}
