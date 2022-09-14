package com.Botline.Control_Acceso_Estudiantes.Servicios;

import java.util.List;

import com.Botline.Control_Acceso_Estudiantes.Modelos.Grupo;

public interface IgrupoServicio {
	public Grupo saveGrupo(Grupo grupo);
    public List<Grupo> ListAllGrups();
}
