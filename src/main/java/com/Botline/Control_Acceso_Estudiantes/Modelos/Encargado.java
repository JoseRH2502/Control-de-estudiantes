package com.Botline.Control_Acceso_Estudiantes.Modelos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


import lombok.Data;

@Data
@Entity
@Table(name = "encargados")
public class Encargado{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    @Column(name = "cedula",nullable = false, unique = true)
	private int cedula;
	
	@Column(name = "nombre",nullable = false,length = 50)
	private String nombre;
	
	@Column(name = "apellido1",nullable = false,length = 50)
	private String apellido1;

    @Column(name = "apellido2",nullable = false,length = 50)
	private String apellido2;

    @OneToMany(mappedBy = "encargado", cascade = CascadeType.ALL)
    private List<Estudiante> estudiantes;

    @Column(name = "email",nullable = true, unique = true,length = 50)
	private String email;

	public Encargado() {
		
	}

}