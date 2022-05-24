package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Clase WebSecurityConfig que maneja la seguridad web
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Variable JwtAutentificacionDeEntrada que autentifica accesos en el proyecto
     *
     */
    @Autowired
    private JwtAutentificacionDeEntrada jwtAutentificacionDeEntrada;

    /**
     * Variable de la clase de detalles del servicio
     */
    @Autowired
    private UserDetailsService jwtDetallesServicioUsuario;

    /**
     * Clase JwtFiltroDePeticion representante del modelo
     *
     */
    @Autowired
    private JwtFiltroDePeticion jwtFiltroPeticion;

    /**
     * Método para codificar password
     *
     * @param autentificacion objeto de la clase AuthenticationManagerBuilder
     *
     */
    @Override
    public void configure(AuthenticationManagerBuilder autentificacion) throws Exception {
        // configure AuthenticationManager so that it knows from where to load
        // user for matching credentials
        // Use BCryptPasswordEncoder
        autentificacion.userDetailsService(jwtDetallesServicioUsuario).passwordEncoder(passwordEncoder());
    }

    /**
     * Método que regresa objeto que encrypta
     *
     * @return BCryptPasswordEncoder
     *
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Método que regresa objeto manejador de autentificacion
     *
     * @return authenticationManagerBean
     *
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * Método que configura las urls de la app
     *
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // We don't need CSRF for this example
        httpSecurity.cors().disable()
                .csrf().disable()
                // dont authenticate this particular request
                .authorizeRequests().antMatchers(
                        "/authenticate",
                        "/hello",
                        "/guardarProspecto",
                        "/listarProspectos",
                        "/listarCotizaciones",
                        "/guardarCotizacion",
                        "/prueba",
                        "/listarUsuarios",
                        "/guardarUsuario",
                        "/listarClientes",
                        "/listarCotizacionesPorUsuario",
                        "/listarClientesPorUsuario",
                        "/eliminarProspecto",
                        "/eliminarCotizacion",
                        "/eliminarUsuario",
                        "/eliminarCliente",
                        "/listarCotizacionPorId",
                        "/listarClientesPorId",
                        "/listarUsuarioPorId",
                        "/obtenerUsuarioConToken",
                        "/listarUsuarioPorNumeroEmpleado",
                        "/editarUsuario",
                        "/editarProspecto",
                        "/editarCotizacion",
                        "/editarClientes",
                        "/listarCotizacionPorUsuario",
                        "/listarCotizacionPorUsuarioNumero",
                        "/listarClientesPorUsuarioNumero",
                        "/guardarCliente",
                        "/enviarRecordatorios").permitAll().
                // all other requests need to be authenticated
                anyRequest().authenticated().and().
                // make sure we use stateless session; session won't be used to
                // store user's state.
                exceptionHandling().authenticationEntryPoint(jwtAutentificacionDeEntrada).and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Add a filter to validate the tokens with every request
        httpSecurity.addFilterBefore(jwtFiltroPeticion, UsernamePasswordAuthenticationFilter.class);
    }
}
