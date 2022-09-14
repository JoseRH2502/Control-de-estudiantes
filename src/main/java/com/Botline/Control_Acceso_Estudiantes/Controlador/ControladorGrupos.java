package com.Botline.Control_Acceso_Estudiantes.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Botline.Control_Acceso_Estudiantes.Modelos.Grupo;
import com.Botline.Control_Acceso_Estudiantes.Servicios.IgrupoServicio;


@Controller
public class ControladorGrupos {

    @Autowired
    private IgrupoServicio servicioGrupo;
    
	@GetMapping("/nuevo_grupo") //mostrar los datos
	public String setGrupo(Model modelo) {
		Grupo grupo = new Grupo();
		modelo.addAttribute("grupo", grupo);
		return "nuevo_grupo";
	}

	@PostMapping("/nuevo_grupo")  //traer 
	public String guardarGrupo(@ModelAttribute("grupo") Grupo grupo) {
		servicioGrupo.saveGrupo(grupo);
		return "redirect:/nuevo_grupo";
	}

	@GetMapping("/consulta_grupos")
	public String listGrupos(Model modelo) {
		modelo.addAttribute("grupos", servicioGrupo.ListAllGrups());
		return "consulta_grupos"; 
	}
}
