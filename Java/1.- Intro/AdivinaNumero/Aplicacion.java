import java.util.Random;
import java.util.ArrayList;
public class Aplicacion {
    public static void main(String[] args) {
        System.out.print("Por favor ingresa un número entre 1 – 100 para adivinar.");
        Random rand = new Random();
        int num_aleatorio = rand.nextInt(100)+1;//1-100
        ArrayList<Integer> listaAdivinar = new ArrayList<Integer>();
        String linea;
        int num;
        do {
            //"2"
            linea = System.console().readLine();//recibe info del teclado
            //2
            num = Integer.parseInt(linea);//el texto lo transformo en número entero

            String mensaje = AdivinaNumero.compararNumeros(num, num_aleatorio);

            System.out.println(mensaje);

            listaAdivinar.add(num);

        } while(num != num_aleatorio);

        System.out.println("Te tomó "+listaAdivinar.size()+" adivinar el numero.");
        System.out.println(listaAdivinar);

        
    }
}