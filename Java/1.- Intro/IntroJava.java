/*
PascalCase - CadaPalabraVaConMayuscula -> Nombres de archivo y nombres de clases
camelCase - primeraMinNuevasMayuscula -> Nombre de variables y nombre de métodos
javac NombreArchivo.java -> compilar
java NombreArchivo -> interpret/ejecuta
 */
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