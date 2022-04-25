package com.example.demo.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.JwtTokenUtilidad;
import com.example.demo.model.JwtPeticion;
import com.example.demo.model.JwtResponse;

/**
 * Clase JwtAuthenticationController que es el controlador de la clase JWT
 *
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager manejadorAutentificacion;

    @Autowired
    private JwtTokenUtilidad jwtTokenUtil;

    @Autowired
    private UserDetailsService jwtMemoriaDetallesUsuario;

    /**
     * Método para autenticar usuarios, muestra el login
     *
     * @param authenticationRequest objeto de la JwtPeticion
     * @return JwtResponse 
     */
    @CrossOrigin
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtPeticion authenticationRequest)
            throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails detallesUsuario = jwtMemoriaDetallesUsuario
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(detallesUsuario);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    /**
     * Método para autenticar usuarios
     *
     * @param authenticationRequest objeto de la JwtPeticion
     */
    private void authenticate(String username, String password) throws Exception {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            manejadorAutentificacion.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("Usuario Desactivado", e);
        } catch (BadCredentialsException e) {
            throw new Exception("Credenciales Invalidas", e);
        }
    }
}
