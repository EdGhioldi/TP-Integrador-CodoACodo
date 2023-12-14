package com.CodoACodoBackEnd.Modelos;

import java.sql.Timestamp;
import java.util.Calendar;


public class Cliente {
	private int id;
	private String nombre;
	private String apellido;
	private String email;
	private Timestamp fechaAlta;
	private Timestamp fechaBaja;
	
	
	// constructores, getters y setters
	
	public Cliente(int id, String nombre, String apellido, String email) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		Calendar cal= Calendar.getInstance();
		this.fechaAlta = new Timestamp(cal.getTimeInMillis());
	}
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Timestamp fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public void setFechaBaja(Timestamp fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	public Timestamp getFechaBaja() {
		return fechaBaja;
	}
	public void setFechaBajaInstante() {
		Calendar cal= Calendar.getInstance();
		this.fechaBaja = new Timestamp(cal.getTimeInMillis());
	}
	public int getId() {
		return id;
	}
	
}
