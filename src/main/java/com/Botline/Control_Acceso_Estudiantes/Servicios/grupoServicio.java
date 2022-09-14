package com.Botline.Control_Acceso_Estudiantes.Servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Botline.Control_Acceso_Estudiantes.Modelos.Grupo;
import com.Botline.Control_Acceso_Estudiantes.Repositorio.RepositorioGrupo;


@Service
public class grupoServicio implements IgrupoServicio {

    @Autowired
	private RepositorioGrupo repositorio;

    @Override
    public Grupo saveGrupo(Grupo grupo) {
        return repositorio.save(grupo);
    }

    @Override
    public List<Grupo> ListAllGrups(){
        return repositorio.findAll();
    }
    
}
