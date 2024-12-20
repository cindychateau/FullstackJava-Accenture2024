console.log("¡Entramos a la página!");

function bienvenido() {
    alert("¡Bienvenido a la Página de Perfil!");
}

function eliminar(elemento) {
    //console.log(elemento);
    elemento.remove();
    confirm("¿Seguro que quieres cerrar sesión?");
    
    //elemento.style.visibility = "hidden";
    
}

function cambiar_texto(elemento_h1) {
    if(elemento_h1.innerText == "Profile") {
        elemento_h1.innerText = "Perfil";
    }else {
        elemento_h1.innerText = "Profile";
    }
}

function cambia_imagen(elemento_img) {
    elemento_img.src = "images/gatito.jpg";
    elemento_img.style.backgroundImage = "url('image/nueva.jpg')";
}

function regresa_imagen(elemento_img) {
    elemento_img.src = "images/jane-m.jpg";
}

function editar_perfil() {
    let elemento_nombre = document.querySelector("#nombre");
    let elemento_parrafo = document.querySelector(".descripcion");

    elemento_nombre.innerText = "Cynthia Castillo";
    elemento_parrafo.innerHTML = "Instructora de programación <br> Amante de los gatitos.";

    //color: white;
    elemento_nombre.style.color = "white";
    //background-color: babyblue;
    elemento_nombre.style.backgroundColor = "blue";
    //camelCase PascalCase

}

function busqueda() {
    let input = document.querySelector("#buscador");
    let valor = input.value; //Valor que el usuario escribió en el input
    alert("Estás buscando: "+valor);
}

function cambiar_modo() {
    let tarjeta_usuario = document.querySelector(".user-card");

    //tarjeta_usuario.classList.add("dark-mode");

    if(tarjeta_usuario.classList.contains("dark-mode")) {
        tarjeta_usuario.classList.remove("dark-mode");
    } else {
        tarjeta_usuario.classList.add("dark-mode");
    }


}

