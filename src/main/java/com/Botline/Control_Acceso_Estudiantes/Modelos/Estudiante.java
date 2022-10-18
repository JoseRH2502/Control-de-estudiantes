package com.Botline.Control_Acceso_Estudiantes.Modelos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "estudiantes")
public class Estudiante extends Persona {

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

    /*@Column(name = "seccion",nullable = false,length = 50)
	private String seccion; */

    @Column(name = "grado",nullable = false)
	private int grado;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL)
    private List<RegistroEstudiantes> registros;

    
    @Column(name = "email",nullable = true, unique = true,length = 50)
	private String email;

    @OneToOne
    @JoinColumn(name = "FK_encargado", updatable = false, nullable = false)
    private Encargado encargado;
    
	public Estudiante() {
		
	}

    public Estudiante(int cedula, String nombre, String apellido1, String apellido2, String seccion, int grado, String email) {
        super();
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        //this.seccion = seccion;
        this.grado = grado;
        this.email = email;
    }

    public Estudiante(int id, int cedula, String nombre, String apellido1, String apellido2, String seccion, int grado, String email) {
        super();
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        //this.seccion = seccion;
        this.grado = grado;
        this.email = email;
    }


    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    /* 

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    } */

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    @Override
    public String toString() {
        return "Estudiante [apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", cedula=" + cedula + ", grado="
                + grado + ", nombre=" + nombre +  "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addRegistro(RegistroEstudiantes registro) {
        registros.add(registro);
        registro.setEstudiante(this);
    }

    public void removeRegistro(RegistroEstudiantes registro) {
        registros.remove(registro);
        registro.setEstudiante(null);
    }

    public List<RegistroEstudiantes> getRegistros() {
        return registros;
    }

    public void setRegistros(List<RegistroEstudiantes> registros) {
        this.registros = registros;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}



	