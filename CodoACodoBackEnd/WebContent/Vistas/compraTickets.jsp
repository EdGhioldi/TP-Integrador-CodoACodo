<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="Styles/style.css">

    <title>Compra de tickets</title>
</head>

<body>

    <header>
    <nav id="barraNav" name="barraNav" class="navbar navBarColor">
        <div class="container-fluid m-5 mt-0 mb-0 navBarColor">
            <div class="whiteTipo">
                <a class="alert text-decoration-none" href="FrontController?accion=volver">Conf Bs As</a>
            </div>
            <ul class="nav justify-content-end">
                <li class="nav-item">
                    <a class="nav-link" href="FrontController?accion=volver" onclick="()=>{window.open('index.html#secConferencia','_self')}">La conferencia</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="FrontController?accion=volver" onclick="()=>{window.open('index.html#secOradores','_self')}">Los oradores</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="FrontController?accion=volver" onclick="()=>{window.open('index.html#secLugarFecha','_self')}">El lugar y la fecha</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="FrontController?accion=volver" onclick="()=>{window.open('index.html#secOrador','_self')}">Conviértete en orador</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link linkCompra" href="#">Comprar tickets</a>
                </li>
            </ul>
        </div>
    </nav>
    </header>

    <main>
        <div class="container w-50 mt-3 p-0  ">
            <div class="row row-cols-1 p-0 mb-2 justify-content-center">
                <div class="col">
                    <section>
                        <div class="container-fluid m-0 p-0">
                            <div class="row p-0 g-1 justify-content-center">
                                <div class="col">
                                    <div class="card border-primary border-2 p-1">
                                        <div class="card-body">
                                            <h5 class="card-title text-center mb-4">Estudiante</h5>
                                            <h6 class="card-subtitle mb-4 text-body-secondary text-center">Tiene un
                                                descuento</h6>
                                            <p class="card-text text-center fw-bold mb-4">80%</p>
                                            <p class="card-text text-center">* presentar documentación</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="card border-info border-2 p-1">
                                        <div class="card-body">
                                            <h5 class="card-title text-center mb-4">Trainee</h5>
                                            <h6 class="card-subtitle mb-4 text-body-secondary text-center">Tiene un
                                                descuento</h6>
                                            <p class="card-text text-center fw-bold mb-4">50%</p>
                                            <p class="card-text text-center">* presentar documentación</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="card border-warning border-2 p-1">
                                        <div class="card-body">
                                            <h5 class="card-title text-center mb-4">Junior</h5>
                                            <h6 class="card-subtitle mb-4 text-body-secondary text-center">Tiene un
                                                descuento</h6>
                                            <p class="card-text text-center fw-bold mb-4">15%</p>
                                            <p class="card-text text-center">* presentar documentación</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
            <div class="row row-cols-1 justify-content-center">
                <div class="col">
                    <h6 class="fs- fw-normal text-center">VENTA</h6>
                    <h1 class="h1 text-center">VALOR DE TICKET $200</h1>
                </div>
            </div>
            <div class="row row-cols-1 p-0 justify-content-center">
                <div class="col">
                    <section>
                        <form action="FrontController?accion=comprarTicket" method="post">
                            <div class="container-fluid p-0">
                                <div class="row row-cols-2 mb-3">
                                    <div class="col">
                                        <input id="iptNombre" name="iptNombre" type="text" class="form-control" placeholder="Nombre" >
                                    </div>
                                    <div class="col">
                                        <input  id="iptApellido" name="iptApellido" type="text" class="form-control" placeholder="Apellido" >
                                    </div>
                                </div>
                                <div class="row row-cols-1 mb-3">
                                    <div class="col">
                                        <input  id="iptCorreo" name="iptCorreo" type="text" class="form-control" placeholder="Correo" required="required">
                                    </div>
                                </div>
                                <div class="row row-cols-2 mb-3">
                                    <div class="col">
                                        <label for="iptCantidad" class="form-label">Cantiad</label>
                                        <input id="iptCantidad" name="iptCantidad" type="number" class="form-control" placeholder="cantidad">
                                    </div>
                                    <div class="col">
                                        <label for="selCategoria" class="form-label">Categoria</label>
                                        <select id="selCategoria" name="selCategoria" class="form-select" aria-label="Default select example">
                                            <option value="0" selected>Estudiante</option>
                                            <option value="1">Trainee</option>
                                            <option value="2">Junior</option>
                                          </select>
                                     </div>
                                </div>
                                <div class="row row-cols-1 mb-3">
                                    <div class="col">
                                        <div id="alTotalPago" name="alTotalPago" class="alert bg alert-info">
                                            Total a pagar: $
                                          </div>
                                          <input id="iptPrecio" name="iptPrecio" type="text" hidden="collapse">
                                    </div>
                                </div>
                                <div class="row row-cols-3 mb-3">
                                    <div class="col g-2 d-grid">
                                        <button id="btnBorrar" name="btnBorrar" type="button" class="btn btn-danger">Borrar</button>
                                    </div>
                                    <div class="col g-2 d-grid">
                                        <button id="btnResumen" name="btnResumen" type="button" class="btn btn-warning">Resumen</button>
                                     </div>
                                      <div class="col g-2 d-grid">
                                        <button id="btnSubmit" name="btnSubmit" type="submit" class="btn btn-success" disabled="disabled"  value="comprarTicket">Aceptar</button>
                                     </div>
                        </form>
                    </section>
                </div>
            </div>
        </div>
    </main>
    <footer>

        <div class="container-fluid text-center footerColor p-5 pt-3 pb-3">
            <div class="row pt-3 pb-3 align-items-center justify-content-evenly">
                <div class="col-auto">
                    <a class="footerText" href="#">Preguntas <br> frecuentes</a>
                </div>
                <div class="col-auto ">
                    <a class="footerText" href="#">Contáctanos</a>
                </div>
                <div class="col-auto ">
                    <a class="footerText" href="#">Prensa</a>
                </div>
                <div class="col-auto ">
                    <a class="footerText" href="#">Conferencia</a>
                </div>
                <div class="col-auto">
                    <a class="footerText" href="#">Términos y <br> condiciones</a>
                </div>
                <div class="col-auto ">
                    <a class="footerText" href="#">Privacidad</a>
                </div>
                <div class="col-auto ">
                    <a class="footerText" href="#">Estudiantes</a>
                </div>
            </div>
        </div>

    </footer>










    <script src="Scripts/compraTicket.js"></script>
    
   
   
   
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
    
</body>

</html>