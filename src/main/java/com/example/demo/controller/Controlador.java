package com.example.demo.controller;

import com.example.demo.clases.Clientes;
import com.example.demo.clases.Cotizacion;
import com.example.demo.clases.Usuario;
import com.example.demo.dao.ProspectoDao;
import com.example.demo.clases.Prospecto;
import com.example.demo.clases.Rol;
import com.example.demo.clases.Usu;
import com.example.demo.config.JwtTokenUtilidad;
import com.example.demo.dao.CotizacionDao;
import com.example.demo.dao.UsuarioDao;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dao.ClientesDao;
import com.example.demo.dao.RolDao;
import com.example.demo.dao.UsuDao;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class Controlador {
    @Autowired
    ProspectoDao prospectoDao;
    
    @Autowired
    CotizacionControlador cotizacionControlador;
    
    @Autowired
    ProspectosControlador prospectosControlador;
    
    @Autowired
    UsuarioControlador usuarioControlador;
    
    @Autowired
    UsuarioDao usuarioDao;
    
    @Autowired
    ClientesControlador clientesControlador;
    
    @Autowired
    ClientesDao clientesDao;
    
    @Autowired
    CotizacionDao cotizacionDao;
    
    @Autowired
    UsuDao usuDao;
    
    @Autowired
    RolDao rolDao;
    
    @Autowired
    private JwtTokenUtilidad jwtTokenUtil;
    
//    @CrossOrigin
//    @PostMapping("/obtenerUsuarioConToken")
//    public String listarProspecto(@RequestBody String nombre){
//        return jwtTokenUtil.getUsernameFromToken(nombre);
//    }
    
    @CrossOrigin
    @GetMapping("/listarProspectos")
    public List<Prospecto> listarProspecto(){
        return (List<Prospecto>) prospectosControlador.listar();
    }
    
    @CrossOrigin
    @PostMapping(value="/guardarProspecto", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void guardarProspecto(@RequestBody Prospecto prospecto){
        prospectosControlador.guardar(prospecto);
    }
    
    @CrossOrigin
    @PostMapping(value="/eliminarProspecto", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void eliminarProspecto(@RequestBody Prospecto prospecto){
        prospectosControlador.eliminar(prospecto);
    }
    
    @CrossOrigin
    @PostMapping(value="/editarProspecto", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void editarProspecto(@RequestBody Prospecto prospecto){
        prospectosControlador.guardar(prospecto);
    }
    
    
    //=========================================================================================================
    @CrossOrigin
    @GetMapping("/listarCotizaciones")
    public List<Cotizacion> listarCotizacion(){
        return cotizacionControlador.listarCotizacion();
    }
    
    @CrossOrigin
    @PostMapping(value="/guardarCotizacion", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void guardar(@RequestBody Cotizacion cotizacion){
        cotizacionControlador.guardar(cotizacion);
    }
    
    @CrossOrigin
    @PostMapping(value="/eliminarCotizacion", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void eliminarCotizacion(@RequestBody Cotizacion cotizacion){
        cotizacionControlador.eliminar(cotizacion);
    }

    @CrossOrigin
    @PostMapping(value="/listarCotizacionesPorUsuario", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Set<Cotizacion> listarCotizacionesPorUsuario(@RequestBody Usuario usuario){
        return usuarioControlador.listarCotizacionesPorUsuario(usuario);
    }
    
    @CrossOrigin
    @PostMapping(value="/listarCotizacionPorId", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cotizacion listarCotizacionPorId(@RequestBody Cotizacion cotizacion){
        return cotizacionControlador.listarCotizacionPorId(cotizacion);
    }
    
    @CrossOrigin
    @PostMapping(value="/listarCotizacionPorUsuarioNumero", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Cotizacion> listarCotizacionPorUsuarioNumero(@RequestBody Usuario usuario){
        return cotizacionControlador.listarCotizacionPorUsuario(usuario);
    }
    
    @CrossOrigin
    @PostMapping(value="/editarCotizacion", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void editarCotizacion(@RequestBody Cotizacion cotizacion){
        cotizacionControlador.guardar(cotizacion);
    }
    
    //=========================================================================================================
    
    @CrossOrigin
    @GetMapping("/listarClientes")
    public List<Clientes> listarClientes(){
        return clientesControlador.listar();
    }
    
    @CrossOrigin
    @PostMapping(value="/listarClientesPorUsuario", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Set<Clientes> listarCientesPorUsuario(@RequestBody Usuario usuario){
        return usuarioControlador.listarClientesPorUsuario(usuario);
    }
    
    @CrossOrigin
    @PostMapping(value="/guardarCliente", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void guardarClientes(@RequestBody Clientes clientes){
        System.out.println("hola");
        System.out.println("Hollaa");
        clientesControlador.guardar(clientes);
    }
    
    @CrossOrigin
    @PostMapping(value="/listarClientesPorId", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Clientes listarClientesPorId(@RequestBody Clientes clientes){
        return clientesControlador.listarClientesPorId(clientes);
    }
    @CrossOrigin
    @PostMapping(value="/editarClientes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void editarClientes(@RequestBody Clientes clientes){
        clientesControlador.guardar(clientes);
    }
    
    @CrossOrigin
    @PostMapping(value="/listarClientesPorUsuarioNumero", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Clientes> listarClientesPorUsuarioNumero(@RequestBody Usuario usuario){
        return clientesControlador.listarClientesPorUsuario(usuario);
    }
    
     //=========================================================================================================
    @CrossOrigin
    @PostMapping(value="/guardarUsuario", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void guardar(@RequestBody Usuario usuario){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        Usu usu = new Usu();
        usu.setUsername(usuario.getNumeroEmpleado());
        usu.setPassword(encoder.encode(usuario.getNumeroEmpleado()));
        
        Rol rol = new Rol();
        rol.setNombre("ROLE_USER");
        
        rol.setUsu(usu);
        usu.agregarRoles(rol);
        
        usuDao.save(usu);
        rolDao.save(rol);

        usuarioControlador.guardar(usuario);
    }
    
    @CrossOrigin
    @PostMapping(value="/editarUsuario", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void eitarUsuario(@RequestBody Usuario usuario){
        usuarioControlador.guardar(usuario);
    }
    
    @CrossOrigin
    @GetMapping("/listarUsuarios")
    public List<Usuario> listarUsuario(){
        return usuarioControlador.listarUsuario();
    }
    
    @CrossOrigin
    @PostMapping(value="/listarUsuarioPorId", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Usuario listarUsuarioPorId(@RequestBody Usuario usuario){
        return usuarioControlador.listarUsuarioPorId(usuario);
    }
    
    @CrossOrigin
    @PostMapping(value="/listarUsuarioPorNumeroEmpleado", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Usuario listarUsuarioPorNumeroEmpleado(@RequestBody Usuario usuario){

        return usuarioControlador.listarUsuarioPorNumeroEmpleado(usuario);
    }
    
    @CrossOrigin
    @PostMapping(value="/eliminarUsuario", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void eliminarUsuario(@RequestBody Usuario usuario){
        usuarioControlador.eliminarUsuario(usuario);
    }
    
    @CrossOrigin
    @GetMapping("/prueba")
    public void guardar(){
        Usuario usuario = usuarioDao.findByNumeroEmpleado("1122334");
        
        Clientes cliente = new Clientes();
        cliente.setNombre("Albano");
        cliente.setApellidoPaterno("Real");
        cliente.setApellidoMaterno("Rivera");
        cliente.setFechaNacimiento(new Date());
        cliente.setPaqueteContratado("Internet 20 megas");
        cliente.setPrimerPago(false);
        cliente.setSegundoPago(false);
        
        Clientes cliente2 = new Clientes();
        cliente2.setNombre("Edgar");
        cliente2.setApellidoPaterno("Rocha");
        cliente2.setApellidoMaterno("Espinoza");
        cliente2.setFechaNacimiento(new Date());
        cliente2.setPaqueteContratado("Internet 20 megas");
        cliente2.setPrimerPago(false);
        cliente2.setSegundoPago(false);
        
        cliente.setUsuario(usuario);
        cliente2.setUsuario(usuario);
        
        usuario.agregarClientes(cliente);
        usuario.agregarClientes(cliente2);
        
        usuarioDao.save(usuario);
        clientesDao.save(cliente);
        clientesDao.save(cliente2);
        
//        x.agregarCliente(cliente);
//        cliente.setUsuario(x);
////        
//        usuarioDao.save(x);
//        clienteDao.save(cliente);

//        Usuario x = usuarioDao.findById(8L).get();
//        System.out.println(x.getNombre());
//        Set<Cliente> usu = x.getCliente();
//        System.out.println(usu.size());
        
//        Set<Cliente> equis = usuarioDao.findById(8L).get().getCliente();
//        for (Cliente equi : equis) {
//            System.out.println(equi.getIdCliente());
//        }

        //System.out.println(usu.getCliente());
        
        
        
//        Usuario usuario = new Usuario();
//        usuario.setNombre("Albano");
//        usuario.setApellidoPaterno("Rocha");
//        usuario.setApellidoMaterno("Espinoza");
//        usuario.setNumeroEmpleado("1733044");
//        usuario.setFechaNacimiento(new Date());
//        usuario.setCliente(new HashSet<Cliente>());
//        System.out.println(usuario.getNombre());
//        usuarioControlador.guardar(usuario);
        
        
    }
   
}
