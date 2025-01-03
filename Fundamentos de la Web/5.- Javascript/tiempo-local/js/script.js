alert("Cargando Reporte del Clima");

const temperaturas = {
    "Buenos Aires": ["22C 15C", "23C 28C", "21C 23C", "14C 18C", "12C 15C"],
    "Ciudad de México": ["23C 15C", "24C 28C", "23C 23C", "14C 18C", "10C 15C"],
    "Santiago": ["24C 15C", "25C 28C", "21C 24C", "14C 13C", "16C 15C"],
    "Sao Paulo": ["25C 15C", "26C 28C", "21C 26C", "13C 18C", "19C 15C"],
    "Quito": ["26C 15C", "27C 28C", "21C 28C", "11C 18C", "18C 15C"]
}

function eliminar_cookies(elemento_boton) {
    // let pie_de_pagina = document.querySelector("footer");
    // pie_de_pagina.remove(); //Eliminando el elemento

    let parent = elemento_boton.parentNode.parentNode;
    parent.remove();

}

function cambiar_temperatura(elemento) {
    //elemento = <a href="#" onclick="cambiar_temperatura(this)">Santiago</a> 
    //ciudad = "Santiago"
    let ciudad = elemento.innerText;

    //elemento_h2 = <h2 id="titulo_ciudad">Buenos Aires</h2>
    let elemento_h2 = document.querySelector("#titulo_ciudad");
    elemento_h2.innerText = ciudad;

    console.log(temperaturas[ciudad]); //Lista de temperaturas

    for(let i=0; i<temperaturas[ciudad].length; i++) {
        let temp_html = document.querySelector('#temp'+i);
        temp_html.innerText = temperaturas[ciudad][i];
    }

}