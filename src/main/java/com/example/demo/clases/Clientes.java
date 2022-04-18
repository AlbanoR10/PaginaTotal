package com.example.demo.clases;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

/**
* Clase clientes representante del modelo
**/
@Data
@Entity
@Table(name="CLIENTES")
public class Clientes implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_clientes")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="id_usuario", nullable=false)
    private Usuario usuario;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    
    @Column(name = "fecha_contratacion")
    private Date fechaNacimiento;
    
    @Column(name = "paquete_contratado")
    private String paqueteContratado;
    
    @Column(name="primer_pago")
    private boolean primerPago;
    
    @Column(name="segundo_pago")
    private boolean segundoPago;

}
