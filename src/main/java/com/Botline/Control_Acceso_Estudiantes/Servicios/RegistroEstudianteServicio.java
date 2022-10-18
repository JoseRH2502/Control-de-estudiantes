package com.Botline.Control_Acceso_Estudiantes.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Botline.Control_Acceso_Estudiantes.Modelos.RegistroEstudiantes;

import com.Botline.Control_Acceso_Estudiantes.Repositorio.RepositorioRegistroEstudiante;

@Service
public class RegistroEstudianteServicio implements IregistroEstudianteServicio{

    @Autowired
	private RepositorioRegistroEstudiante repositorio;

    @Override
    public void eliminarRegistro(int id) {
       repositorio.deleteById(id);
        
    }

    @Override
    public RegistroEstudiantes guardarRegistro(RegistroEstudiantes registro) {
       return repositorio.save(registro);
    }

    @Override
    public List<RegistroEstudiantes> listarTodosLosRegistros() {
       return repositorio.findAll();
    }

    @Override
    public RegistroEstudiantes obtenerRegistroPorId(int id) {
        return repositorio.findById(id).get();
    }
    
}
