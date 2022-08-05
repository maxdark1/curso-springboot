/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.dao.PersonaDao;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;

/**
 *
 * @author juan.lara
 */

@Controller
@Slf4j
public class ControladorMVC {
    @Value("${index.saludo}")
    private String saludo;
    @Autowired
    private PersonaDao personaDao;
    
    @GetMapping("/mvc")
    public String inicio(Model model){
        String mensaje = "Hola Mundo Desde el Controllador";
    
        //Objeto Statico
        Persona persona = new Persona();
        persona.setNombre("Juan");
        persona.setApellido("Lara");
        persona.setEmail("max_lara3005@hotmail.com");
        persona.setTelefono("888888");
        persona.setIdPersona(Long.MIN_VALUE);
           
        //Extraer de base de datos
        Iterable<Persona> personas = personaDao.findAll();
        
       
        model.addAttribute("personas", personas);         
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        model.addAttribute("persona", persona);
        log.info("Ejecutando el controlador Spring MVC");
        return "index";
    }
    
}
