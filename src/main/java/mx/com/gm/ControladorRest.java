/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author juan.lara
 */
@RestController
@Slf4j
public class ControladorRest {
    
    //Rest controller
    @GetMapping("/")
    public String inicio(){
        log.info("Ejecutando el controlador REST");
        log.debug("mas detalle del controlador");
        return "HolaMundo con Spring Boot";
    }
    
}
