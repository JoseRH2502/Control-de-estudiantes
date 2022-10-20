package com.Botline.Control_Acceso_Estudiantes.Controlador;

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
	public String listarEstudiantes(Model modelo) {
		modelo.addAttribute("invitados", servicioInvitado.listarTodosLosiInvitados());
		return "invitados"; 
	}

	@GetMapping("/invitado_nuevo") //envío
	public String mostrarFormularioDeRegistrtarEstudiante(Model modelo) {
		Invitado invitado = new Invitado();
		modelo.addAttribute("invitado", invitado);
		return "crear_invitado";
	} //este
	
	@PostMapping("/invitados")  //traer 
	public String guardarEstudiante(@ModelAttribute("invitado") Invitado invitado) {
        servicioInvitado.guardarInvitado(invitado);

		return "redirect:/invitados";
	}


	@GetMapping("/invitado/{id}")
	public String eliminarEstudiante(@PathVariable int id) {
		servicioInvitado.eliminarInvitado(id);
		return "redirect:/invitados";
	}

}
