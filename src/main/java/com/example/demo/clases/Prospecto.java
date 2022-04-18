package com.example.demo.clases;

import java.io.Serializable;
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
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name = "paquete")
    private String paquete;
    
    @Column(name = "telefono")
    private String telefono;
    
}
