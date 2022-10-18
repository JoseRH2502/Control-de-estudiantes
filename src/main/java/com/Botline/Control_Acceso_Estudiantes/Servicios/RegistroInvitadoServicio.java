package com.Botline.Control_Acceso_Estudiantes.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Botline.Control_Acceso_Estudiantes.Modelos.RegistroInvitado;
import com.Botline.Control_Acceso_Estudiantes.Repositorio.RepositorioRegistroInvitado;

@Service
public class RegistroInvitadoServicio implements IregistroInvitadoServicio {
    @Autowired
	private RepositorioRegistroInvitado repositorio;

    @Override
    public void eliminarRegistro(int id) {
        repositorio.deleteById(id);
        
    }

    @Override
    public RegistroInvitado guardarRegistro(RegistroInvitado registro) {
        return repositorio.save(registro);
    }

    @Override
    public List<RegistroInvitado> listarTodosLosRegistros() {
        
        return repositorio.findAll();
    }

    @Override
    public RegistroInvitado obtenerRegistroPorId(int id) {
        return repositorio.findById(id).get();
    }


}
