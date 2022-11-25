package com.Botline.Control_Acceso_Estudiantes.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.Botline.Control_Acceso_Estudiantes.Modelos.Estudiante;
import com.Botline.Control_Acceso_Estudiantes.Modelos.Grupo;

@Repository
public interface RepositorioEstudiante extends JpaRepository<Estudiante, Integer>{
    List<Estudiante> findByCedula(int cedula);
    List<Estudiante> findByGrupo(String FK_grupo);

}