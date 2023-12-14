

    var iptCantidad=document.getElementById("iptCantidad");
	var iptPrecio=document.getElementById("iptPrecio");
    var selCategoria=document.getElementById("selCategoria");
    var alTotalPago=document.getElementById("alTotalPago");
    var btnResumen=document.getElementById("btnResumen");
    var btnSubmit=document.getElementById("btnSubmit");
    var btnBorrar=document.getElementById("btnBorrar");
	
var sumarTickets= function()
{	
    let cantidad=iptCantidad.value;
    if(cantidad==0) return;
    let categoria=selCategoria.options[selCategoria.selectedIndex].value;
    console.log(categoria);
    switch(categoria)
    {
		case "1":
			categoria=50;
			break;
		case "2":
			categoria=15;
			break;
		default:
			categoria=80;
			break;
	}
    let descuento=(cantidad*200)*(categoria/100);
    
    alTotalPago.innerText="Total a pagar: $ "+ ((cantidad*200)-descuento);
     iptPrecio.value=((cantidad*200)-descuento);
}

var borrarDatos=function()
{
  iptCantidad.value=0;
  selCategoria.selectedIndex=0;
  alTotalPago.innerText="Total a pagar: $ ";

}

btnBorrar.addEventListener("click",borrarDatos);
btnResumen.addEventListener("click",sumarTickets);
btnSubmit.addEventListener("click",sumarTickets);