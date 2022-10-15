package com.Botline.Control_Acceso_Estudiantes.Controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Botline.Control_Acceso_Estudiantes.Modelos.Encargado;
import com.Botline.Control_Acceso_Estudiantes.Servicios.IEncargadoServicio;



@Controller
public class ControladorEncargados {
    
    //@Autowired
	//private IEncargadoServicio servicioEncargado;

	@GetMapping({ "/Nuevo encargado"})
	public String setEncargado(Model modelo) {
        Encargado encargado = new Encargado();
		modelo.addAttribute("encargado", encargado);
		return "newEncargado";
	}
}
