package com.Botline.Control_Acceso_Estudiantes.Modelos;




import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.type.TimeType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "invitado")
public class Invitado extends Persona {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    @Column(name = "cedula",nullable = false)
	private int cedula;
	
	@Column(name = "nombre",nullable = false,length = 50)
	private String nombre;
	
	@Column(name = "apellido1",nullable = false,length = 50)
	private String apellido1;

    @Column(name = "apellido2",nullable = false,length = 50)
	private String apellido2;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    @Column(name = "fecha",nullable = true)
    private Date fecha;

    @Column(name = "horaLlegada",nullable = true, length = 50)
    private String horaLlegada;

    @Column(name = "horaSalida",nullable = true, length = 50)
    private String horaSalida;

    public Invitado(){}
  
    public Invitado(int cedula, String nombre, String apellido1, String apellido2) {
        super();
        this.cedula = cedula;
        this. nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        fecha = null;
        horaLlegada = " ";
        horaSalida = " ";
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    


 

    

   
 

    

  


    



}
