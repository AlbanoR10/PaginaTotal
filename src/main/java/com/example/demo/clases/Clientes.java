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
 *
 */
@Data
@Entity
@Table(name = "CLIENTES")
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID unico para clientes
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clientes")
    private Long id;

    /**
     * Id del usuario con el que se vincula
     */
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    /**
     * Nombre del cliente
     */
    @Column(name = "nombre", nullable = true)
    private String nombre;

    /**
     * Apellido paterno del cliente
     */
    @Column(name = "apellido_paterno", nullable = true)
    private String apellidoPaterno;

    /**
     * Apellido materno del cliente
     */
    @Column(name = "apellido_materno", nullable = true)
    private String apellidoMaterno;

    /**
     * Fecha de contratacion del paquete
     */
    @Column(name = "fecha_contratacion", nullable = true)
    private Date fechaNacimiento;

    /**
     * Nombre del paquete contratado
     */
    @Column(name = "paquete_contratado", nullable = true)
    private String paqueteContratado;

    /**
     * Especificacion del segundo pago
     */
    @Column(name = "primer_pago", nullable = true)
    private boolean primerPago;

    /**
     * Especificacion del segudno pago
     */
    @Column(name = "segundo_pago", nullable = true)
    private boolean segundoPago;

}
