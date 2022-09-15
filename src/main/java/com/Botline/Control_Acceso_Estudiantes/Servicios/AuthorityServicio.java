package com.Botline.Control_Acceso_Estudiantes.Servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Botline.Control_Acceso_Estudiantes.Modelos.Authority;
import com.Botline.Control_Acceso_Estudiantes.Repositorio.RepositorioAuthority;


@Service
public class AuthorityServicio implements IAuthorityServicio {

    @Autowired
	private RepositorioAuthority repositorio;

    @Override
    public Authority saveAuthority(Authority authority) {
        return repositorio.save(authority);
    }

    @Override
    public List<Authority> ListAllAuthority(){
        return repositorio.findAll();
    }
    
}
