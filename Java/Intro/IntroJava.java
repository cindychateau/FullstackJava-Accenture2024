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

    }

}