package com.Botline.Control_Acceso_Estudiantes.Repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Botline.Control_Acceso_Estudiantes.Modelos.Grupo;


@Repository
public interface RepositorioGrupo extends JpaRepository<Grupo, Integer> {
    List<Grupo> findByCodigoAndDate(String codigo, int date);
    List<Grupo> findByCodigo(String codigo);
}
