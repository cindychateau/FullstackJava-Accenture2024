/*
FUNCIÓN: Bloque de código que puedo nombrar y que puedo llamar (las veces que necesite)
*/

//function nombre_funcion(parametros1, parametros2...) {}

function saludo() {
    console.log("¡Hola!");
    console.log("Que tengas un buen día.");
}

saludo();
saludo();
saludo();

function saludo_nombre(nombre) { //nombre = "Juana"
    console.log(`¡Hola ${nombre}!`); //¡Hola Juana!
}

saludo_nombre("Elena");
saludo_nombre("Juana");

function saludo_nombre_apellido(nombre, apellido) { //nombre = "Elena", apellido = "De Troya"
    console.log(`¡Hola ${nombre} ${apellido}!`);  //¡Hola Elena De Troya!
}

saludo_nombre_apellido("Elena", "De Troya");

let multiplica = 2;
function sumatoria(num1, num2) { //num1 = 15, num2 = 15
    let dentro_funcion = 10;
    return num1+num2; //return 30
}

//console.log(dentro_funcion); //NO FUNCIONA
let resultado = sumatoria(15, 15); // resultado = 30
resultado *= 2;
console.log("El resultado multiplicado es:"+resultado);

function restar(texto, num1, num2) { //texto = "holi holi", num1 = 1, num2 = 10
    console.log(texto); //Imprime: "holi holi"
    return num2 - num1; // <- 10-1 = 9
}

let resultado_resta = restar("holi holi", 1, 10); //resultado_resta = 9
console.log(resultado_resta);

function al_cuadrado(numero) { //numero = 5
    let numero_al_cuadrado = numero * numero; //numero_al_cuadrado = 5 * 5 = 25
    return numero_al_cuadrado; //<- 25
}

let resultado_num_cuadrado = al_cuadrado(5); // = 25
console.log("El numero al cuadrado de 5 es:"+resultado_num_cuadrado);

console.log("Otro cuadrado:"+al_cuadrado(10));

/* RETO
Función que reciba un número y regrese el sigma de ese número.
Ej:
sigma(5): regresar la suma 15
sigma(2): regresar la suma 3
sigma(10): regresar la suma 55


sigma(0) = 0

sigma(5)
num = 5
return 5 + 10

sigma(4)
num = 4
return 4 + 6

sigma(3)
num = 3
return 3 + 3

sigma(2)
num = 2
return 2 + 1

sigma(1)
num = 1
return 1 + 0

sigma(0)
num = 0
return 0
*/
function sigma(num) {
    if(num <= 0) {
        return 0
    } else {
        return num + sigma(num-1);
    }
}

function sigma_confor(num) {
    let suma = 0;
    for(let i=1; i <= num; i++) {
        suma += i;
    }
    return suma;
}