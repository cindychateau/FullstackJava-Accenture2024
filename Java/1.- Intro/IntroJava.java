/*
PascalCase - CadaPalabraVaConMayuscula -> Nombres de archivo y nombres de clases
camelCase - primeraMinNuevasMayuscula -> Nombre de variables y nombre de métodos
javac NombreArchivo.java -> compilar
java NombreArchivo -> interpret/ejecuta
 */
import java.util.ArrayList;
import java.util.HashMap;
public class IntroJava {

    /*Método principal / main es lo único que se ejecuta */
    public static void main(String[] args) { //args = argumentos
        System.out.println("¡Hola mundo!"); //console.log();

        //Variable -> Definir desde un principio el tipo de dato a utilizar

        //Variables primitivas: SOLAMENTE guarda el valor
        int miNumeroEntero = 100; 
        double pi = 3.14159;
        boolean feliz = true;
        char unCaracter = 'C';
        
        //Variable de tipo objeto - Guardan el valor, tienen métodos
        Integer otroEntero = 5;
        Double otroDouble = 5.99;
        Character otroCaracter = 'A';
        String muchosCaracteres = "ABC";

        //Cadenas - Strings
        String cadena = "Buenos dias a todos mis Compañeros";
        System.out.println("La longitud de la cadena es:"+ cadena.length()); //.length() regresa tamaño cadena
        char letra = cadena.charAt(2); //e
        System.out.println(letra);

        int a = cadena.indexOf("Buenos"); //indexOf: regresa el indice/posicion de la palabra enviada
        int b = cadena.indexOf("Compañeros");
        int c = cadena.indexOf("hola"); //-1 no existe esa palabra en la variable
        System.out.println("Buenos: "+a);
        System.out.println("Compañeros: "+b);
        System.out.println("hola: "+c);
        System.out.println(cadena.toLowerCase()); //todas las letras las pone en minúscula
        System.out.println(cadena.toUpperCase()); //todas las letras las pone en mayúscula

        String frase1 = "Mi nombre es:";
        String frase2 = "Elena de Troya";
        String fraseCompleta = frase1.concat(frase2); //.concat -> Concatenar 2 textos

        String x = "hola";
        String y = "Hola";
        System.out.println(x.equals(y)); //true o false ambos textos son iguales
        System.out.println(x.equalsIgnoreCase(y)); //Compara dos texto SIN case sensitive (ignorando mayúsculas y minusculas)

        /* CONDICIONALES */
        if(miNumeroEntero == 100) {
            System.out.println("Numeros Iguales");
        } else{
            System.out.println("Numeros Dsitintos");
        }

        int edadInfante = 3;
        if(edadInfante < 2){
            System.out.println("Es un bb");
        } else if (edadInfante < 4){
            System.out.println("Es un toddler");
        } else {
            System.out.println("Es un niño");
        }

        boolean estaLloviendo = false; //NO ESTA LLOVIENDO
        int temperatura = 20;
        // && (AND): buscamos que ambas condicionales se cumplan
        if(temperatura > 18 && !estaLloviendo) { // ! = negación
            System.out.println("¡Demos un paseo! El día es precioso"); //recibe x
        }

        int edad = 16;
        boolean permisoPadres = true;
        if(edad >= 18 || permisoPadres) {
            System.out.println("Puedes obtener tu licencia de manejo");
        }

        int dia = 3;
        switch(dia) {
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miércoles");
                break;
            case 4:
                System.out.println("Jueves");
                break;
            case 5:
                System.out.println("Viernes");
                break;
            case 6:
                System.out.println("Sábado");
                break;
            case 7:
                System.out.println("Domingo");
                break;
            default:
                System.out.println("¡Solo tenemos 7 días!");
                break;
        }

        saludo("Elena");
        saludo("Juana");

        int resultado = sumatoria(3, 4); // 7
        System.out.println("El resultado es:"+resultado);

        /* ARREGLOS / ARRAYS / LISTAS: No se puede cambiar el tamaño */
        int[] arreglo; //Declaración
        arreglo = new int[5]; //Inicialización
        arreglo[0] = 4;
        arreglo[1] = 8;
        arreglo[2] = 9;
        arreglo[3] = 10;
        arreglo[4] = 5;

        int[] arreglo2 = {4, 8, 9, 10, 5}; //Arreglo de 5 espacios.  No se puede cambiar el tamaño

        System.out.println(arreglo2); //Imprime el espacio en memoria 
        System.out.println(arreglo2[2]); //Imprime el valor en índice 2
        //arreglo2[1] = nuevoValor

        //TAMAÑO de un array normal: .length
        
        //<TipoDeDato>
        ArrayList<Integer> arreglo3 = new ArrayList<Integer>(); //Declarando e Inicializando
        arreglo3.add(10);
        arreglo3.add(20);
        arreglo3.add(30);

        System.out.println(arreglo3); //.toString() -> pasarlo a que sea texto, se imprima bonito

        ArrayList<String> estudiantes = new ArrayList<String>(); //Creando una lista de String
        estudiantes.add("Juana"); //.add(valor) - Agregamos un nuevo valor a la lista
        estudiantes.add("Miguel");
        estudiantes.add("Bruno");

        System.out.println(estudiantes.get(0)); //.get(indice) - Consulta un índice específico

        estudiantes.set(0,"Juani"); //.set(indice, valor) - Cambia el valor de un índice
        System.out.println(estudiantes.get(0));

        //.size() - Tamaño de mi ArrayList

        /* BUCLES / CICLOS */
        for(int abc=0; abc<5; abc++) { //(inicialización; condicional; paso)
            System.out.println("hey!");
        }

        int m = 0;
        while(m < 5) { //flexibilidad
            System.out.println("listen!");
            m++;
        }

        int inicio = 0;
        int fin = 5;
        while(inicio < fin) {
            System.out.println("oh!");
            inicio++;
            fin--;
        }

        int n = 10;
        do { //PRIMERO sin importar la condicional, ejecución
            System.out.println("entramos al bucle");
        } while(n < 5);

        while(n<5) { //NO LO IMPRIME
            System.out.println("entro a otro bucle");
        }

        /*
        do {
            //Imprima el menú
            Comentario extra
        
        }while(no haya escrito salir)
        
         */

        /*
        let estudiante = {
            "nombre": "Juana",
            "apellido": "De Arco"
        }
         */
        //Mapas de Hash o HashMaps (Objeto)
        HashMap<String, String> estudiante = new HashMap<String, String>();
        //pon, agrega, coloca
        estudiante.put("nombre", "Juana"); //.put(llave, valor) -> Ingresando un nuevo par de llave/valor
        estudiante.put("apellido", "De Arco");
        estudiante.put("curso", "Java");

        System.out.println(estudiante.get("apellido")); //Consultar de mi estudiante la llave "apellido"
        System.out.println(estudiante);
        System.out.println(estudiante.size());

        //.size() - Tamaño de mi HashMap

        /* Bucle para recorrer un arreglo */
        for(int indice=0; indice < arreglo.length; indice++) {
            System.out.println("Arreglo:"+arreglo[indice]);
        }

        /* 3 métodos para crear un nombre de super heroe
        
        1.- Recibiera un nombre: Super <nombre>
        2.- Recibiera un nombre y un color: Super <nombre> <color>
        3.- Recibiera un nombre, color y habilidad: Super <nombre> <color> <habilidad>
        
          */

    }

    /*
    Permiso: public, private, protected 
    static: es de mi clase (Más detalles en la sesión OOP: Object Oriented Programming - Programación Orientada a Objetos)
    Tipo de valor de retorno: String, int, double. void
    Nombre función
    (parámetros)
     */
    public static int sumatoria(int num1, int num2) { //num1 = 3, num2 = 4
        //Codigo
        return num1+num2; //Regresando un int - 7
    }

    public static void saludo(String nombre) {
        System.out.println("Hola "+nombre);
    }

}