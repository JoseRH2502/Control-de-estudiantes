package com.Botline.Control_Acceso_Estudiantes.Controlador;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;

import com.Botline.Control_Acceso_Estudiantes.Modelos.Authority;
import com.Botline.Control_Acceso_Estudiantes.Modelos.Usuario;
import com.Botline.Control_Acceso_Estudiantes.Repositorio.RepositorioAuthority;
import com.Botline.Control_Acceso_Estudiantes.Repositorio.RepositorioUsuario;
import com.Botline.Control_Acceso_Estudiantes.Servicios.IAuthorityServicio;
import com.Botline.Control_Acceso_Estudiantes.Servicios.IestudianteServicio;
import com.Botline.Control_Acceso_Estudiantes.Servicios.IusuarioServicio;


@Controller
public class ControladorUsuario {

    @Autowired
	private IusuarioServicio usuarioServicio;

	@Autowired
	private RepositorioAuthority rAuthority;

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
	public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario, @ModelAttribute("authoritys") Authority authoritys
	, @ModelAttribute("authorityX") String authority_id) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		usuario.setContrasena(bCryptPasswordEncoder.encode(usuario.getContrasena()));
		//List<Authority> authorityList = new ArrayList<Authority>(); 
		Set<Authority> authorityList = new HashSet < > (); 
		authorityList.add(rAuthority.findById(Long.parseLong(authority_id)));
		usuario.setAuthority(authorityList);
		usuarioServicio.guardarUsuario(usuario);
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
