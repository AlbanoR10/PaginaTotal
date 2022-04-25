package com.example.demo.controller;

import com.example.demo.clases.Cotizacion;
import com.example.demo.clases.Prospecto;
import com.example.demo.clases.Usuario;
import com.example.demo.dao.UsuarioDao;
import com.example.demo.model.CotizacionModelo;
import com.example.demo.model.UsuarioModelo;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

/**
* Clase CotizacionControlador que es el controlador de la clase Cotizacion
**/
@Component
public class CotizacionControlador {

    @Autowired
    CotizacionModelo cotizacionModelo;
    
    @Autowired
    UsuarioModelo usuarioModelo;
    
    @Autowired
    UsuarioDao usuarioDao;

    /**
    * Método para guardar cotizacion
    * @param cotizacion objeto de la Cotizacion
    **/
    public void guardar(Cotizacion cotizacion) {
        //Verificacion del correo
        String regx = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regx).compile(regx);
        Matcher matcher = pattern.matcher(cotizacion.getCorreoElectronico());
        if (!matcher.matches()) {
            throw new RuntimeException("Correo electronico invalido");
        }
        
        //Verificacion Numero Telefono
        if(cotizacion.getNumeroTelefono()!=""){
            numeroTelefonoValido(cotizacion.getNumeroTelefono());
        }
        //Verificacion Wifi Extender
        int cantidadWifiExtender = Integer.parseInt(cotizacion.getPaquete().getWifiExtender());
        if (cantidadWifiExtender<0 || cantidadWifiExtender>4) {
            throw new RuntimeException("Cantidad Wifi extenders incorrecta");
        }
        int velocidadInternet = Integer.parseInt(cotizacion.getPaquete().getVelocidadInternet());
        System.out.println(velocidadInternet);
        if (velocidadInternet<20 || velocidadInternet>1000) {
            throw new RuntimeException("Velocidad de Internet incorrecta");
        }
        cotizacionModelo.guardar(cotizacion);
    }

    /**
    * Método para listar cotizacion
    * @return List<Cotizacion>
    **/
    public List<Cotizacion> listarCotizacion() {
        return cotizacionModelo.listarCotizacion();
    }

    /**
    * Método para actualizar cotizacion
    * @param cotizacion objeto de la Cotizacion
    **/
    public void actualizarCotizacion(Cotizacion cotizacion) {
        cotizacionModelo.actualizarCotizacion(cotizacion);
    }

    public static void numeroTelefonoValido(String numero) {
        //Phone validation
        String PHONE_VERIFICATION = "^[+0-9-\\(\\)\\s]*{6,14}$";
        Pattern p;
        Matcher m;

        p  = Pattern.compile(PHONE_VERIFICATION);
        m  = p.matcher(numero);
        boolean isPhoneValid = m.matches();

        if(!isPhoneValid){
            throw new RuntimeException("Numero Telefonico invalido");
        }
    }
    
    /**
    * Método para eliminar cotizacion
    * @param cotizacion objeto de la Cotizacion
    **/
    public void eliminar(Cotizacion cotizacion){
        cotizacionModelo.eliminar(cotizacion);
    }
    
    /**
    * Método para listar cotizacion por id
    * @param cotizacion objeto de la Cotizacion
    **/
    public Cotizacion listarCotizacionPorId(@RequestBody Cotizacion cotizacion) {
        usuarioDao.findByNumeroEmpleado(cotizacion.getUsuario().getNumeroEmpleado());
        return cotizacionModelo.listarCotizacionPorId(cotizacion);
    }
    
    /**
    * Método para listar cotizaciones por usuario
    * @param usuario objeto de la Usuario
    **/
    public List<Cotizacion> listarCotizacionPorUsuario(@RequestBody Usuario usuario) {
        return (List<Cotizacion>) cotizacionModelo.listarCotizacionPorUsuario(usuario);
    }
    
    
}
