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
**/
@Data
@Entity
@Table(name = "Paquete")
public class Paquete implements Serializable{
    private static final long serialVersionUID = 1L;

    public Paquete() {
    }

    public Paquete(Long idPaquete, String velocidadInternet, boolean television, boolean nuevoTotalPlayTv, boolean netflix, boolean amazon, String cantidadPantallasNetflix, String wifiExtender, String tvAdicional, String nuevoTotalPlayTvAdicional, boolean canales140, boolean canales230, boolean canales280) {
        this.idPaquete = idPaquete;
        this.velocidadInternet = velocidadInternet;
        this.television = television;
        this.nuevoTotalPlayTv = nuevoTotalPlayTv;
        this.netflix = netflix;
        this.amazon = amazon;
        this.cantidadPantallasNetflix = cantidadPantallasNetflix;
        this.wifiExtender = wifiExtender;
        this.tvAdicional = tvAdicional;
        this.nuevoTotalPlayTvAdicional = nuevoTotalPlayTvAdicional;
        this.canales140 = canales140;
        this.canales230 = canales230;
        this.canales280 = canales280;
    }
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_paquete")
    private Long idPaquete;
    
    @Column(name="velocidad_internet", nullable = false)
    private String velocidadInternet;
    
    @Column(name="television", nullable = false)
    private boolean television;
    
    @Column(name="nuevo_total_play_tv")
    private boolean nuevoTotalPlayTv;
    
    @Column(name="netflix")
    private boolean netflix;
    
    @Column(name="amazon")
    private boolean amazon;
    
    @Column(name="cantidad_pantallas_netflix")
    private String cantidadPantallasNetflix;
    
    @Column(name="wifi_extender", nullable = false)
    private String wifiExtender;
    
    @Column(name="tv_adicional")
    private String tvAdicional;
    
    @Column(name="nuevo_total_play_tv_adicional")
    private String nuevoTotalPlayTvAdicional;
    
    @Column(name="canales140")
    private boolean canales140;
    
    @Column(name="canales230")
    private boolean canales230;
    
    @Column(name="canales280")
    private boolean canales280;
    
    @JsonIgnore    
    @OneToOne(mappedBy = "paquete", cascade = CascadeType.ALL)
    private Cotizacion cotizacion;
}
