package com.Botline.Control_Acceso_Estudiantes.Controlador;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.Botline.Control_Acceso_Estudiantes.Modelos.Estudiante;
import com.Botline.Control_Acceso_Estudiantes.Modelos.Grupo;
import com.Botline.Control_Acceso_Estudiantes.Modelos.RegistroEstudiantes;
import com.Botline.Control_Acceso_Estudiantes.Repositorio.RepositorioEstudiante;
import com.Botline.Control_Acceso_Estudiantes.Repositorio.RepositorioGrupo;
import com.Botline.Control_Acceso_Estudiantes.Repositorio.RepositorioRegistroEstudiante;
import com.Botline.Control_Acceso_Estudiantes.Servicios.IestudianteServicio;

import com.Botline.Control_Acceso_Estudiantes.Servicios.IregistroEstudianteServicio;

@Controller
public class ControladorRegistro {

    @Autowired
	private IregistroEstudianteServicio servicioRegistroEstudiante;

	@Autowired
    private IestudianteServicio servicioEstudiante;
	
	@Autowired
    private RepositorioEstudiante repoEstudiante;

	@Autowired
    private RepositorioRegistroEstudiante repoEstudianteRegistro;

	@Autowired
	private RepositorioGrupo repoGrupo; 


	private List<RegistroEstudiantes> consultas;


	@GetMapping({ "/registro_estudiantes"}) //@GetMapping({ "/estudiantes"}) 
	public String listarRegistros(Model modelo) {
		modelo.addAttribute("registros", servicioRegistroEstudiante.listarTodosLosRegistros());
		return "registroEstudiantes"; 
	}

	@GetMapping({ "/registroManual"})
	public String listarEstudiantes(Model modelo) {
		Estudiante estudiante = new Estudiante();
		modelo.addAttribute("estudiante", estudiante);
		return "registroManual"; 
	}


	@PostMapping("/registroManual")  //traer 
	public String guardarRegistro(@ModelAttribute("estudiante") Estudiante estudiante, RedirectAttributes attribute , BindingResult result) {
		System.out.println(estudiante);
		Date fecha = new java.util.Date();
		if (estudiante.getCedula() == 0){
				attribute.addFlashAttribute("error", "Es necesario llenar todos los campos");
				return "redirect:/registroManual";
		
		}

		if ( repoEstudiante.findByCedula(estudiante.getCedula() ).isEmpty()){
			attribute.addFlashAttribute("error", "Estudiante no encontrado en la base de datos.");
			return "redirect:/registroManual";
		}

		List<Estudiante> EstudianteExistente = repoEstudiante.findByCedula(estudiante.getCedula());

		estudiante = EstudianteExistente.get(0);

		if (!repoEstudianteRegistro.findByEstudianteIdAndFecha(estudiante.getId() , fecha ).isEmpty()){
			attribute.addFlashAttribute("error", "Estudiante ya cuenta con un ingreso el día de hoy.");
			return "redirect:/registroManual";
		}
		

		Calendar calendario = Calendar.getInstance();
		int hora  = calendario.get(Calendar.HOUR_OF_DAY);
		int minutos = calendario.get(Calendar.MINUTE);
		RegistroEstudiantes registroEstudiantes = new RegistroEstudiantes(estudiante);
		
		registroEstudiantes.setHora(hora + ":" + minutos);
		registroEstudiantes.setFecha(fecha);
		servicioRegistroEstudiante.guardarRegistro(registroEstudiantes);

		String mensaje = "Ingreso registrado de	 " + estudiante.getNombre() + " " + estudiante.getApellido1() + " " + estudiante.getApellido2();
		attribute.addFlashAttribute("success", mensaje);
		return "redirect:/registroManual";
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

	@GetMapping({ "/ConsultaDate"}) //@GetMapping({ "/estudiantes"}) 
	public String ConsultarFechaGet(Model modelo) {
		modelo.addAttribute("registros", consultas);
		return "registroEstudiantes"; 
	}


	@PostMapping("/ConsultaDate")  //traer 
	public String ConsultarFecha(@ModelAttribute("registro_estudiantes") RegistroEstudiantes resgistro, RedirectAttributes attribute , BindingResult result) {
		//Date fecha = new java.util.Date();
		consultas = new ArrayList<>();
		Date fecha = resgistro.getFecha();
		consultas = repoEstudianteRegistro.findByFecha(fecha);
		return "redirect:/ConsultaDate";
	}

	@PostMapping("/ConsultaPersona")  //traer 
	public String ConsultarPersona(@ModelAttribute("registro_estudiantes") Estudiante estudiante, RedirectAttributes attribute , BindingResult result) {
		consultas = new ArrayList<>();
		
		if (estudiante.getCedula() == 0){
			attribute.addFlashAttribute("error", "Es necesario llenar todos los campos");
			return "redirect:/ConsultaDate";
	
		}

		if ( repoEstudiante.findByCedula(estudiante.getCedula() ).isEmpty()){
			attribute.addFlashAttribute("error", "Estudiante no encontrado en la base de datos.");
			return "redirect:/ConsultaDate";
		}

		List<Estudiante> EstudianteExistente = repoEstudiante.findByCedula(estudiante.getCedula());
		estudiante = EstudianteExistente.get(0);
		consultas = repoEstudianteRegistro.findByEstudianteId(estudiante.getId());
		return "redirect:/ConsultaDate";
	}

	@GetMapping({ "/consultasGenerales"}) //@GetMapping({ "/estudiantes"}) 
	public String ConsultasGenerales(Model modelo) {
		modelo.addAttribute("registros", consultas);
		return "consultasGenerales"; 
	}

	@PostMapping("/Consultaestudiantesgrupo")  //traer 
	public String ConsultarestudianteGrup(@ModelAttribute("grupo") Grupo grupo, RedirectAttributes attribute , BindingResult result) {
		
		consultas = new ArrayList<>();

		if (grupo.getCodigo() == ""){
			attribute.addFlashAttribute("error", "Es necesario llenar todos los campos");
			return "redirect:/consultasGenerales";
	
		}
	
		List<Grupo> grupos = repoGrupo.findByCodigo(grupo.getCodigo());
		
		if (grupos.size()==0){
			attribute.addFlashAttribute("error", "Grupo Invalido");
			return "redirect:/consultasGenerales";
	
		}
		Grupo grupoExistente = grupos.get(0);
		List<Estudiante> estudiantesdelGrupo = repoEstudiante.findByGrupo(grupoExistente.getCodigo());

		for(int i=0; i< estudiantesdelGrupo.size();i++){
			consultas.addAll(repoEstudianteRegistro.findByEstudianteId(estudiantesdelGrupo.get(i).getId()));
		}
	
		return  "redirect:/consultasGenerales"; 
	}




	

	




}
