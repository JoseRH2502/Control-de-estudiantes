package com.Botline.Control_Acceso_Estudiantes.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Botline.Control_Acceso_Estudiantes.Modelos.RegistroEstudiantes;
import java.util.Date;
import java.util.List;
@Repository
public interface RepositorioRegistroEstudiante extends JpaRepository<RegistroEstudiantes, Integer> {
    List<RegistroEstudiantes> findByEstudianteIdAndFecha(int fk_estudiante, Date fecha);
    List<RegistroEstudiantes> findByFecha(Date fecha);
    List<RegistroEstudiantes> findByEstudianteId(int  fk_estudiante);
   
}
