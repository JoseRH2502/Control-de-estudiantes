package com.Botline.Control_Acceso_Estudiantes.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Botline.Control_Acceso_Estudiantes.Modelos.Estudiante;
import com.Botline.Control_Acceso_Estudiantes.Repositorio.RepositorioEstudiante;
import com.Botline.Control_Acceso_Estudiantes.Servicios.IestudianteServicio;
import com.Botline.Control_Acceso_Estudiantes.Servicios.IgrupoServicio;


@Controller
public class ControladorEstudiante {
    @Autowired
	private IestudianteServicio servicioEstudiante;

	@Autowired
	private IgrupoServicio servicioGrupo;

	@Autowired
	private RepositorioEstudiante RepoEStudiante;

	@GetMapping({ "/estudiantes"})
	public String listarEstudiantes(Model modelo) {
		modelo.addAttribute("estudiantes", servicioEstudiante.listarTodosLosEstudiantes());
		return "estudiantes"; 
	}

	@GetMapping("/estudiantes_nuevo") //envío
	public String mostrarFormularioDeRegistrtarEstudiante(Model modelo) {
		Estudiante estudiante = new Estudiante();
		modelo.addAttribute("estudiante", estudiante);
		modelo.addAttribute("grupos", servicioGrupo.ListAllGrups());
		System.out.println(servicioGrupo.ListAllGrups());
		return "crear_estudiante";
	} //este
	
	@PostMapping("/estudiantes")  //traer 
	public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante, RedirectAttributes attribute , BindingResult result) {
		if (estudiante.getNombre() == "" || estudiante.getApellido1() == "" || estudiante.getApellido2() == "" || estudiante.getCedula() == 0 
			|| estudiante.getEmail() == "" || estudiante.getGrado() == ""){
			attribute.addFlashAttribute("error", "Es necesario llenar todos los campos");
			return "redirect:/estudiantes_nuevo";
		}

		if ( !RepoEStudiante.findByCedula(estudiante.getCedula()).isEmpty()){
			attribute.addFlashAttribute("error", "La cédula ya se encuentra en uso.");
			return "redirect:/estudiantes_nuevo";
		}

		servicioEstudiante.guardarEstudiante(estudiante);
		attribute.addFlashAttribute("success", "Estudiante creado con exito.");
		return "redirect:/estudiantes_nuevo";
	}

	@GetMapping("/estudiantes_codigo")
	public String listarEstudiante(Model modelo) {
		modelo.addAttribute("estudiantes", servicioEstudiante.listarTodosLosEstudiantes());
		return "generar_codigos"; 
	}

	@GetMapping("/asistencia")
	public String buscarEstudianteID(Model modelo) {
		modelo.addAttribute("estudiantes", servicioEstudiante.listarTodosLosEstudiantes());
		return "asistencia"; 
	}

	@GetMapping("/estudiantes/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable int id, Model modelo) {
		modelo.addAttribute("estudiante", servicioEstudiante.obtenerEstudiantePorId(id));
		return "editar_estudiante";
	}

	@GetMapping("/estudiantes/visualizar/{id}")
	public String mostrarCarneEstudiante(@PathVariable int id, Model modelo) {
		modelo.addAttribute("estudiante", servicioEstudiante.obtenerEstudiantePorId(id));
		return "carne_estudiante";
	}

	@PostMapping("/estudiantes/{id}")
	public String actualizarEstudiante(@PathVariable int id, @ModelAttribute("estudiante") Estudiante estudiante,
			Model modelo) {
		Estudiante estudianteExistente = servicioEstudiante.obtenerEstudiantePorId(id);
		estudianteExistente.setCedula(estudiante.getCedula());
		estudianteExistente.setNombre(estudiante.getNombre());
		estudianteExistente.setApellido1(estudiante.getApellido1());
        estudianteExistente.setApellido2(estudiante.getApellido2());
        //estudianteExistente.setSeccion(estudiante.getSeccion());
        estudianteExistente.setGrado(estudiante.getGrado());
		estudianteExistente.setEmail(estudiante.getEmail());
	
		servicioEstudiante.actualizarEstudiante(estudianteExistente);
		return "redirect:/estudiantes";
	}

	@GetMapping("/estudiantes/{id}")
	public String eliminarEstudiante(@PathVariable int id) {
		servicioEstudiante.eliminarEstudiante(id);
		return "redirect:/estudiantes";
	}
}
