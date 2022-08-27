package com.Botline.Control_Acceso_Estudiantes.Servicios;

import com.Botline.Control_Acceso_Estudiantes.Modelos.Estudiante;

import java.util.List;

public interface IestudianteServicio {
    public List<Estudiante> listarTodosLosEstudiantes();
	
	public Estudiante guardarEstudiante(Estudiante estudiante);
	
	public Estudiante obtenerEstudiantePorId(int id);
	
	public Estudiante actualizarEstudiante(Estudiante estudiante);
	
	public void eliminarEstudiante(int id);
}
