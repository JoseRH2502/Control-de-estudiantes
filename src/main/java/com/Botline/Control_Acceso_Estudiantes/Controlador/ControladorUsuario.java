package com.Botline.Control_Acceso_Estudiantes.Controlador;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Botline.Control_Acceso_Estudiantes.Modelos.Authority;
import com.Botline.Control_Acceso_Estudiantes.Modelos.Usuario;
import com.Botline.Control_Acceso_Estudiantes.Repositorio.RepositorioAuthority;
import com.Botline.Control_Acceso_Estudiantes.Repositorio.RepositorioUsuario;
import com.Botline.Control_Acceso_Estudiantes.Servicios.IAuthorityServicio;
import com.Botline.Control_Acceso_Estudiantes.Servicios.IusuarioServicio;


@Controller
public class ControladorUsuario {

    @Autowired
	private IusuarioServicio usuarioServicio;

	@Autowired
	private RepositorioAuthority rAuthority;

	@Autowired
	private RepositorioUsuario rUsuario;

	@Autowired
	private IAuthorityServicio authorityServicio;
	

	
	@GetMapping("/register") //mostrar los datos
	public String setUsuario(Model modelo) {
		Usuario usuario = new Usuario();
		modelo.addAttribute("usuario", usuario);
		modelo.addAttribute("authoritys", authorityServicio.ListAllAuthority());
		return "register";
	}

	@PostMapping("/register")  //traer 
	public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario, @ModelAttribute("authoritys") Authority authoritys, 
			@ModelAttribute("authorityX") String authority_id , RedirectAttributes attribute , BindingResult result) {

		if (usuario.getNombre() == "" || usuario.getApellido1() == ""  || usuario.getApellido2() == "" || usuario.getCedula() == 0 ||
				usuario.getContrasena() == "" || usuario.getEmail() == ""){
				attribute.addFlashAttribute("error", "Es necesario llenar todos los campos");
				return "redirect:/register";
		
		}

		if ( !rUsuario.findByCedula(usuario.getCedula()).isEmpty()){
			attribute.addFlashAttribute("error", "Cédula ya se encuentra en uso.");
			return "redirect:/register";
		}

		if ( !rUsuario.findByEmail(usuario.getEmail()).isEmpty()){
			attribute.addFlashAttribute("error", "Correo electrónico ya se encuentra en uso.");
			return "redirect:/register";
		}
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		usuario.setContrasena(bCryptPasswordEncoder.encode(usuario.getContrasena()));
		Set<Authority> authorityList = new HashSet < > (); 
		authorityList.add(rAuthority.findById(Long.parseLong(authority_id)));
		usuario.setAuthority(authorityList);
		usuarioServicio.guardarUsuario(usuario);

		attribute.addFlashAttribute("success", "Cuenta creada con exito.");

		return "redirect:/register";
	}

	@GetMapping("/consulta_usuarios")
	public String listUsers(Model modelo) {
		modelo.addAttribute("usuarios", usuarioServicio.ListAllUsers());
		return "consulta_usuarios"; 
	}
/* 
	@GetMapping("/login") //mostrar los datos
	public String setUsuarioLogin(Model modelo) {
		Usuario usuario = new Usuario();
		modelo.addAttribute("usuario", usuario);
		return "login";
	}
	
	@RequestMapping({"/login" , "/"})
	public String getLogin(Model model)  {
		return "login";
	}


	@GetMapping("/login/findByEmailAndContrasena")
		public ResponseEntity<List<Usuario>> getUsuarioByEmail(@RequestParam String email , String contrasena){
		return new ResponseEntity<List<Usuario>>( RepoUsuario.findByEmailAndContrasena(email, contrasena), HttpStatus.OK);
	}
*/
	/*
	 * 
	 * 	@GetMapping("/login/findByEmailAndContrasena")
		public ResponseEntity<List<Usuario>> getUsuarioByEmail(@RequestParam String email , String contrasena){
		return new ResponseEntity<List<Usuario>>( RepoUsuario.findByEmailAndContrasena(email, contrasena), HttpStatus.OK);
	}
	 * 
	 */
}
