package com.example.demo.service;

import com.example.demo.clases.Rol;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.clases.Usu;

//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.demo.dao.UsuDao;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * Clase JwtServicioDetalleUsuario para manejar los detalles de los usuarios
 *
 */
@Service
public class JwtServicioDetalleUsuario implements UserDetailsService {

    @Autowired
    UsuDao userDao;

    /**
    * Método para buscar usuario
    * @param username objeto de la String
    * @return UserDetails
    **/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usu usu = userDao.findByUsername(username);

        if (usu == null) {
            throw new UsernameNotFoundException("Usuario con el nombre: " + username + " no encontrado");
        }
        ArrayList<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();

        for (Rol rol : usu.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }

        return new User(usu.getUsername(), usu.getPassword(), roles);
    }

}
