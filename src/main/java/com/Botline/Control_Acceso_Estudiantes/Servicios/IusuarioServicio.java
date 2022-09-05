package com.Botline.Control_Acceso_Estudiantes.Servicios;

import java.util.List;

import com.Botline.Control_Acceso_Estudiantes.Modelos.Usuario;

public interface IusuarioServicio {
    public List<Usuario> listarTodosLosUsuario();
	
	public Usuario guardarUsuario(Usuario usuario);
	
	public Usuario obtenerUsuarioPorId(int id);
	
	public Usuario actualizarUsuario(Usuario usuario);
	
	public void eliminarUsuario(int id);

}
