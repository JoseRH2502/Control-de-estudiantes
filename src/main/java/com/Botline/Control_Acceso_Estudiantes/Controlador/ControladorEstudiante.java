package com.Botline.Control_Acceso_Estudiantes.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Botline.Control_Acceso_Estudiantes.Modelos.Estudiante;
import com.Botline.Control_Acceso_Estudiantes.Servicios.IestudianteServicio;


@Controller
public class ControladorEstudiante {
    @Autowired
	private IestudianteServicio servicioEstudiante;


	@GetMapping({ "/estudiantes", "/" })
	public String listarEstudiantes(Model modelo) {
		modelo.addAttribute("estudiantes", servicioEstudiante.listarTodosLosEstudiantes());
		return "estudiantes"; 
	}

	@GetMapping("/estudiantes/nuevo")
	public String mostrarFormularioDeRegistrtarEstudiante(Model modelo) {
		Estudiante estudiante = new Estudiante();
		modelo.addAttribute("estudiante", estudiante);
		return "crear_estudiante";
	}

	@PostMapping("/estudiantes")
	public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
		servicioEstudiante.guardarEstudiante(estudiante);
		return "redirect:/estudiantes";
	}

	@GetMapping("/estudiantes/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable int id, Model modelo) {
		modelo.addAttribute("estudiante", servicioEstudiante.obtenerEstudiantePorId(id));
		return "editar_estudiante";
	}

	@PostMapping("/estudiantes/{id}")
	public String actualizarEstudiante(@PathVariable int id, @ModelAttribute("estudiante") Estudiante estudiante,
			Model modelo) {
		Estudiante estudianteExistente = servicioEstudiante.obtenerEstudiantePorId(id);
		estudianteExistente.setCedula(estudiante.getCedula());
		estudianteExistente.setNombre(estudiante.getNombre());
		estudianteExistente.setApellido1(estudiante.getApellido1());
        estudianteExistente.setApellido2(estudiante.getApellido2());
        estudianteExistente.setSeccion(estudiante.getSeccion());
        estudianteExistente.setGrado(estudiante.getGrado());
	
		servicioEstudiante.actualizarEstudiante(estudianteExistente);
		return "redirect:/estudiantes";
	}

	@GetMapping("/estudiantes/{id}")
	public String eliminarEstudiante(@PathVariable int id) {
		servicioEstudiante.eliminarEstudiante(id);
		return "redirect:/estudiantes";
	}
	
	

    
}
