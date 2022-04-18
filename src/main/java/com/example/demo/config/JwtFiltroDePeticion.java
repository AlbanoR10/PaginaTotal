package com.example.demo.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.service.JwtServicioDetalleUsuario;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtFiltroDePeticion extends OncePerRequestFilter {

	@Autowired
	private JwtServicioDetalleUsuario jwtUserDetailsService;

	@Autowired
	private JwtTokenUtilidad jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest peticion, HttpServletResponse respuesta, FilterChain cadena)
			throws ServletException, IOException {

		final String peticionEncabezadoToken = peticion.getHeader("Authorization");

		String nombreUsuario = null;
		String jwtToken = null;
		// JWT Token is in the form "Bearer token". Remove Bearer word and get only the Token
		if (peticionEncabezadoToken != null && peticionEncabezadoToken.startsWith("Bearer ")) {
			jwtToken = peticionEncabezadoToken.substring(7);
			try {
				nombreUsuario = jwtTokenUtil.getUsernameFromToken(jwtToken);
                                System.out.println(nombreUsuario);
			} catch (IllegalArgumentException e) {
				System.out.println("No se pudo conseguir el JWT Token");
			} catch (ExpiredJwtException e) {
				System.out.println("JWT token ha expirado");
			}
		} else {
			logger.warn("El token no inicia con la palabra Bearer");
		}

		//Once we get the token validate it.
		if (nombreUsuario != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails detallesUsuario = this.jwtUserDetailsService.loadUserByUsername(nombreUsuario);

			// if token is valid configure Spring Security to manually set authentication
			if (jwtTokenUtil.validateToken(jwtToken, detallesUsuario)) {

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						detallesUsuario, null, detallesUsuario.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(peticion));
				// After setting the Authentication in the context, we specify
				// that the current user is authenticated. So it passes the Spring Security Configurations successfully.
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		cadena.doFilter(peticion, respuesta);
	}

}
