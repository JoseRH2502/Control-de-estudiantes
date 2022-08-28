package com.Botline.Control_Acceso_Estudiantes.Servicios;

import java.util.List;
import com.Botline.Control_Acceso_Estudiantes.Modelos.Registro;

public interface IregistroServicio {
    public List<Registro> listarTodosLosRegistros();
	
	public Registro guardarRegistro(Registro registro);
	
	public Registro obtenerRegistroPorId(int id);
	
	public void eliminarRegistro(int id);
}
