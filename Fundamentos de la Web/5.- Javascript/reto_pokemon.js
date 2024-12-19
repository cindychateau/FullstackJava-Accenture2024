var pokémon = [ //Arreglo
    { "id": 1,   "name": "Bulbasaur",  "types": ["poison", "grass"] },
    { "id": 5,   "name": "Charmeleon", "types": ["fire"] },
    { "id": 9,   "name": "Blastoise",  "types": ["water"] },
    { "id": 12,  "name": "Butterfree", "types": ["bug", "flying"] },
    { "id": 16,  "name": "Pidgey",     "types": ["normal", "flying"] },
    { "id": 23,  "name": "Ekans",      "types": ["poison"] },
    { "id": 24,  "name": "Arbok",      "types": ["poison"] },
    { "id": 25,  "name": "Pikachu",    "types": ["electric"] },
    { "id": 37,  "name": "Vulpix",     "types": ["fire"] },
    { "id": 52,  "name": "Meowth",     "types": ["normal"] },
    { "id": 63,  "name": "Abra",       "types": ["psychic"] },
    { "id": 67,  "name": "Machamp",    "types": ["fighting"] },
    { "id": 72,  "name": "Tentacool",  "types": ["water", "poison"] },
    { "id": 74,  "name": "Geodude",    "types": ["rock", "ground"] },
    { "id": 87,  "name": "Dewgong",    "types": ["water", "ice"] },
    { "id": 98,  "name": "Krabby",     "types": ["water"] },
    { "id": 115, "name": "Kangaskhan", "types": ["normal"] },
    { "id": 122, "name": "Mr. Mime",   "types": ["psychic"] },
    { "id": 133, "name": "Eevee",      "types": ["normal"] },
    { "id": 144, "name": "Articuno",   "types": ["ice", "flying"] },
    { "id": 145, "name": "Zapdos",     "types": ["electric", "flying"] },
    { "id": 146, "name": "Moltres",    "types": ["fire", "flying"] },
    { "id": 148, "name": "Dragonair",  "types": ["dragon"] }
];

/*  Imprimir todos los NOMBRES de pokemones con ID mayor a 99  */
let i = 0;
while(i < pokémon.length) {
    if(pokémon[i].id > 99) {
        console.log(pokémon[i].name);
    }
    i++;
}
for(let i=0; i<pokemon.length;i++){
    if(pokemon[i].id>99){
        console.log(pokemon[i].name);
    }
}

/* Imprimir el OBJETO (pokemon) en el cual el id es divisible entre 3 */
for (let i = 0; i < pokemon.length; i++) {
    if (pokemon[i].id % 3 == 0) console.log(pokemon[i]);
}

/* Imprimir el OBJETO con más de un tipo */
for(let i=0;i<pokemon.length;i++){
    if(pokemon[i].types.length > 1){
        console.log(pokemon[i]);
    }
}

/* Imprimir NOMBRE de pokemon que SOLO TIENE tipo "poison" */

if(1 == "1") { //== compara solo valores
    console.log("Comparando solo valores");
}

if(1 === "1") { // === comparar el valor y además el tipo de dato
    console.log("NO entra");
}