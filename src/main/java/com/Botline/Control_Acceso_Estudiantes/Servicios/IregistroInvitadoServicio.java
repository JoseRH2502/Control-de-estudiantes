package com.Botline.Control_Acceso_Estudiantes.Servicios;

import java.util.List;

import com.Botline.Control_Acceso_Estudiantes.Modelos.RegistroInvitado;

public interface IregistroInvitadoServicio {
    public List<RegistroInvitado> listarTodosLosRegistros();
	
	public RegistroInvitado guardarRegistro(RegistroInvitado registro);
	
	public RegistroInvitado obtenerRegistroPorId(int id);
	
	public void eliminarRegistro(int id);
}
