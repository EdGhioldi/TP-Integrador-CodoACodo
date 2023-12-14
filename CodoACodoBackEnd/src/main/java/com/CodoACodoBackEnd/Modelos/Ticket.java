package com.CodoACodoBackEnd.Modelos;

import java.sql.Timestamp;
import java.util.Calendar;

public class Ticket {
	public enum TipoTicket{ESTUDIANTE,TRAINEE,JUNIOR}

	private int id;
	private int idCliente;
	private float precio;
	private Timestamp fechaCompra;
	private TipoTicket tipoTicket;
	private int cantidad;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 // constructores, getters y setters
	public Ticket(int id, int idCliente, float precio, TipoTicket tipoTicket, int cantidad) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.precio = precio;
		this.tipoTicket = tipoTicket;
		this.cantidad = cantidad;
		Calendar cal= Calendar.getInstance();
		this.fechaCompra = new Timestamp(cal.getTimeInMillis());
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Timestamp getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Timestamp fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public TipoTicket getTipoTicket() {
		return tipoTicket;
	}
	public static TipoTicket getTipoTicketOfInt(int i) {
				switch(i)
				{
				case 1:
					return TipoTicket.TRAINEE;
				
				case 2:
					return TipoTicket.JUNIOR;
				default:
						return TipoTicket.ESTUDIANTE;
				}
		
	}


	public void setTipoTicket(TipoTicket tipoTicket) {
		this.tipoTicket = tipoTicket;
	}

	
	
	
	
	
	
	
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getId() {
		return id;
	}
	
	
	
	
	
	
	
}
