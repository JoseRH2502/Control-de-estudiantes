package com.Botline.Control_Acceso_Estudiantes.Repositorio;

import org.springframework.stereotype.Repository;
import com.Botline.Control_Acceso_Estudiantes.Modelos.RegistroInvitado;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface RepositorioRegistroInvitado extends JpaRepository<RegistroInvitado, Integer>{
    
}
