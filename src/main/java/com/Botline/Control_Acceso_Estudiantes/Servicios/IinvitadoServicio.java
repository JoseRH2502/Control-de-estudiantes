package com.Botline.Control_Acceso_Estudiantes.Servicios;

import java.util.List;

import com.Botline.Control_Acceso_Estudiantes.Modelos.Invitado;

public interface IinvitadoServicio {
    public List<Invitado> listarTodosLosiInvitados();
	
	public Invitado guardarInvitado(Invitado invitado);
	
	public Invitado obtenerInvitadoPorId(int id);
	
	public void eliminarInvitado(int id);
}
