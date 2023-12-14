package com.CodoACodoBackEnd.Servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.CodoACodoBackEnd.Repositorios.*;
import com.CodoACodoBackEnd.Modelos.Cliente;
import com.CodoACodoBackEnd.Modelos.Orador;
import com.CodoACodoBackEnd.Modelos.Ticket;
import com.CodoACodoBackEnd.Modelos.Ticket.TipoTicket;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
     
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = (String) request.getParameter("accion");
		RequestDispatcher rDp;
		if(accion!=null)
		switch(accion)
		{
		case "volver":
			rDp=request.getRequestDispatcher("Vistas/index.jsp");
			break;
		case "vistaCompra":
			rDp=request.getRequestDispatcher("Vistas/compraTickets.jsp");
			break;
		case "ingresarOrador":
			String nombreOrador=request.getParameter("inpNombre");
			String apellidoOrador=request.getParameter("inpApellido");
			String temario=request.getParameter("txtAreaTemario");
			try {
				if(OradoresDAO.ingresarOrador(new Orador(0,nombreOrador,apellidoOrador,temario)))
				{
					
					rDp= request.getRequestDispatcher("Vistas/PagExito.jsp");
				}
				else
				{
					rDp= request.getRequestDispatcher("Vistas/PagFracaso.jsp");
				}
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
				rDp=request.getRequestDispatcher("Vistas/index.jsp");
			}
			break;	
			
		case"comprarTicket":
			try {
				Cliente cliente=ClientesDAO.buscarPorEmail(request.getParameter("iptCorreo"));
				if(cliente==null)
				{
					String nombreCliente= request.getParameter("iptNombre");
					String apellidoCliente= request.getParameter("iptApellido");
					String correoCliente= request.getParameter("iptCorreo");
					cliente=new Cliente(0,nombreCliente,apellidoCliente,correoCliente);
					ClientesDAO.ingresarCliente(cliente);
				}
				cliente=ClientesDAO.buscarPorEmail(request.getParameter("iptCorreo"));
				if(cliente==null)
				{
					rDp= request.getRequestDispatcher("Vistas/PagFracaso.jsp");
					break;
				}
				int idCliente=cliente.getId();
				TipoTicket tipoTicket=Ticket.getTipoTicketOfInt(Integer.parseInt(request.getParameter("selCategoria")));
				float precio= Float.parseFloat(request.getParameter("iptPrecio"));
				int cantidad= Integer.parseInt(request.getParameter("iptCantidad"));
				Ticket tk= new Ticket(0,idCliente,precio,tipoTicket,cantidad);
				if(TicketsDAO.ingresarTicket(tk))
				{
					rDp= request.getRequestDispatcher("Vistas/PagExito.jsp");
				}
				else
				{
					rDp= request.getRequestDispatcher("Vistas/PagFracaso.jsp");
				}
			} catch (ClassNotFoundException e) {
				//mandar a pagina de error :D
				e.printStackTrace();
				rDp= request.getRequestDispatcher("Vistas/PagFracaso.jsp");
			}
			break;
		case "backOffice":
				rDp=request.getRequestDispatcher("Vistas/backOffice.jsp?mostrar="+request.getParameter("mostrar"));
			break;
		case "eliminar":
			String categoria=request.getParameter("categoria");
			int id=Integer.parseInt(request.getParameter("id"));
			try {
				switch(categoria)
				{
					case"cliente":
						if(ClientesDAO.eliminarCliente(id))
						{
							rDp= request.getRequestDispatcher("Vistas/PagExito.jsp");
						}
						else
						{
							rDp= request.getRequestDispatcher("Vistas/PagFracaso.jsp");
						}
							break;
				
					case"ticket":
						if(TicketsDAO.eliminarTicket(id))
						{
							rDp= request.getRequestDispatcher("Vistas/PagExito.jsp");
						}
						else
						{
							rDp= request.getRequestDispatcher("Vistas/PagFracaso.jsp");
						}
						break;
					case"orador":
						if(OradoresDAO.eliminarOrador(id))
						{
							rDp= request.getRequestDispatcher("Vistas/PagExito.jsp");
						}
						else
						{
							rDp= request.getRequestDispatcher("Vistas/PagFracaso.jsp");
						}
						break;
					default:
						rDp=request.getRequestDispatcher("Vistas/index.jsp");
						break;
				}
			} catch (ClassNotFoundException e) {
				rDp= request.getRequestDispatcher("Vistas/PagFracaso.jsp");
			}
			break;
			
		case "darBaja":
			 categoria=request.getParameter("categoria");
			 id=Integer.parseInt(request.getParameter("id"));
				try {
					switch(categoria)
					{
						case"cliente":
					
							Cliente cl= ClientesDAO.buscarPorId(id);
							cl.setFechaBajaInstante();
							if(ClientesDAO.actualizarCliente(cl))
							{
								rDp= request.getRequestDispatcher("Vistas/PagExito.jsp");
							}
							else
							{
								rDp= request.getRequestDispatcher("Vistas/PagFracaso.jsp");
							}
							break;
						case"orador":
							Orador or= OradoresDAO.buscarPorId(id);
							or.setFechaBajaInstante();
							if(OradoresDAO.actualizarOrador(or))
							{
								rDp= request.getRequestDispatcher("Vistas/PagExito.jsp");
							}
							else
							{
								rDp= request.getRequestDispatcher("Vistas/PagFracaso.jsp");
							}
							break;
							default:
								rDp=request.getRequestDispatcher("Vistas/index.jsp");
								break;
					}
				} catch (ClassNotFoundException e) {
					rDp= request.getRequestDispatcher("Vistas/PagFracaso.jsp");
				}
			break;
			default:
				rDp=request.getRequestDispatcher("Vistas/index.jsp");
				break;
		}
		else
		{
			rDp=request.getRequestDispatcher("Vistas/index.jsp");
		}
		
		rDp.forward(request, response);
		
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("por aca paso");
		doGet(request, response);
	}

}
