/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import mx.com.gm.service.PersonaService;
import org.springframework.web.bind.annotation.PostMapping;

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
    private PersonaService personaService;
    
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
        Iterable<Persona> personas = personaService.listarPersonas();
       
        model.addAttribute("personas", personas);         
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        model.addAttribute("persona", persona);
        log.info("Ejecutando el controlador Spring MVC");
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar (Persona persona){
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(Persona persona){
        personaService.guardar(persona);
        return "redirect:/mvc";
    }
    
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    
    @GetMapping("/eliminar/{idPersona}")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/mvc";
    }
    
}
