const API_KEY = "9d6694e3855549bdb32d90553e1d56eb";

async function buscarNoticias() {
    //URL: https://newsapi.org/v2/everything?q=TERMINOBUSQUEDA&apiKey=API_KEY

    let termino_busqueda = document.querySelector("#busqueda").value;

    console.log(termino_busqueda);

    let response = await fetch(`https://newsapi.org/v2/everything?q=${termino_busqueda}&apiKey=${API_KEY}&language=en&pageSize=3`);

    let data = await response.json();
    console.log(data);

    /*data['articles'] = [ //lista
        {//Objeto articulo
            author: "X",
            description: "X",
            content: "X"....
            title: "",
            urlToImage:
        }
    ]*/

    let articulos = data["articles"];

    let articulos_html = '';
    for(let i=0; i<articulos.length; i++) {
        let articulo = articulos[i]; //Objeto Articulo
        articulos_html += `<article>
                                <h2>${articulo['title']}</h2>
                                <u>${articulo['author']}</u>
                                <p>${articulo['description']}</p>
                                <img src="${articulo['urlToImage']}" >
                            </article>`;
    }

    document.querySelector('main').innerHTML = articulos_html;
}