// comprtamiento navBar 

var navBar = document.getElementById("barraNav");
var enCalculo=false;
window.onload=function()
{
    window.setInterval(() => {
        posicionInicial=window.scrollY;
    }, 1);
}
window.onscroll = function () {
    let anchoPantalla = window.innerWidth;
    let posicionNueva = window.scrollY;
    if (posicionNueva < (posicionInicial)) {
        if (anchoPantalla > 800) {

            if (!navBar.classList.contains("fixed-top"))
                navBar.classList.add("fixed-top");
        }
        else {
            if (navBar.classList.contains("fixed-top"))
                navBar.classList.remove("fixed-top");
        }
    }
    else {
        if (navBar.classList.contains("fixed-top"))
            navBar.classList.remove("fixed-top");
    }

}

window.onresize=function(){
    let anchoPantalla = window.innerWidth;
    if(anchoPantalla>800)
    {
        
        if(!navBar.classList.contains("fixed-top"))
        navBar.classList.add("fixed-top");
    }
    else{
        if(navBar.classList.contains("fixed-top"))
        navBar.classList.remove("fixed-top");
    }
}
