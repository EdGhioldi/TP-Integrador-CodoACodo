
// eventos botones
var btnCompra=document.getElementById("btnCompra");
var btnSbmEnvioForm=document.getElementById("sbmEnvioForm");

var irACompras=function()
{
    window.open("FrontController?accion=vistaCompra","_top");
}


btnCompra.addEventListener("click",irACompras);






