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
import mx.com.gm.domain.Persona;
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
    
    @GetMapping("/mvc")
    public String inicio(Model model){
        String mensaje = "Hola Mundo Desde el Controllador";
        
        Persona persona = new Persona();
        persona.setNombre("Juan");
        persona.setApellido("Perez");
        persona.setEmail("jperez@gmail.com");
        persona.setTelefono("554432");
        
        Persona persona2 = new Persona();
        persona2.setNombre("Que");
        persona2.setApellido("Hueva");
        persona2.setEmail("Me da");
        persona2.setTelefono("JAVA");
        
        List<Persona> personas = Arrays.asList(persona, persona2);
        //List<Persona> personas  = new ArrayList();
        model.addAttribute("personas", personas);
                
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        model.addAttribute("persona", persona);
        log.info("Ejecutando el controlador Spring MVC");
        return "index";
    }
    
}
