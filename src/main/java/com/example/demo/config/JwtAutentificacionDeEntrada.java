package com.example.demo.config;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
* Clase JwtAutentificacionDeEntrada que autentifica accesos en el proyecto
**/
@Component
public class JwtAutentificacionDeEntrada implements AuthenticationEntryPoint, Serializable {

	private static final long serialVersionUID = -7858869558953243875L;
 
        /**
        * Método para mostrar autentificación incorrecto
        * @param peticion objeto de la clase HttpServletRequest
        * @param respuesta objeto de la clase HttpServletResponse
        **/
	@Override
	public void commence(HttpServletRequest peticion, HttpServletResponse respuesta
,			AuthenticationException excepcionDeAutentificacion) throws IOException {

		respuesta.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	}
}
