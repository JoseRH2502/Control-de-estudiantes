package com.Botline.Control_Acceso_Estudiantes.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Botline.Control_Acceso_Estudiantes.Servicios.IestudianteServicio;



@Controller
public class ControladorUsuario {

    @Autowired
	private IestudianteServicio servicioEstudiante;


    @GetMapping("/iniciarSesion")
	public String formularioIniciarSesion(Model modelo) {
        modelo.addAttribute("estudiantes", servicioEstudiante.listarTodosLosEstudiantes());
		return "IniciarSesion";
	}

	@GetMapping("/iniciarSesion2")
	public String formularioIniciarSesion2(Model modelo) {
        modelo.addAttribute("estudiantes", servicioEstudiante.listarTodosLosEstudiantes());
		return "IniciarSesion2";
	}


	@GetMapping("/login")
	public String formularioIniciarSesion3(Model modelo) {
        modelo.addAttribute("estudiantes", servicioEstudiante.listarTodosLosEstudiantes());
		return "login";
	}



}