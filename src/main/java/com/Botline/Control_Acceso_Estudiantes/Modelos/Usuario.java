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
@Table(name = "Usuarios")
public class Usuario extends Persona{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id; 
   
    @Column(name = "contrasena", nullable = false)
    String contrasena;

    @Column(name = "cedula",nullable = false, unique = true)
	private int cedula;
	
	@Column(name = "nombre",nullable = false,length = 50)
	private String nombre;
	
	@Column(name = "apellido1",nullable = false,length = 50)
	private String apellido1;

    @Column(name = "apellido2",nullable = false,length = 50)
	private String apellido2;

    @Column(name = "email",nullable = true,unique = true,length = 50)
	private String email;
   
}
