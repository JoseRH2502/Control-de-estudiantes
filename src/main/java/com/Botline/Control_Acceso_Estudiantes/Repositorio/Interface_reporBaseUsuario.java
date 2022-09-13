package com.Botline.Control_Acceso_Estudiantes.Repositorio;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Botline.Control_Acceso_Estudiantes.Modelos.Usuario;

@Repository
public interface Interface_reporBaseUsuario extends CrudRepository<Usuario, Long>  {
    public Optional<Usuario> findByEmail(String email);
}