package com.Botline.Control_Acceso_Estudiantes.Servicios;

import java.util.List;
import com.Botline.Control_Acceso_Estudiantes.Modelos.RegistroEstudiantes;

public interface IregistroEstudianteServicio {
    public List<RegistroEstudiantes> listarTodosLosRegistros();
	
	public RegistroEstudiantes guardarRegistro(RegistroEstudiantes registro);
	
	public RegistroEstudiantes obtenerRegistroPorId(int id);
	
	public void eliminarRegistro(int id);

}

