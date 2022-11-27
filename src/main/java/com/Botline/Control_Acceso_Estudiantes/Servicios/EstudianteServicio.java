package com.Botline.Control_Acceso_Estudiantes.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Botline.Control_Acceso_Estudiantes.Modelos.Estudiante;
import com.Botline.Control_Acceso_Estudiantes.Repositorio.RepositorioEstudiante;

@Service
public class EstudianteServicio implements IestudianteServicio {

    @Autowired
	private RepositorioEstudiante repositorio;

    @Override
    public Estudiante actualizarEstudiante(Estudiante estudiante) {
        return repositorio.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(int id) {
        repositorio.deleteById(id);
        
    }

    @Override
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return repositorio.save(estudiante);
    }

    @Override
    public List<Estudiante> listarTodosLosEstudiantes() {
        return repositorio.findAll();
    }
    


    @Override
    public Estudiante obtenerEstudiantePorId(int id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Estudiante obtenerEstudiantePorCedula(int cedula) {
        return repositorio.findById(cedula).get();
    }
    
}
