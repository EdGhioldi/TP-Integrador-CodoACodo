<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.CodoACodoBackEnd.Modelos.Cliente" %>
    <%@page import="com.CodoACodoBackEnd.Modelos.Orador" %>
    <%@page import="com.CodoACodoBackEnd.Modelos.Ticket" %>
    <%@page import="com.CodoACodoBackEnd.Repositorios.ClientesDAO" %>
    <%@page import="com.CodoACodoBackEnd.Repositorios.OradoresDAO" %>
    <%@page import="com.CodoACodoBackEnd.Repositorios.TicketsDAO" %>
    <%@page import="java.util.List" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="Styles/style.css">

<title>backOffice</title>
</head>
<body class="bg-dark">
	<header>
	        <nav id="barraNav" name="barraNav" class="navbar navBarColor">
	            <div class="container-fluid m-5 mt-0 mb-0 navBarColor">
	                <div class="whiteTipo">
	                    <img src="img/codoacodo.png" alt="" width="100" height="50" class="d-inline-block">
	                    Conf Bs As
	                </div>
	                <ul class="nav justify-content-end">
                		<li class="nav-item">
                    		<a class="nav-link" href="FrontController?accion=backOffice&mostrar=clientes" >Clientes</a>
                		</li>
                		<li class="nav-item">
                    		<a class="nav-link" href="FrontController?accion=backOffice&mostrar=oradores" >Oradores</a>
                		</li>
                		<li class="nav-item">
                   			 <a class="nav-link" href="FrontController?accion=backOffice&mostrar=tickets">Tickets</a>
               			 </li>
	                       <li class="nav-item">
	                        <a class="btn btn-outline-danger" href="FrontController?accion=volver">Salir</a>
	                   	 </li>
	                </ul>
	            </div>
	        </nav>
	    </header>
	    <main>
             
              		 <table class="table  table-dark table-info table-striped ">
              <% 
              	String categoria=request.getParameter("mostrar");
              	if(categoria==null) categoria="Clientes";
              	switch(categoria)
              	{
              	case "oradores":
              		%>
              			<thead>
              				<td>id</td>
              				<td>Nombre</td>
              				<td>Apellido</td>
              				<td>Tema</td>
              				<td>Fecha alta</td>
              				<td>Fecha baja</td>
              				<td>Acciones</td>
              			</thead>
              		<%
              		List<Orador> oradores=OradoresDAO.buscarTodos();
              		for(Orador o : oradores)
              		{
              			%>
              			<tr>
              				<td><%=o.getId()%></td>
              				<td><%=o.getNombre() %></td>
              				<td><%=o.getApellido()%></td>
              				<td><%=o.getTema() %></td>
              				<td><%=o.getFechaAlta()%></td>
              				<td><%=o.getFechaBaja()==null?"N/A":o.getFechaBaja()%></td>
              				<td>
              					<a class="btn btn-warning btn-sm"  href="FrontController?accion=darBaja&categoria=orador&id=<%=o.getId()%>">Dar baja</a>
              					<a class="btn btn-danger btn-sm" href="FrontController?accion=eliminar&categoria=orador&id=<%=o.getId()%>">Eliminar</a>
              				</td>
              			</tr>
              			<%
              		}
              		break;
            	case "tickets":
            		%>
       				
            				<thead>
	              				<td>id</td>
	              				<td>Cliente</td>
	              				<td>Fecha de compra</td>
	              				<td>Cantidad</td>
	              				<td>Valor total</td>
	              				<td>Acciones</td>
              			</thead>
           
              		<%
              		List<Ticket> tickets=TicketsDAO.buscarTodos();
              		for(Ticket t : tickets)
              		{
              			%>
              			<tr>
              				<td><%=t.getId()%></td>
              				<td><%=ClientesDAO.buscarPorId(t.getIdCliente()).getEmail()%></td>
              				<td><%=t.getFechaCompra()%></td>
              				<td><%=t.getCantidad()%></td>
              				<td><%=t.getPrecio()%></td>
              				<td>
              					<a class="btn btn-danger btn-sm" href="FrontController?accion=eliminar&categoria=ticket&id=<%=t.getId()%>">Eliminar</a>
              				</td>
              			</tr>
              			<%
              		}
              		break;
            	default:
            		%>
            		 
              			<thead>
              				<td>id</td>
              				<td>Nombre</td>
              				<td>Apellido</td>
              				<td>Correo</td>
              				<td>Fecha alta</td>
              				<td>Fecha baja</td>
              				<td>Acciones</td>
              			</thead>
              		<%
              		List<Cliente> clientes=ClientesDAO.buscarTodos();
              		for(Cliente c : clientes)
              		{
              			%>
              			<tr>
              				<td><%=c.getId()%></td>
              				<td><%=c.getNombre() %></td>
              				<td><%=c.getApellido()%></td>
              				<td><%=c.getEmail() %></td>
              				<td><%=c.getFechaAlta()%></td>
              				<td><%=c.getFechaBaja()==null?"N/A":c.getFechaBaja() %></td>
              				<td>
              					<a class="btn btn-warning btn-sm"  href="FrontController?accion=darBaja&categoria=cliente&id=<%=c.getId()%>">Dar baja</a>
              					<a class="btn btn-danger btn-sm" href="FrontController?accion=eliminar&categoria=cliente&id=<%=c.getId()%>">Eliminar</a>
              				</td>
              			</tr>
              			<%
              		}
              		break;
              	}
              
              %>
              		</table>
	    </main>
</body>
</html>