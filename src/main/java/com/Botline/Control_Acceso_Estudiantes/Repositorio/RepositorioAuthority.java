package com.Botline.Control_Acceso_Estudiantes.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Botline.Control_Acceso_Estudiantes.Modelos.Authority;

@Repository
public interface RepositorioAuthority extends JpaRepository<Authority, Integer>{
    Authority findById(Long id);
}