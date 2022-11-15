package com.Botline.Control_Acceso_Estudiantes.Controlador;



import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Botline.Control_Acceso_Estudiantes.Modelos.Estudiante;
import com.Botline.Control_Acceso_Estudiantes.Modelos.RegistroEstudiantes;
import com.Botline.Control_Acceso_Estudiantes.Servicios.IestudianteServicio;
import com.Botline.Control_Acceso_Estudiantes.Servicios.IinvitadoServicio;
import com.Botline.Control_Acceso_Estudiantes.Servicios.IregistroEstudianteServicio;

@Controller
public class ControladorRegistro {

    @Autowired
	private IregistroEstudianteServicio servicioRegistroEstudiante;

	@Autowired
    private IestudianteServicio servicioEstudiante;


	@GetMapping({ "/registro_estudiantes"}) //@GetMapping({ "/estudiantes"}) 
	public String listarRegistros(Model modelo) {
		modelo.addAttribute("registros", servicioRegistroEstudiante.listarTodosLosRegistros());
		return "registroEstudiantes"; 
	}

	@GetMapping({ "/registro_nuevo"})
	public String listarEstudiantes(Model modelo) {
		modelo.addAttribute("estudiantes", servicioEstudiante.listarTodosLosEstudiantes());
		return "registroManual"; 
	}


	@GetMapping("/registrarEstudiante/{id}")
	public String registrarEstudiante(@PathVariable int id, @ModelAttribute("estudiante") Estudiante estudiante,
			Model modelo) {
		Estudiante EstudianteExistente = servicioEstudiante.obtenerEstudiantePorId(id);
		
		Date fecha = new java.util.Date();

		Calendar calendario = Calendar.getInstance();
		int hora  = calendario.get(Calendar.HOUR_OF_DAY);
		int minutos = calendario.get(Calendar.MINUTE);
		RegistroEstudiantes registroEstudiantes = new RegistroEstudiantes(EstudianteExistente);
		
		registroEstudiantes.setHora(hora + ":" + minutos);
		registroEstudiantes.setFecha(fecha);
		servicioRegistroEstudiante.guardarRegistro(registroEstudiantes);
		return "redirect:/registro_estudiantes";
	}

	@GetMapping("/registro_estudiantes/{id}")
	public String eliminarRegsitro(@PathVariable int id) {
		servicioRegistroEstudiante.eliminarRegistro(id);
		return "redirect:/registro_estudiantes";
	}




}
