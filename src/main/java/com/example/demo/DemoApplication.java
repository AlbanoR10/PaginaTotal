package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase que inicia la aplicación 
 * Este es el punto de inicio de la ejecución de la aplicación.
 *
 * @author AlbanoDLR
 */
@SpringBootApplication
public class DemoApplication {

/**
* Método principal de la aplicación
* @param args lista de strings
*/

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
