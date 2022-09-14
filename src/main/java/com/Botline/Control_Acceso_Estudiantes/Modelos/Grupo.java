package com.Botline.Control_Acceso_Estudiantes.Modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name = "Grupo")
public class Grupo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    @Column(name = "codigo",nullable = false, unique = true)
	private String codigo;

    @Column(name = "activo",nullable = false, unique = true)
	private Boolean activo;

    @Column(name = "date",nullable = false, unique = true)
	private int date;

	public Grupo() {
		this.activo = true;
	}
}



	