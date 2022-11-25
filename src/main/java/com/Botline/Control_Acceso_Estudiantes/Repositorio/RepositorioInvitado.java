package com.Botline.Control_Acceso_Estudiantes.Repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Botline.Control_Acceso_Estudiantes.Modelos.Invitado;

@Repository
public interface RepositorioInvitado extends JpaRepository<Invitado, Integer> {
    List<Invitado> findBycedula(int cedula); 
    List<Invitado> findByfecha(Date fecha); 
}
