package com.Botline.Control_Acceso_Estudiantes.Servicios;

import java.util.List;

import com.Botline.Control_Acceso_Estudiantes.Modelos.Authority;

public interface IAuthorityServicio {
    public List<Authority> ListAllAuthority();
    public Authority saveAuthority(Authority authority);
}
