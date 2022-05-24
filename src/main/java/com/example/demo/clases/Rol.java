package com.example.demo.clases;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;


@Entity
@Table(name="ROL")
public class Rol implements Serializable{
    private static final long serialVersionUID = 1L;
    
    /**
     * Id unica de cada rol
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_rol")
    private Long id;
    
    /**
     * Nombre del rol
     *
     */
    @Column(name="nombre")
    private String nombre;
    
    /**
     * Id del usu asociado con el rol
     *
     */
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_usu", nullable=false)
    private Usu usu;
    
    /**
     * Método que regresa usu
     *
     * @return Usu
     *
     */
    public Usu getUsu() {
        return usu;
    }
    
    /**
     * Método que regresa nombre del objeto
     *
     * @param usu usuario que se asociara con rol
     *
     */
    public void setUsu(Usu usu) {
        this.usu = usu;
    }

    /**
     * Método que regresa usu
     *
     * @return id
     *
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Método que regresa nombre del objeto
     *
     * @param id unico
     *
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método que regresa nombre del objeto
     *
     * @return nombre
     *
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que setea
     *
     * @param nombre nombre del rol
     *
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
