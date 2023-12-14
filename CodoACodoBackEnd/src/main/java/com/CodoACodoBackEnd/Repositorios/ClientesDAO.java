package com.CodoACodoBackEnd.Repositorios;


import com.CodoACodoBackEnd.Modelos.Cliente;
import com.CodoACodoBackEnd.Servicios.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
public class ClientesDAO {
	
	
	public static Cliente buscarPorId(int id) throws ClassNotFoundException
	{
		String sqlQuery="select * from clientes where id=?";
		PreparedStatement ps;
		ResultSet rs;
		try {
		ps=SQLConection.getConnection().prepareStatement(sqlQuery);
		ps.setInt(1,id);
		rs=ps.executeQuery();
		List<Cliente> lCliente=crearCliente(rs);
		if(lCliente==null||lCliente.isEmpty())
			return null;
		else
			return lCliente.get(0);
		
		}catch(SQLException e)
		{
			System.out.println("Hubo un error en la sentencia SQL.");
			e.printStackTrace();
			return null;
		}
	}
	public static Cliente buscarPorEmail(String email) throws ClassNotFoundException
	{
		String sqlQuery="select * from clientes where email=?";
		PreparedStatement ps;
		ResultSet rs;
		try {
		ps=SQLConection.getConnection().prepareStatement(sqlQuery);
		ps.setString(1, email);
		rs=ps.executeQuery();
		List<Cliente> lCliente=crearCliente(rs);
		if(lCliente==null||lCliente.isEmpty())
			return null;
		else
			return lCliente.get(0);
			
		}catch(SQLException e)
		{
			System.out.println("Hubo un error en la sentencia SQL.");
			e.printStackTrace();
			return null;
		}
	}
	public static boolean ingresarCliente(Cliente cl) throws ClassNotFoundException
	{
		String sqlQuery="insert into clientes (nombre,apellido,email,fecha_alta,fecha_baja) values (?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps=SQLConection.getConnection().prepareStatement(sqlQuery);
			ps.setString(1,cl.getNombre());
			ps.setString(2,cl.getApellido());
			ps.setString(3,cl.getEmail());
			ps.setTimestamp(4, cl.getFechaAlta());
			ps.setTimestamp(5, cl.getFechaBaja());
			ps.executeUpdate();
			return true;
			}catch(SQLException e)
			{
				System.out.println("Hubo un error en la sentencia SQL.");
				e.printStackTrace();
				return false;
			}
	}
	
	public static boolean actualizarCliente(Cliente cl) throws ClassNotFoundException
	{
		String sqlQuery="update clientes set nombre=?,apellido=?,email=?,fecha_alta=?,fecha_baja=? where id=?";
		
		PreparedStatement ps;
		try {
			ps=SQLConection.getConnection().prepareStatement(sqlQuery);
			ps.setString(1,cl.getNombre());
			ps.setString(2,cl.getApellido());
			ps.setString(3,cl.getEmail());
			ps.setTimestamp(4, cl.getFechaAlta());
			ps.setTimestamp(5, cl.getFechaBaja());
			ps.setInt(6, cl.getId());
			ps.executeUpdate();
			return true;
			}catch(SQLException e)
			{
				System.out.println("Hubo un error en la sentencia SQL.");
				e.printStackTrace();
				return false;
			}
	}
	
	public static boolean eliminarCliente(int id) throws ClassNotFoundException
	{
		String sqlQuery="delete from clientes where id=?";
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
	
	
	public static List<Cliente> buscarTodos() throws ClassNotFoundException
	{
		 List<Cliente> lClientes=new ArrayList<Cliente>();
		String sqlQuery="select * from clientes";
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps=SQLConection.getConnection().prepareStatement(sqlQuery);
			rs=ps.executeQuery();
			lClientes=(crearCliente(rs));
			return lClientes;
		}catch(SQLException e)
		{
			System.out.println("Hubo un error en la sentencia SQL.");
			e.printStackTrace();
			return null;
		}
	}
	
	private static List<Cliente> crearCliente(ResultSet datos)
	{
		List<Cliente> clientes= new ArrayList<Cliente>();
		try 
		{
			while(datos.next()) {
			int idC=datos.getInt("id");
			String nombre=datos.getString("nombre");
			String apellido=datos.getString("apellido");
			String email=datos.getString("email");
			Timestamp fechaAlta=datos.getTimestamp("fecha_alta");
			Timestamp fechaBaja=datos.getTimestamp("fecha_baja");
			Cliente cl= new Cliente(idC,nombre,apellido,email);
			cl.setFechaAlta(fechaAlta);
			cl.setFechaBaja(fechaBaja);
			clientes.add(cl);
			
		}
			return clientes;
		}catch(SQLException e)
		{	
			System.out.println("Hubo un error en la sentencia SQL.");
			e.printStackTrace();
			return null;
		}
	}

}
