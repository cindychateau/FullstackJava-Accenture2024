let currentSlide = 0;

//Repite constantemente la invocación de una función en un intervalo de tiempo
setInterval(nextSlide, 3000);

function showSlide(n) { //n = 0

    currentSlide = n;

    /* Eliminando la clase que hace que se vea */
    let actual = document.querySelector('.db');
    actual.classList.remove('db');

    //Lista con todos los elementos que tienen la clase slide
    let slides = document.getElementsByClassName('slide');
    slides[n].classList.add("db");

    //Eliminar el dot que se encuentra activo
    document.querySelector('.active').classList.remove('active');

    //lista de .dot
    let dots = document.getElementsByClassName('dot');
    dots[n].classList.add('active');

//document.getElementsByClassName('dot')[n].classList.add('active')

}

function nextSlide() {
    currentSlide++;

    /* Revisar que siga el número dentro de la cantidad */
    if(currentSlide > 2) {
        currentSlide = 0;
    }

    showSlide(currentSlide);
}

function prevSlide() {
    currentSlide--;

    /* Revisar que siga el numero antes 0 */
    if(currentSlide < 0) {
        currentSlide = 2;
    }

    showSlide(currentSlide);
}

document.onkeydown = function(e) {
    if(e.key == "ArrowLeft") {
        prevSlide();
    } else if(e.key == "ArrowRight") {
        nextSlide();
    }
}