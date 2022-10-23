package com.Botline.Control_Acceso_Estudiantes.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Botline.Control_Acceso_Estudiantes.Modelos.Invitado;
import com.Botline.Control_Acceso_Estudiantes.Repositorio.RepositorioInvitado;

@Service
public class InvitadoServicio implements IinvitadoServicio{
    @Autowired
    private RepositorioInvitado repo;

   
    @Override
    public void eliminarInvitado(int id) {
        repo.deleteById(id);
        
    }

    @Override
    public Invitado guardarInvitado(Invitado invitado) {
       return repo.save(invitado);
    }

    @Override
    public List<Invitado> listarTodosLosiInvitados() {
       
        return repo.findAll();
    }

    @Override
    public Invitado obtenerInvitadoPorId(int id) {
        return repo.findById(id).get() ;
    }

    
}

