package com.example.demo.config;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAutentificacionDeEntrada implements AuthenticationEntryPoint, Serializable {

	private static final long serialVersionUID = -7858869558953243875L;
 
	@Override
	public void commence(HttpServletRequest peticion, HttpServletResponse respuesta
,			AuthenticationException excepcionDeAutentificacion) throws IOException {

		respuesta.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	}
}
