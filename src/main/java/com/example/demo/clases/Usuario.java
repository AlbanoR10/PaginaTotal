package com.example.demo.clases;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
* Clase usuario representante del modelo
**/
@Data
@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;
    
    /**
     * Id unica de cada usuario
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Long id;
    
    /**
     * Cotizacion de cada usuario
     */
    @JsonIgnore   
    @OneToMany(mappedBy="usuario", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Cotizacion> cotizacion;
    
    /**
     * Clientes de cada usuario
     */
    @JsonIgnore
    @OneToMany(mappedBy="usuario", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Clientes> clientes;

    /**
     * Nombre del usuario
     */
    @Column(name="nombre")
    private String nombre;
    
    /**
     * Apellido paterno del usuario
     */
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    
    /**
     * Apellido materno del usuario
     */
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    
    /**
     * Fecha de nacimiento del usuario
     */
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    
    /**
     * Numero de empleado unico del usuario
     */
    @Column(name = "numero_empleado")
    private String numeroEmpleado;
    
    /**
    * Metodo para agregar clientes al set de clientes
    * @param client objeto de la clase cliente
    **/
    public void agregarClientes(Clientes client){
        if (clientes==null) {
            clientes = new HashSet<>();
            clientes.add(client);
        }else{
            clientes.add(client);
        }
    }
    
    /**
    * Metodo para agregar cotizaciones al set de cotizaciones
    * @param cotiza objeto de la clase cotizacion
    **/
    public void agregarCotizaciones(Cotizacion cotiza){
        if (cotizacion==null) {
            cotizacion = new HashSet<>();
            cotizacion.add(cotiza);
        }else{
            cotizacion.add(cotiza);
        }
    }
    
}
