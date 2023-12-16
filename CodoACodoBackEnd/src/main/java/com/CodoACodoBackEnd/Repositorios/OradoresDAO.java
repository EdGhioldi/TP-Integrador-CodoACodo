package com.CodoACodoBackEnd.Repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import com.CodoACodoBackEnd.Modelos.Orador;
import com.CodoACodoBackEnd.Servicios.SQLConection;

public class OradoresDAO {

	public static boolean ingresarOrador(Orador or) throws ClassNotFoundException
	{
		if(or==null)return false;
		String sqlQuery="insert into oradores (nombre,apellido,tema,fecha_alta,fecha_baja) values (?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps=SQLConection.getConnection().prepareStatement(sqlQuery);
			ps.setString(1,or.getNombre());
			ps.setString(2,or.getApellido());
			ps.setString(3,or.getTema());
			ps.setTimestamp(4, or.getFechaAlta());
			ps.setTimestamp(5, or.getFechaBaja());
			ps.executeUpdate();
			return true;
			}catch(SQLException e)
			{
				System.out.println("Hubo un error en la sentencia SQL.");
				e.printStackTrace();
				return false;
			}
	}
	
	public static boolean actualizarOrador(Orador or) throws ClassNotFoundException
	{
		String sqlQuery="update oradores set nombre=?,apellido=?,tema=?,fecha_alta=?,fecha_baja=? where id=?";
						
		PreparedStatement ps;
		try {
			ps=SQLConection.getConnection().prepareStatement(sqlQuery);
			ps.setString(1,or.getNombre());
			ps.setString(2,or.getApellido());
			ps.setString(3,or.getTema());
			ps.setTimestamp(4, or.getFechaAlta());
			ps.setTimestamp(5, or.getFechaBaja());
			ps.setInt(6, or.getId());
			ps.executeUpdate();
			return true;
			}catch(SQLException e)
			{
				System.out.println("Hubo un error en la sentencia SQL.");
				e.printStackTrace();
				return false;
			}
	}
	
	
	public static boolean eliminarOrador(int id) throws ClassNotFoundException
	{
		String sqlQuery="delete from oradores where id=?";
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
	
	
	
	
	public static Orador buscarPorId(int id) throws ClassNotFoundException
	{
		String sqlQuery="select * from oradores where id=?";
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps=SQLConection.getConnection().prepareStatement(sqlQuery);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			List<Orador> lOrador=crearOrador(rs);
			if(lOrador==null||lOrador.isEmpty())
				return null;
			else
				return lOrador.get(0);
		}catch(SQLException e)
		{
			System.out.println("Hubo un error en la sentencia SQL.");
			e.printStackTrace();
			return null;
		}
	}
	public static List<Orador> buscarTodos() throws ClassNotFoundException
	{
		 List<Orador> lOradores=new ArrayList<Orador>();
		String sqlQuery="select * from oradores";
		PreparedStatement ps;
		ResultSet rs;
		try {
		ps=SQLConection.getConnection().prepareStatement(sqlQuery);
		rs=ps.executeQuery();
		lOradores=(crearOrador(rs));
		return lOradores;
		}catch(SQLException e)
		{
			System.out.println("Hubo un error en la sentencia SQL.");
			e.printStackTrace();
			return null;
		}
	}
	
	private static List<Orador> crearOrador(ResultSet datos)
	{
		List<Orador> oradores= new ArrayList<Orador>();
		try 
		{
			while(datos.next())
			{
				int idO=datos.getInt("id");
				String nombre=datos.getString("nombre");
				String apellido=datos.getString("apellido");
				String tema=datos.getString("tema");
				Timestamp fechaAlta=datos.getTimestamp("fecha_alta");
				Timestamp fechaBaja=datos.getTimestamp("fecha_baja");
				Orador or= new Orador(idO, nombre, apellido, tema);
				or.setFechaAlta(fechaAlta);
				or.setFechaBaja(fechaBaja);
				oradores.add(or);
			}
			return oradores;
			
		}catch(SQLException e)
		{	
			System.out.println("Hubo un error en la sentencia SQL.");
			e.printStackTrace();
			return null;
		}
	}

}
