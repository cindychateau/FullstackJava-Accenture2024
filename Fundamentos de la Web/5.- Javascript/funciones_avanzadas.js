/* OPERADOR TERNARIO: simplificada de realizar una condicional */
let edad = 14;
let mensaje = "";

if(edad > 18) {
    mensaje = "La persona es mayor de edad";
    console.log(mensaje);
    let otra_variable = "x";
} else {
    mensaje = "La persona es menor de edad";
}

//(condicional) ? si se cumple : no se cumple
mensaje = (edad > 18) ? "La persona es mayor de edad" : "La persona es menor de edad";

let edad_bb = 3;
if(edad_bb < 2) {
    mensaje = "Es un bebe";
} else if(edad_bb < 5) {
    mensaje = "Es un toddler";
} else {
    mensaje = "Es un infante";
}

mensaje = (edad_bb < 2) ? "Es un bebe" : (edad_bb < 5) ? "Es un toddler" : "Es un infante";

let mes = 2;
// if(mes == 1) {
//     console.log("Enero");
// } else if(mes == 2) {
//     console.log("Febrero");
// } else if(mes == 3) {
//     console.log("Marzo");
// }
switch(mes) {
    case 1:
        console.log("Enero");
        break;
    case 2:    
        console.log("Febrero");
        break;
    case 3:    
        console.log("Marzo");
        break; 
    case 4:    
        console.log("Abril");
        break; 
    default:
        console.log("Mes no encontrado");
        break;
}

let fruta = "Papaya";
switch(fruta){
    case "Plátano":
        console.log("El precio de plátano es de $5");
        break;
    case "Manzana":
        console.log("El precio de la manzana es $1");
        break;
    case "Papaya":
        console.log("La papaya está en descuento, 2 x 1");
        break;
    default:
        console.log("No se encontró la fruta");
        break;
}

/* FUNCION FLECHA: Manera simplificada en la que yo creo una función

nombreFuncion = parametros => codigo;

*/
function sumatoria(num1, num2) {
    return num1+num2;
}

let sumatoriaFlecha = (num1, num2) => num1+num2; //No es necesaria la palabra "return", asume por defecto que eso es lo que se regresa

function imprimeHasta(num) {
    for(let i=0; i<num; i++) {
        console.log(i);
    }
}

let imprimeHastaFlecha = num => {
    for(let i=0; i<num; i++) {
        console.log(i);
    }
}

let doble = num => 2*num;

function dobleNormal(num) {
    return 2*num;
}

/* TAREA: Pasar todas las funciones que hicimos en clase a funciones de flecha */

/* FUNCIONES PARA ARREGLOS */
//forEach: recorre mi lista
let numeros = [3, 2, 5, 6, 7, 8];
numeros.forEach(function(num) {
    console.log("En este momento estoy recorriendo el num:"+num);
});

//map: me va recorrer la lista y la va alterar
let nombres = ["Elena", "Juana", "Pedro", "Pablo"];
let saludos = nombres.map(nombre => `¡Hola ${nombre}! ¿Cómo estás?`);

//filter: recorre y filtra la lista
let nums_filtrado = numeros.filter(num => num > 5); //[6, 7, 8]