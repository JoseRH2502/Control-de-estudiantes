package com.Botline.Control_Acceso_Estudiantes.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Botline.Control_Acceso_Estudiantes.Modelos.Grupo;
import com.Botline.Control_Acceso_Estudiantes.Repositorio.RepositorioGrupo;
import com.Botline.Control_Acceso_Estudiantes.Servicios.IgrupoServicio;


@Controller
public class ControladorGrupos {

    @Autowired
    private IgrupoServicio servicioGrupo;

	@Autowired
	private RepositorioGrupo RepoGrupo;
    
	@GetMapping("/nuevo_grupo") //mostrar los datos
	public String setGrupo(Model modelo) {
		Grupo grupo = new Grupo();
		modelo.addAttribute("grupo", grupo);
		return "nuevo_grupo";
	}

	@PostMapping("/nuevo_grupo")  //traer 
	public String guardarGrupo(@ModelAttribute("grupo") Grupo grupo, RedirectAttributes attribute , BindingResult result) {
		if (grupo.getCodigo() == "" || grupo.getDate() == 0 ){
		attribute.addFlashAttribute("error", "Es necesario llenar todos los campos");
		return "redirect:/nuevo_grupo";

		}

		if ( !RepoGrupo.findByCodigoAndDate(grupo.getCodigo(), grupo.getDate()).isEmpty()){
			attribute.addFlashAttribute("error", "Código del grupo ya se encuentra en uso.");
			return "redirect:/nuevo_grupo";
		}

		servicioGrupo.saveGrupo(grupo);
		attribute.addFlashAttribute("success", "Grupo creado con exito.");
		return "redirect:/nuevo_grupo";
	}

	@GetMapping("/consulta_grupos")
	public String listGrupos(Model modelo) {
		modelo.addAttribute("grupos", servicioGrupo.ListAllGrups());
		return "consulta_grupos"; 
	}
}
