//Ejecución = Método principal
public class HolaMundoTest {

    public static void main(String[] args) {

        int resultado = HolaMundo.suma(4, 6);
        System.out.println("El resultado es:"+resultado);

        double resultadoDoble = HolaMundo.suma(4.99, 6.88);
        System.out.println("El resultado es:"+resultadoDoble);

        System.out.println("El resultado es:"+HolaMundo.suma(3, 3, 3));
    }

}