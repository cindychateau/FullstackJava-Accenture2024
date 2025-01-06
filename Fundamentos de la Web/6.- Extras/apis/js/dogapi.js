/* PROMESAS */
function muestraPerrito() {
    fetch("https://dog.ceo/api/breeds/image/random")
        .then(respuesta => respuesta.json())
        .then(data => {
            console.log(data); //data es un objeto JSON
            //data['message'] = "https://images.dog.ceo/breeds/kombai/Kombai-indian-Dog.jpg";
            let imagen = `<img alt="perrito" src="${data['message']}" >`;
            let img = "<img alt='perrito' src='"+data['message']+"'>";
            document.querySelector('.imagen-perrito').innerHTML = imagen;
        });
}

/* ASYNC/AWAIT */
async function muestraPerritoAsync() {
    let respuesta = await fetch("https://dog.ceo/api/breeds/image/random");
    let data = await respuesta.json();
    let imagen = `<img alt="perrito" src="${data['message']}" >`;
    document.querySelector('.imagen-perrito').innerHTML = imagen;
}

/*
FUNCIONES DE FLECHA
function nombreFuncion(param) {
 codigo
}

param => codigo
param => {
    codigo
    codigo
    }

*/