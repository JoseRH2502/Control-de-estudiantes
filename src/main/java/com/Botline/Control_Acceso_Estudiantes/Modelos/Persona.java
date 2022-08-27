package com.Botline.Control_Acceso_Estudiantes.Modelos;

public abstract class Persona {
    private int cedula;
	private String nombre;
	private String apellido1;
	private String apellido2;

    public Persona() {
    }
    public Persona(int cedula, String nombre, String apellido1, String apellido2) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    public  abstract  int getCedula();
    public abstract void setCedula(int cedula);
    public abstract String getNombre();
    public abstract void setNombre(String nombre);
    public abstract String getApellido1();
    public abstract void setApellido1(String apellido1);
    public abstract String getApellido2();
    public abstract void setApellido2(String apellido2);
    
}

    

    
       

