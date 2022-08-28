package com.Botline.Control_Acceso_Estudiantes.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Botline.Control_Acceso_Estudiantes.Modelos.Estudiante;
import com.Botline.Control_Acceso_Estudiantes.Modelos.Registro;
import com.Botline.Control_Acceso_Estudiantes.Servicios.IregistroServicio;

@RestController
public class ControladorRegistro {

    /*@Autowired
	private IregistroServicio serviciosRegistro;
    
    @GetMapping("/registar")
	public String guardarRegistro() {
		
        Estudiante estudiante1 = new Estudiante(8455, "carlos", "marcos", "perez", "1-b", 1);
		Registro registro1 = new Registro(estudiante1);
        estudiante1.addRegistro(registro1);
        
		serviciosRegistro.guardarRegistro(registro1);
		return "Registro un estudiante";
	}*/


}
