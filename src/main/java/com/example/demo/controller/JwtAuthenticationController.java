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

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager manejadorAutentificacion;

	@Autowired
	private JwtTokenUtilidad jwtTokenUtil;

	@Autowired
	private UserDetailsService jwtMemoriaDetallesUsuario;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtPeticion authenticationRequest)
			throws Exception {

		authenticate(authenticationRequest.getNombreUsuario(), authenticationRequest.getContraseña());

		final UserDetails detallesUsuario = jwtMemoriaDetallesUsuario
				.loadUserByUsername(authenticationRequest.getNombreUsuario());

		final String token = jwtTokenUtil.generateToken(detallesUsuario);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String nombreUsuario, String contraseña) throws Exception {
		Objects.requireNonNull(nombreUsuario);
		Objects.requireNonNull(contraseña);

		try {
			manejadorAutentificacion.authenticate(new UsernamePasswordAuthenticationToken(nombreUsuario, contraseña));
		} catch (DisabledException e) {
			throw new Exception("Usuario Desactivado", e);
		} catch (BadCredentialsException e) {
			throw new Exception("Credenciales Invalidas", e);
		}
	}
}
