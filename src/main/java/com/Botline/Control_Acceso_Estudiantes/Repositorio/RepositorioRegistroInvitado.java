package com.Botline.Control_Acceso_Estudiantes.Repositorio;

import org.springframework.stereotype.Repository;

import com.Botline.Control_Acceso_Estudiantes.Modelos.Invitado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioRegistroInvitado extends JpaRepository<RepositorioRegistroInvitado, Integer>{
    
}
