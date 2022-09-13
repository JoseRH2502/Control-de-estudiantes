package com.Botline.Control_Acceso_Estudiantes.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorLogin {
    
    @GetMapping({"/login","/"})
    public String muestraLoginPropio(){
        return "login";
    }

    @GetMapping("/menu_principal")
    public String muestraMenuPrincipal(){
        return "menu_principal";
    }
}
