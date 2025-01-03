let like = 0;
let like2 = 0;
let like3 = 0;

let likes = [0, 0, 0];

function me_gusta() {
    like++;
    console.log(like);
    //numero = <span class="numero">0</span>
    let numero = document.querySelector(".numero");
    numero.innerText = like;
}

function me_gusta2() {
    like2++;
    console.log(like2);
    //numero = <span class="numero">0</span>
    let numero = document.querySelector(".numero2");
    numero.innerText = like2;
}

function me_gusta3() {
    like3++;
    console.log(like3);
    //numero = <span class="numero">0</span>
    let numero = document.querySelector(".numero3");
    numero.innerText = like3;
}

function me_gusta_reformado(numero) {
    //numero = 2
    let numero_html = document.querySelector(".numero"+numero); //Selecciono el elemento que tiene la clase numero1 - <span class="numero1">0</span>

    let numero_actual = numero_html.innerText;
    numero_actual++;

    numero_html.innerText = numero_actual;

}

function meGusta(elemento){
    let span = elemento.parentNode.querySelector("span");
    let numero = parseInt(span.innerText);
    numero++;
    span.innerText = numero;
}