package com.example.demo.clases;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 * Clase paquete representante del modelo
*
 */
@Data
@Entity
@Table(name = "Paquete")
public class Paquete implements Serializable {

    private static final long serialVersionUID = 1L;

    public Paquete() {
    }

    /**
     * Id unico del paqutee
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paquete")
    private Long idPaquete;

    /**
     * Velocidad de internet seleccionada
     *
     */
    @Column(name = "velocidad_internet", nullable = false)
    private String velocidadInternet;

    /**
     * Variable para ver que tipo de television se selecciona
     *
     */
    @Column(name = "television", nullable = false)
    private String television;

    /**
     * Variable para ver si se selecciono netflix
     *
     */
    @Column(name = "netflix")
    private boolean netflix;

    /**
     * Variable para ver si se selecciono amazon
     *
     */
    @Column(name = "amazon")
    private boolean amazon;
    /**
     * Variable para ver si se selecciono Amazon
     *
     */
    @Column(name = "hbo")
    private boolean hbo;

    /**
     * Variable para ver si se selecciono Starplus
     *
     */
    @Column(name = "star")
    private boolean star;

    /**
     * Cantidad de wifiExtender seleccionados
     *
     */
    @Column(name = "wifi_extender", nullable = false)
    private String wifiExtender;

    /**
     * Cantidad de tv adicionales seleccionadas
     *
     */
    @Column(name = "tv_adicional")
    private String tvAdicional;

    /**
     * Variable para ver si se selecciono 140 canales
     *
     */
    @Column(name = "canales140")
    private boolean canales140;

    /**
     * Variable para ver si se selecciono 230 canales
     *
     */
    @Column(name = "canales230")
    private boolean canales230;

    /**
     * Variable para ver si se selecciono 280 canales
     *
     */
    @Column(name = "canales280")
    private boolean canales280;

    /**
     * Cotizacion con la que se asocia
     *
     */
    @JsonIgnore
    @OneToOne(mappedBy = "paquete", cascade = CascadeType.ALL)
    private Cotizacion cotizacion;
}
