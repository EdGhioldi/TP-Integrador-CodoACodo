<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="Styles/style.css">
    <title>Conferencia codo a codo</title>
</head>

<body>
    <header>
        <nav id="barraNav" name="barraNav" class="navbar navBarColor">
            <div class="container-fluid m-5 mt-0 mb-0 navBarColor">
                <div class="whiteTipo">
                    <img src="img/codoacodo.png" alt="" width="100" height="50" class="d-inline-block">
                    Conf Bs As
                </div>
                <ul class="nav justify-content-end">
                    <li class="nav-item">
                        <a class="nav-link" href="#secConferencia">La conferencia</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#secOradores">Los oradores</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#secLugarFecha">El lugar y la fecha</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#secOrador">Conviértete en orador</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link linkCompra" href="FrontController?accion=vistaCompra">Comprar tickets</a>
                    </li>
                       <li class="nav-item ">
                        <a class="btn btn-outline-warning btn-sm" href="FrontController?accion=backOffice&mostrar=clientes">Back office</a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <main>
        <section id="secConferencia">
            <div class="card text-bg-dark border-0 rounded-0">
                <div id="carrusel" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="img/ba1.jpg" class="d-block w-100 card-img" alt="...">
                        </div>
                        <div class="carousel-item">
                            <img src="img/ba2.jpg" class="d-block w-100 card-img" alt="...">
                        </div>
                        <div class="carousel-item">
                            <img src="img/ba3.jpg" class="d-block w-100 card-img" alt="...">
                        </div>
                    </div>
                </div>
                <div class="card-img-overlay bgBlack carruseltext overflow-auto">
                    <h1 class="card-title ">Conf Bs As</h1>
                    <p class="card-text txtPeq">Bs As llega por primera vez a Argentina. Un eventro para compartir con
                        nuestra
                        comunidad el conocimiento y experiencia de los expertos que estan creando el futuro de internet.
                        Ven
                        a conocer a miembros del evento, a otros estudiantes de Codo a Codo y oradores de primer nivel
                        que
                        tenemos para ti. Te esperamos!</p>
                    <a id="btnOrador" name="btnOrador" class="btn btn-outline-light" href="#secOrador">Quiero ser
                        orador</a>
                    <button id="btnCompra" name="btnCompra" type="button" class="btn btn-success btnCompra">Comprar
                        tickets</button>
                        
                </div>
            </div>
        </section>
        <section id="secOradores">
            <div  class="container  mt-4">
                <h5 class="text-center fw-normal txtPeq">CONOCE A LOS</h5>
                <h1 class="text-center">ORADORES</h1>
                <div class="row gap-4">
                    <div class="col card p-0">
                        <img src="img/steve.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <span class="badge bg-warning text-black">JavaScript</span>
                            <span class="badge bg-primary">React</span>
                            <h5 class="card-title">Steve Jobs</h5>
                            <p class="card-text">Lorem ipsum dolor sit amet consectetur adipisicing elit. Minus impedit,
                                officiis magnam a odio, mollitia odit ipsa sed aperiam modi voluptatem nostrum alias
                                quisquam ea architecto enim eius asperiores blanditiis deserunt ratione? Ex, enim quasi.
                            </p>
                        </div>
                    </div>
                    <div class="col card p-0 ">
                        <img src="img/bill.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <span class="badge bg-warning text-black">JavaScript</span>
                            <span class="badge bg-primary">React</span>
                            <h5 class="card-title">Bill Gates</h5>
                            <p class="card-text">Lorem ipsum dolor sit amet consectetur adipisicing elit. Enim veritatis
                                at
                                corporis illo tempora quae ad facere. Officiis voluptatum corrupti doloremque! Possimus
                                deleniti exercitationem, ducimus, iure fuga aspernatur ab amet nam omnis maxime dolor
                                non?
                            </p>
                        </div>
                    </div>
                    <div class="col card p-0">
                        <img src="img/ada.jpeg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <span class="badge bg-secondary">Negocios</span>
                            <span class="badge bg-danger">Startups</span>
                            <h5 class="card-title">Ada Lovelace</h5>
                            <p class="card-text">Lorem ipsum dolor sit amet consectetur adipisicing elit. Iure, ad porro
                                nam
                                enim fugit delectus, fugiat nostrum in pariatur, laborum nesciunt facere nobis? Nulla,
                                enim
                                beatae sunt eius pariatur explicabo possimus eos et illo voluptatem.</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section id="secLugarFecha">
            <div class="card mb-3 mt-4 bg-gray whiteTipo">
                <div class="row g-0">
                    <div class="col-md-4">
                        <img src="img/honolulu.jpg" class="img-fluid rounded-start" alt="...">
                    </div>
                    <div class="col-md-8">
                        <div class="card-body">
                            <h5 class="card-title ">Bs As - Octubre</h5>
                            <p class="card-text txtPeq fw-light">Buenos Aires es la provincia y localidad mas grande del
                                estado de Argentina, en los Estados Unidos. honolulu es la mas sureña de entre las
                                principales ciudades estadounidenses. Aunque el nombre de Honolulu se refiere al area
                                urbana en la costa sureste de la isla de oahu, la ciudad y el condado de Honolulu han
                                formado una ciudad-condado consolidada que cubre toda la ciudad (aproximadamente 600 km²
                                de superficie).</p>
                            <button type="button" class="btn btn-outline-light">Conocé más</button>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section id="secOrador">
            <div class="container mt-4">
                <h5 class="text-center fw-normal txtPeq">CONVIERTETE EN UN</h5>
                <h1 class="text-center">ORADOR</h1>
                <p class="text-center fw-semibold">Anotate como un orador para dar una <span class="lineaPuntos ">charla
                        ignite</span>. Cuentanos de qué quieres hablar!</p>
                <form id="formOrador" name="formOrador" action="FrontController?accion=ingresarOrador" method="post">
                    <div class="row gap-2 p-3 ">
                        <div class="col">
                            <input id="inpNombre" name="inpNombre" type="text" class="form-control"
                                placeholder="Nombre" required>
                        </div>
                        <div class="col">
                            <input id="inpApellido" name="inpApellido" type="text" class="form-control"
                                placeholder="Apellido" required>
                        </div>
                    </div>
                    <div class="row p-4 pt-1 pb-0">
                        <textarea id="txtAreaTemario" name="txtAreaTemario" class="form-control fs-4" rows="3"
                            placeholder="Sobre que quieres hablar?" required ></textarea>
                    </div>
                    <div class="row p-4 pt-0 pb-1">
                        <p class="form-text">Recuerda incluir un titulo para tu charla.</p>
                    </div>
                    <div class="row p-4 pt-0">
                        <input id="sbmEnvioForm" name="sbmEnvioForm" type="submit" class="btn btnEnviarColor"
                            value="Aceptar">
                    </div>
                </form>
        </section>
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
    <script src="Scripts/pagPrincipal.js"></script>
    <script src="Scripts/navBar.js"></script>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>

</html>