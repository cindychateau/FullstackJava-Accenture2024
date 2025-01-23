public class AdivinaNumero {

    public static String compararNumeros(int num1, int num2) {
        if(num1 == num2) {
            return "Has conseguido adivinar el número";
        } else if(num1 < num2) {
            return "Intenta con un número más grande.";
        } else {
            return "intenta con un número más pequeño";
        }
    }


}