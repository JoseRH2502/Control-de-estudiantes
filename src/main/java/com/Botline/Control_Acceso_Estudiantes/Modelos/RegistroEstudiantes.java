package com.Botline.Control_Acceso_Estudiantes.Modelos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "registroEstudiante")
public class RegistroEstudiantes {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "FK_estudiante", updatable = false, nullable = false)
    private Estudiante estudiante;

    @Column(name = "fecha",nullable = false)
    private Date fecha;

    public RegistroEstudiantes() {
    }

    public RegistroEstudiantes(Estudiante estudiante) {
        this.estudiante = estudiante;
        this.fecha = new Date();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Registro [estudiante=" + estudiante + ", fecha=" + fecha + ", id=" + id + "]";
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    


}
