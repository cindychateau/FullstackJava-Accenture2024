var numero = 1; //Alcance mayor
let texto = "Este es un texto"; //Alcance en base al bloque en el que se declara
let decimal = 1.11;
let bool = true;  //true o false

let sinvalor; //no le asigné ningún valor

console.log("¡Hola chiquillos!");
console.log(texto);
console.log(sinvalor); //Por defecto a colocar undefined


sinvalor = 10;
console.log(sinvalor);

let numero1 = 10;
let numero2 = 20;
let suma = numero1+numero2; //10 + 20 = 30
console.log(suma);

let nombre = "Elena de Troya";
let mensaje = "Mi nombre es:";
console.log(mensaje+nombre); //Concatenar

let combinamosTexto = "ABC";
console.log(combinamosTexto+numero1);
console.log(combinamosTexto+numero1+numero2);
console.log(combinamosTexto+(numero1+numero2));
console.log(numero1+numero2+combinamosTexto);

let orden = 10 + 20 / 6;
console.log(orden); // 1.- (), 2.- /*%, 3.- +-

let otro_nombre = "Juana de Arco";
let edad = 18;
let otro_mensaje = `Mi nombre es: ${otro_nombre}, ¿cómo estás? Tengo ${edad} años.`; //Interpolación
let mensaje_normal = "Mi nombre es: "+otro_nombre+", ¿cómo estás? Tengo "+edad+" años.";
console.log(otro_mensaje);

let n = 14;
n++; //sumarle 1. n = 15
n += 5; //15 + 5. n = 20
console.log(n); //  += -= /= *=

let nombre_completo = "Pedro";
nombre_completo += " Páramo"; //"Pedro"+" Páramo"
console.log(nombre_completo);

nombre_completo = "Pablo Picasso";
console.log(nombre_completo); 
console.log("OTRACOSA");

//CONDICIONALES
if(bool) { // a === b; a !== b; a < b; a > b; a <= b; a >= b
    console.log("Variable verdadera");
} else {
    console.log("Variable falsa");
}

if(n >= 15) { //20 >= 15 ?
    console.log("Numero mayor a 15");
} else {
    console.log("Numero menor a 15");
}

let edad_nino = 4;
if(edad_nino < 2) { // 4 < 2 FALSE
    console.log("Es un bebe");
}else if(edad_nino < 5) { // 4 < 5 TRUE
    console.log("Es un toddler"); //IMPRIME
} else if(edad_nino < 15){
    console.log("Es un infante");
}else {
    console.log("adolescente");
    console.log("Ay que miedo adolescencia");
}

if(5 > 4) {
    console.log("5 es mayor a 4");
}

let temperatura = 2;
let estaLloviendo = false; //NO ESTA LLOVIENDO
if(temperatura >= 18 && !estaLloviendo) { // && = and -> AMBAS CONDICIONALES deben de cumplirse
    console.log("Es un buen día para dar un paseo!");
}

/* Se realiza comparación para otorgar licencia de manejo */
let edad_conducir = 17;
let permisoPadres = true; //SI me dieron permiso mis padres
if(edad_conducir >= 18 || permisoPadres) { // || -> una u otra condicional debe de cumplirse
    console.log("Puedes obtener tu licencia de manejo");
}

//BUCLES o CICLOS
/*
i = 0
¡Hola!
¿Cómo estás?
--
i = 1
¡Hola!
¿Cómo estás?
--
i = 2
¡Hola!
¿Cómo estás?
---
i = 3
¡Hola!
¿Cómo estás?
--
i = 4
*/
for(let i=0; i<4; i++) { //(inicialización; condicional; paso)
    console.log("¡Hola!");
    console.log("¿Cómo estás?");
}

/*
i = 10
IMPRIME:10
--
i = 9
IMPRIME:9
--
i = 8
IMPRIME:8
--
i = 7
IMPRIME:7
--
i = 6
*/
for(let i=10; i > 6; i--) {
    console.log(i);
}

/*
x = 0
Entre al bucle while
x = 1
--
Entre al bucle while
x = 2
*/
let x = 0;
while(x < 2) {
    console.log("Entre al bucle while");
    x++;
}

/*
inicio = 2
final = 8
Entre otra vez al while
inicio = 3
final = 7
--
Entre otra vez al while
inicio = 4
final = 6
--
Entre otra vez al while
inicio = 5
final = 5
*/
let inicio = 2;
let final = 8;
while(inicio < final) {
    console.log("Entre otra vez al while");
    inicio++;
    final--;
}

//ARRAY / ARREGLOS / LISTAS
let hobbies = ["leer", "correr", "bailar", "cantar", "jugar", "tocar la guitarra"];

console.log(hobbies[0]);
hobbies[1] = "trotar";

console.log(hobbies);
console.log(hobbies.length); //regresa el tamaño de la lista

//¿Cómo puedo recorrer una lista?
/*
i = 0
IMPRIMIR leer
--
i = 1
IMPRIMIR correr
....
i = 5
IMPRIMIR tocar guitarra
--
i = 6
*/
for(let i = 0; i< hobbies.length; i++){
    console.log(hobbies[i]);
}

let lista=[1, 2, 3, 4];
let i=0
while(i < lista.length){
  console.log(lista[i]);
  i++;
}

let nombres = ["Juana", "Elena", "Pablo", "Pedro"];
for(let i = 0; i < nombres.length; i++) {
    console.log(`La posición ${i} tiene al nombre ${nombres[i]}`);
    console.log("La posición "+i+ "tiene al nombre "+nombres[i]);
}

let lista_super = [
                    "Manzanas",
                    "Huevo",
                    "Leche",
                    "Jamón"
                ];

for(let i=0; i < lista_super.length; i++) {
    console.log("Yo necesito:"+lista_super[i]);
}

let lista_combinada = [
    "letras",
    12,
    1.1
];

let matriz = [
    [1, 2, 3, 4, 5],
    [6, 7, 8, 9, 10],
    [11, 12, 13, 14, 15]
];

console.log(matriz[1][1]+" "+matriz[2][1]);
console.log(lista_combinada[0]);
console.log(matriz[2]);

/* OBJETOS */
let estudiante = {
    id: 123,
    nombre: "Elena",
    apellido: "De Troya",
    "edad": 25,
    "hobbies": ["Leer", "Bailar", "Ver series"],
    "direcciones": [
        {
            "calle": "Av. Sol",
            "num": 123,
            "ciudad": "Comala",
            "pais": "México"
        },
        {
            "calle": "Primera Ave.",
            "num": 345,
            "ciudad": "Furia",
            "pais": "México"
        }
    ]
}

console.log(estudiante["nombre"]);
console.log(estudiante.apellido);

estudiante.apellido = "De Arco";
console.log(estudiante);

estudiante.curso = "Full stack Java";
console.log(estudiante);

let curso = {
    "nombre": "Java",
    "instructor": "Cynthia",
    "descripcion": "Es un curso de Full stack java",
    "duracion": 7
};

console.log(curso.instructor);

const noPuedeCambiar = "No va a cambiar";