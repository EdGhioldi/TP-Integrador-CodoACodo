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
		
		String accion = request.getParameter("accion");
		RequestDispatcher rDp;
		if(accion!=null)
		switch(accion)
		{
		case "volver":
			String pagAnterior=request.getParameter("pagAnterior");
			String mostrarTabla=request.getParameter("mostrar");
			if(pagAnterior!=null &&!pagAnterior.equals("null"))
			{
				if(mostrarTabla==null||mostrarTabla.equals("null"))
					rDp=request.getRequestDispatcher("Vistas/"+pagAnterior);
				else
					rDp=request.getRequestDispatcher("Vistas/"+pagAnterior+"?mostrar="+mostrarTabla);
			}
			else
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
					rDp= request.getRequestDispatcher("Vistas/pagExito.jsp");
				}
				else
				{
					rDp= request.getRequestDispatcher("Vistas/pagFracaso.jsp?causa=Error al ingresar el orador");
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
					rDp= request.getRequestDispatcher("Vistas/pagFracaso.jsp?pagAnterior=compraTickets.jsp");
					break;
				}
				int idCliente=cliente.getId();
				TipoTicket tipoTicket=Ticket.getTipoTicketOfInt(Integer.parseInt(request.getParameter("selCategoria")));
				float precio= Float.parseFloat(request.getParameter("iptPrecio"));
				int cantidad= Integer.parseInt(request.getParameter("iptCantidad"));
				Ticket tk= new Ticket(0,idCliente,precio,tipoTicket,cantidad);
				if(TicketsDAO.ingresarTicket(tk))
				{
					rDp= request.getRequestDispatcher("Vistas/pagExito.jsp?pagAnterior=compraTickets.jsp");
				}
				else
				{
					rDp= request.getRequestDispatcher("Vistas/pagFracaso.jsp?pagAnterior=compraTickets.jsp&causa=Error al ingresar la compra");
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				rDp= request.getRequestDispatcher("Vistas/pagFracaso.jsp?pagAnterior=compraTickets.jsp&causa=Error conexion con la base de datos");
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
							rDp= request.getRequestDispatcher("Vistas/pagExito.jsp?pagAnterior=backOffice.jsp&mostrar=clientes");
						}
						else
						{
							rDp= request.getRequestDispatcher("Vistas/pagFracaso.jsp?pagAnterior=backOffice.jsp&mostrar=clientes&causa=Error al borrar el registro del cliente");
						}
							break;
				
					case"ticket":
						if(TicketsDAO.eliminarTicket(id))
						{
							rDp= request.getRequestDispatcher("Vistas/pagExito.jsp?pagAnterior=backOffice.jsp&mostrar=tickets");
						}
						else
						{
							rDp= request.getRequestDispatcher("Vistas/pagFracaso.jsp?pagAnterior=backOffice.jsp&mostrar=tickets&causa=Error al borrar el registro de tickets");
						}
						break;
					case"orador":
						if(OradoresDAO.eliminarOrador(id))
						{
							rDp= request.getRequestDispatcher("Vistas/pagExito.jsp?pagAnterior=backOffice.jsp&mostrar=oradores");
						}
						else
						{
							rDp= request.getRequestDispatcher("Vistas/pagFracaso.jsp?pagAnterior=backOffice.jsp&mostrar=oradores&causa=Error al borrar el registro del orador");
						}
						break;
					default:
						rDp=request.getRequestDispatcher("Vistas/index.jsp");
						break;
				}
			} catch (ClassNotFoundException e) {
				rDp= request.getRequestDispatcher("Vistas/pagFracaso.jsp?pagAnterior=backOffice.jsp");
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
								rDp= request.getRequestDispatcher("Vistas/pagExito.jsp?pagAnterior=backOffice.jsp&mostrar=clientes");
							}
							else
							{
								rDp= request.getRequestDispatcher("Vistas/pagFracaso.jsp?pagAnterior=backOffice.jsp&mostrar=clientes&causa=Error al dar de baja al cliente");
							}
							break;
						case"orador":
							Orador or= OradoresDAO.buscarPorId(id);
							or.setFechaBajaInstante();
							if(OradoresDAO.actualizarOrador(or))
							{
								rDp= request.getRequestDispatcher("Vistas/pagExito.jsp?pagAnterior=backOffice.jsp&mostrar=oradores");
							}
							else
							{
								rDp= request.getRequestDispatcher("Vistas/pagFracaso.jsp?pagAnterior=backOffice.jsp&mostrar=oradores&causa=Error al dar de baja al orador");
							}
							break;
							default:
								rDp=request.getRequestDispatcher("Vistas/index.jsp");
								break;
					}
				} catch (ClassNotFoundException e) {
					rDp= request.getRequestDispatcher("Vistas/PagFracaso.jsp?pagAnterior=backOffice.jsp&causa=Error conexion con la base de datos");
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
		doGet(request, response);
	}

}
