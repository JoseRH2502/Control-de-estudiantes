package com.Botline.Control_Acceso_Estudiantes.Controlador;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Botline.Control_Acceso_Estudiantes.Modelos.Invitado;
import com.Botline.Control_Acceso_Estudiantes.Servicios.IinvitadoServicio;

@Controller
public class ControladorInvitado {
  @Autowired
   private  IinvitadoServicio servicioInvitado;

   @GetMapping({ "/invitados"}) //@GetMapping({ "/estudiantes"}) 
	public String listarInvitados(Model modelo) {
		modelo.addAttribute("invitados", servicioInvitado.listarTodosLosiInvitados());
		return "invitados"; 
	}

	@GetMapping("/invitado_nuevo") //envío
	public String mostrarFormularioDeRegistrtarInvitado(Model modelo) {
		Invitado invitado = new Invitado();
		modelo.addAttribute("invitado", invitado);
		return "crear_invitado";
	} //este
	
	@PostMapping("/invitados")  //traer 
	public String guardarInvitado(@ModelAttribute("invitado") Invitado invitado) {
		// Deprecated
		Date fecha = new java.util.Date();
		invitado.setFecha(fecha);

		Calendar calendario = Calendar.getInstance();
		int hora  = calendario.get(Calendar.HOUR_OF_DAY);
		int minutos = calendario.get(Calendar.MINUTE);

		invitado.setHoraLlegada(hora + ":" + minutos);
        servicioInvitado.guardarInvitado(invitado);

	
		return "redirect:/invitados";
	}

	@GetMapping("/invitadoTerminar/{id}")
	public String actualizarInvitado(@PathVariable int id, @ModelAttribute("invitado") Invitado invitado,
			Model modelo) {
		Invitado invitadoExistente = servicioInvitado.obtenerInvitadoPorId(id);
		Calendar calendario = Calendar.getInstance();
		int hora  = calendario.get(Calendar.HOUR_OF_DAY);
		int minutos = calendario.get(Calendar.MINUTE);
		invitadoExistente.setHoraSalida(hora + ":" + minutos);
		servicioInvitado.guardarInvitado(invitadoExistente);
		return "redirect:/invitados";
	}



	@GetMapping("/invitado/{id}")
	public String eliminarInvitado(@PathVariable int id) {
		servicioInvitado.eliminarInvitado(id);
		return "redirect:/invitados";
	}

}
