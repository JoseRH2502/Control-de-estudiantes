package com.Botline.Control_Acceso_Estudiantes.Servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Botline.Control_Acceso_Estudiantes.Modelos.Usuario;
import com.Botline.Control_Acceso_Estudiantes.Repositorio.RepositorioUsuario;

@Service
public class UsuarioServicio implements IusuarioServicio {

    @Autowired
	private RepositorioUsuario repositorio;

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        return repositorio.save(usuario);
    }

    @Override
    public void eliminarUsuario(int id) {
       repositorio.deleteById(id); 
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return repositorio.save(usuario);
    }

    @Override
    public List<Usuario> listarTodosLosUsuario() {
        return repositorio.findAll();
    }

    @Override
    public Usuario obtenerUsuarioPorId(int id) {
        return repositorio.findById(id).get();
    }
   
    
}
