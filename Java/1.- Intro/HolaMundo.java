//Lógica = Métodos
public class HolaMundo {

    public static int suma(int num1, int num2) {
        return num1+num2;
    }

    //Sobrecarga/Overloading: nombrar diferentes métodos con el mismo nombre siempre y cuando reciba diferentes parámetros

    public static double suma(double num1, double num2) {
        return num1+num2;
    }

    public static int suma(int num1, int num2, int num3) {
        return num1+num2+num3;
    }

}