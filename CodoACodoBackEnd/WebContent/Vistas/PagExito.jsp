<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="../Styles/style.css">
    <script src="https://kit.fontawesome.com/dda458bcad.js" crossorigin="anonymous"></script>
<title>Operacion exitosa</title>
</head>
<body class="bg-success">
<div class="container mt-5">
	<div class="row m-5">
		<i class="text-center fa-solid fa-heart-circle-plus fa-2xl" style="color: #00ff4c;"></i>
	</div>
	<div class="row m-5">
		<h1 class="text-center text-light">La operacion ha sido un exito</h1>		
	</div>
	<div class="row m-5">
		<div class="col"></div>
		<a class="col-auto text-center btn btn-success" href=<%="FrontController?accion=volver&pagAnterior="+request.getParameter("pagAnterior")+"&mostrar="+request.getParameter("mostrar")%>><i class="fa-solid fa-road" style="color: #000000;"></i> Volver</a>
		<div class="col"></div>
	</div>

</div>
				
</body>
</html>