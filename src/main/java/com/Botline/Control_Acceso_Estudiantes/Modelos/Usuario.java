package com.Botline.Control_Acceso_Estudiantes.Modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;
import javax.persistence.JoinColumn;

@Entity
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

    @Column
	private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="authorities_users",
    joinColumns=@JoinColumn(name="usuario_id"),
    inverseJoinColumns=@JoinColumn(name="authority_id"))
    private Set<Authority> authority;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Authority> getAuthority() {
        return authority;
    }

    public void setAuthority(Set<Authority> authority) {
        this.authority = authority;
    }
}
