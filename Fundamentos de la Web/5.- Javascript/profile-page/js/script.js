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