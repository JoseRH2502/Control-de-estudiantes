package com.Botline.Control_Acceso_Estudiantes.Repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Botline.Control_Acceso_Estudiantes.Modelos.Usuario;


@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Integer> {
    
    List<Usuario> findByCedula(int cedula);
    List<Usuario> findByEmail(String email);
    List<Usuario> findByEmailAndContrasena(String email, String contrasena);
}
