package com.Botline.Control_Acceso_Estudiantes.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Botline.Control_Acceso_Estudiantes.Modelos.Registro;

import com.Botline.Control_Acceso_Estudiantes.Repositorio.RepositorioRegistro;


public class RegistroServicio implements IregistroServicio{

    @Autowired
	private RepositorioRegistro repositorio;

    @Override
    public void eliminarRegistro(int id) {
       repositorio.deleteById(id);
        
    }

    @Override
    public Registro guardarRegistro(Registro registro) {
       return repositorio.save(registro);
    }

    @Override
    public List<Registro> listarTodosLosRegistros() {
       return repositorio.findAll();
    }

    @Override
    public Registro obtenerRegistroPorId(int id) {
        return repositorio.findById(id).get();
    }
    
}
