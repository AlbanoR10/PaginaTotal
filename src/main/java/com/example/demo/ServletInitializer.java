package com.example.demo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
/**
* Clase que inicializa el servidor sobre el que se ejecuta la aplicación
* @author AlbanoDlr
*/
public class ServletInitializer extends SpringBootServletInitializer {
/**
* Método que lanza configuración del servidor
*/
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}

}
