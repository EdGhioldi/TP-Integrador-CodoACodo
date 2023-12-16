package com.CodoACodoBackEnd.Repositorios;



import com.CodoACodoBackEnd.Modelos.Ticket;
import com.CodoACodoBackEnd.Servicios.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
public class TicketsDAO {

	
	public static boolean ingresarTicket(Ticket tk) throws ClassNotFoundException
	{
		if(tk==null) return false;
		String sqlQuery="insert into tickets (id_cliente,precio,fecha_compra,tipo_ticket,cantidad) values (?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps=SQLConection.getConnection().prepareStatement(sqlQuery);
			ps.setInt(1,tk.getIdCliente());
			ps.setFloat(2,tk.getPrecio());
			ps.setTimestamp(3, tk.getFechaCompra());
			ps.setInt(4,tk.getTipoTicket().ordinal());
			ps.setInt(5,tk.getCantidad());
			ps.executeUpdate();
			return true;
			}catch(SQLException e)
			{
				System.out.println("Hubo un error en la sentencia SQL.");
				e.printStackTrace();
				return false;
			}
	}
	
	public static boolean actualizarTicket(Ticket tk) throws ClassNotFoundException
	{
		String sqlQuery="update tickets set id_cliente=?,precio=?,fecha_compra=?,tipo_ticket=?,cantidad=? where id=?";
						
		PreparedStatement ps;
		try {
			ps=SQLConection.getConnection().prepareStatement(sqlQuery);
			ps.setInt(1,tk.getIdCliente());
			ps.setFloat(2,tk.getPrecio());
			ps.setTimestamp(3, tk.getFechaCompra());
			ps.setInt(4,tk.getTipoTicket().ordinal());
			ps.setInt(5,tk.getCantidad());
			ps.setInt(6,tk.getId());
			ps.executeUpdate();
			return true;
			}catch(SQLException e)
			{
				System.out.println("Hubo un error en la sentencia SQL.");
				e.printStackTrace();
				return false;
			}
	}
	
	public static boolean eliminarTicket(int id) throws ClassNotFoundException
	{
		String sqlQuery="delete from tickets where id=?";
		PreparedStatement ps;
		try {
			ps=SQLConection.getConnection().prepareStatement(sqlQuery);
			ps.setInt(1,id);
			ps.executeUpdate();
			return true;
			}catch(SQLException e)
			{
				System.out.println("Hubo un error en la sentencia SQL.");
				e.printStackTrace();
				return false;
			}
	}

	public static Ticket buscarPorId(int id) throws ClassNotFoundException
	{
		String sqlQuery="select * from tickets where id=?";
		PreparedStatement ps;
		ResultSet rs;
		try {
		ps=SQLConection.getConnection().prepareStatement(sqlQuery);
		ps.setInt(1, id);
		rs=ps.executeQuery();
		List<Ticket> lTicket=crearTicket(rs);
		if(lTicket==null||lTicket.isEmpty())
			return null;
		else
			return lTicket.get(0);
		
		}catch(SQLException e)
		{
			System.out.println("Hubo un error en la sentencia SQL.");
			e.printStackTrace();
			return null;
		}
	}
	
	public static Ticket buscarPorIdCliente(int id) throws ClassNotFoundException
	{
		String sqlQuery="select * from tickets where id_cliente=?";
		PreparedStatement ps;
		ResultSet rs;
		try {
		ps=SQLConection.getConnection().prepareStatement(sqlQuery);
		ps.setInt(1, id);
		rs=ps.executeQuery();
		return crearTicket(rs).get(0);
		
		}catch(SQLException e)
		{
			System.out.println("Hubo un error en la sentencia SQL.");
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	public static List<Ticket> buscarTodos() throws ClassNotFoundException
	{
		 List<Ticket> lTickets=new ArrayList<Ticket>();
		String sqlQuery="select * from tickets";
		PreparedStatement ps;
		ResultSet rs;
		try {
		ps=SQLConection.getConnection().prepareStatement(sqlQuery);
		rs=ps.executeQuery();
		lTickets=(crearTicket(rs));
		return lTickets;
		}catch(SQLException e)
		{
			System.out.println("Hubo un error en la sentencia SQL.");
			e.printStackTrace();
			return null;
		}
	}
	
	private static  List<Ticket> crearTicket(ResultSet datos)
	{
		 List<Ticket> tickets=new ArrayList<Ticket>();
		try 
		{
			while(datos.next())
			{
				int idTk=datos.getInt("id");
				int idC=datos.getInt("id_cliente");
				float precio=datos.getFloat("precio");
				Timestamp fechaCompra=datos.getTimestamp("fecha_compra");
				int tipoTk=datos.getInt("tipo_ticket");
				int Cantidad=datos.getInt("cantidad");
				Ticket tk=new Ticket(idTk, idC, precio, Ticket.getTipoTicketOfInt(tipoTk), Cantidad);
				tk.setFechaCompra(fechaCompra);
				tickets.add(tk);
			}
			return tickets;
		}catch(SQLException e)
		{	
			System.out.println("Hubo un error en la sentencia SQL.");
			e.printStackTrace();
			return null;
		}
	}
	
}
