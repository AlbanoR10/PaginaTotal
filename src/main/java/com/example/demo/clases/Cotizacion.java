package com.example.demo.clases;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

/**
* Clase cotizacion representante del modelo
**/
@Data
@Entity
@Table(name = "Cotizacion")
public class Cotizacion implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cotizacion")
    private Long idCotizacion;
    
    @OneToOne(cascade=CascadeType.REMOVE, optional=true)
    @JoinColumn(name = "id_paquete")
    private Paquete paquete;
    
    
    @ManyToOne
    @JoinColumn(name="id_usuario", nullable=false)
    private Usuario usuario;
   
    @Column(name="numero_telefono", nullable = false)
    private String numeroTelefono;
    
    @Column(name="correo_electronico", nullable = false)
    private String correoElectronico;
  
}