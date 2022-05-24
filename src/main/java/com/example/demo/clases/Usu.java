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

@Entity
@Table(name = "USU")
public class Usu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Id unica de cada usu
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usu")
    private Long id;

    /**
     * Campo de username 
     *
     */
    @Column(name = "username")
    private String username;

    /**
     * Campo de password
     *
     */
    @Column(name = "password")
    private String password;

    /**
     * Roles con los que se asocial
     *
     */
    @JsonIgnore
    @OneToMany(mappedBy = "usu", fetch = FetchType.EAGER)
    private Set<Rol> roles;


    /**
     * Método que regresa los roles
     *
     * @return roles
     *
     */
    public Set<Rol> getRoles() {
        return roles;
    }

    /**
     * Metodo para agregar roles
     *
     * @param roles objeto de la clase rol
     *
     */
    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    /**
     * Metodo para agregar clientes al set de clientes
     *
     * @param rol objeto de la clase rol
     *
     */
    public void agregarRoles(Rol rol) {
        if (roles == null) {
            roles = new HashSet<>();
            roles.add(rol);
        } else {
            roles.add(rol);
        }
    }

    /**
     * Método que regresa id
     *
     * @return id
     *
     */
    public Long getId() {
        return id;
    }

    /**
     * Metodo para setear id
     *
     * @param id objeto de la clase rol
     *
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método que regresa username
     *
     * @return username
     *
     */
    public String getUsername() {
        return username;
    }

    /**
     * Metodo para setear username
     *
     * @param username objeto de la clase rol
     *
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Método que regresa password
     *
     * @return password
     *
     */
    public String getPassword() {
        return password;
    }

    /**
     * Metodo para setear password
     *
     * @param password objeto de la clase rol
     *
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
