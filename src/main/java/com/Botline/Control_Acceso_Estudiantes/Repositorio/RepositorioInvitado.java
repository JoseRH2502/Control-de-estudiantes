package com.Botline.Control_Acceso_Estudiantes.Repositorio;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Botline.Control_Acceso_Estudiantes.Modelos.Invitado;

@Repository
public interface RepositorioInvitado extends JpaRepository<Invitado, Integer> {
    List<Invitado> findByFecha(Date fecha);
    List<Invitado> findByCedula(int cedula);

    
}
