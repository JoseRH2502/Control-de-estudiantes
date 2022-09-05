package com.Botline.Control_Acceso_Estudiantes.Modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id; 
    
    @Column(name = "username", nullable = false)
    String username;
    
    @Column(name = "contraseña", nullable = false)
    String contraseña;

    public Usuario() {
    }

    public Usuario( String username, String contraseña) {
        this.username = username;
        this.contraseña = contraseña;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Usuario [contraseña=" + contraseña + ", id=" + id + ", username=" + username + "]";
    }

    

    
}
