package com.example.demo.clases;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
* Clase usu representante del modelo
**/
@Data
@Entity
@Table(name="USU")
public class Usu implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usu")
    private Long id;
    
    @Column(name="username")
    private String username;
    
    @Column(name="password")
    private String password;
    
    @JsonIgnore   
    @OneToMany(mappedBy="usu", fetch = FetchType.EAGER)
    private Set<Rol> roles;
    
    /**
    * Metodo para agregar clientes al set de clientes
    * @param rol objeto de la clase rol
    **/
    public void agregarRoles(Rol rol){
        if (roles==null) {
            roles = new HashSet<>();
            roles.add(rol);
        }else{
            roles.add(rol);
        }
    }
}
