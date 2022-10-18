package com.Botline.Control_Acceso_Estudiantes.Modelos;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "registroInvitado")
public class RegistroInvitado {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "FK_invitado", updatable = false, nullable = false)
    private Invitado invitado;

    @Column(name = "fecha",nullable = false)
    private Date fecha;

 

}
