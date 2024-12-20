let like = 0;

function me_gusta() {
    like++;
    console.log(like);
    //numero = <span class="numero">0</span>
    let numero = document.querySelector(".numero");
    numero.innerText = like;
}