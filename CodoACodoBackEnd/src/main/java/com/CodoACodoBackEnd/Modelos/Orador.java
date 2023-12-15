package com.CodoACodoBackEnd.Modelos;

import java.sql.Timestamp;
import java.util.Calendar;

public class Orador {
	private int id;
	private String nombre;
	private String apellido;
	private String tema;
	private Timestamp fechaAlta;
	private Timestamp fechaBaja;
	
	 // Constructor
	public Orador(int id, String nombre, String apellido, String tema) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tema=tema;	
		Calendar cal= Calendar.getInstance();
		this.fechaAlta = new Timestamp(cal.getTimeInMillis());  // Setea la fecha al momento de instanciar el objeto.
	}
	
	// Getters y setters
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTema()
	{
		return this.tema;
	}
	public void setTema(String tema)
	{
		this.tema=tema;
	}
	public Timestamp getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Timestamp fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Timestamp getFechaBaja() {
		return fechaBaja;
	}
	public void setFechaBaja(Timestamp fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	public void setFechaBajaInstante() {
		Calendar cal= Calendar.getInstance();
		this.fechaBaja = new Timestamp(cal.getTimeInMillis()); // Permite setear la fecha de la baja al momento que se llama al metodo
	}
	public int getId() {
		return id;
	}
}
