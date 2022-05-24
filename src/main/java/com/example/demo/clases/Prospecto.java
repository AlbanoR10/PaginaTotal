package com.example.demo.clases;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
* Clase prospecto representante del modelo
**/
@Data
@Entity
@Table(name = "Prospecto")
public class Prospecto implements Serializable{
    private static final long serialVersionUID = 1L;

    public Prospecto() {
    }

    public Prospecto(String nombre, String paquete, String telefono) {
        this.nombre = nombre;
        this.paquete = paquete;
        this.telefono = telefono;
    }
    
    /**
     * Id unico de cada prospecto
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    /**
     * Nombre del prospecto
     *
     */
    
    @Column(name="nombre")
    private String nombre;
    
    /**
     * Nombre del paquete seleccionado
     *
     */
    @Column(name = "paquete")
    private String paquete;
    
    /**
     * Numero de telefono 
     *
     */
    @Column(name = "telefono")
    private String telefono;
    
    /**
     * Ver si esta activo el prospecto
     *
     */
    @Column(name="activo", nullable = true)
    private boolean activo;

    /**
     * Fecha en que se hizo el contacto
     *
     */
    @Column(name = "fecha_prospeccion")
    private Date fechaProspeccion;
}
