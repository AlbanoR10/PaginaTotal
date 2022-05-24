package com.example.demo.clases;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
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
 *
 */
@Data
@Entity
@Table(name = "Cotizacion")
public class Cotizacion implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id unico de cada cotizacion
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cotizacion")
    private Long idCotizacion;

    /**
     * id del paquete asociado con la cotizacion
     *
     */
    @OneToOne(cascade = CascadeType.REMOVE, optional = true)
    @JoinColumn(name = "id_paquete")
    private Paquete paquete;

    /**
     * id del usuario asociado con la cotizacion
     *
     */
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = true)
    private Usuario usuario;

    /**
     * Numero de telefono del que cotiza
     *
     */
    @Column(name = "numero_telefono", nullable = true)
    private String numeroTelefono;

    /**
     * Correo electronido del que cotiza
     *
     */
    @Column(name = "correo_electronico", nullable = true)
    private String correoElectronico;

    /**
     * Variable para ver si cotizacion esta activa
     *
     */
    @Column(name = "activo", nullable = true)
    private boolean activo;

    /**
     * Fecha de cotizacion
     *
     */
    @Column(name = "fecha_cotizacion")
    private Date fechaCotizacion;

}
