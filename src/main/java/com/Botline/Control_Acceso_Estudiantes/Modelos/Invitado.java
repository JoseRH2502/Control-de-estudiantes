package com.Botline.Control_Acceso_Estudiantes.Modelos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "invitado")
public class Invitado extends Persona {
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

    @OneToMany(mappedBy = "invitado", cascade = CascadeType.ALL)
    private List<RegistroInvitado> registros;

    public Invitado(){}
  
    public Invitado(int cedula, String nombre, String apellido1, String apellido2, String email, int cedula2,
            String nombre2, String apellido12, String apellido22) {
        super(cedula, nombre, apellido1, apellido2);
        cedula = cedula2;
        nombre = nombre2;
        apellido1 = apellido12;
        apellido2 = apellido22;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<RegistroInvitado> getRegistros() {
        return registros;
    }

    public void setRegistros(List<RegistroInvitado> registros) {
        this.registros = registros;
    }

    @Override
    public String toString() {
        return "Invitado [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido1=" + apellido1
                + ", apellido2=" + apellido2 + ", registros=" + registros + "]";
    }

    

  


    



}
