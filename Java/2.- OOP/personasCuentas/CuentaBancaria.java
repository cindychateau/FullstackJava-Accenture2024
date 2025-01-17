import java.util.ArrayList;
import java.util.Random;
public class CuentaBancaria {

    private double saldo;
    private Persona titular;
    private int numeroCuenta;

    private static ArrayList<CuentaBancaria> listaDeCuentasBancarias = new ArrayList<CuentaBancaria>();

    public CuentaBancaria(double saldo, Persona titular) {
        this.saldo = saldo;
        this.titular = titular;
        //Nosotros debemos de generar ese #
        Random random = new Random();
        this.numeroCuenta= 100000 + random.nextInt(900000);
        //Siempre cumpla con los 6 dígitos
        CuentaBancaria.listaDeCuentasBancarias.add(this);
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Persona getTitular() {
        return this.titular;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public int getNumeroCuenta() {
        return this.numeroCuenta;
    }

    public void depositar(double monto) {
        //saldo = saldo + monto;
        this.saldo += monto;
        /*
        double saldoActual = cuenta1.getSaldo();
        double nuevoSaldo = saldoActual + monto;
        cuenta1.setSaldo(nuevoSaldo);
         */
    }

    public void retirar(double monto) {
        //saldo = 100
        //monto = 21
        if(this.saldo >= monto) {
            //Si me deja hacer el retiro
            //this.saldo = this.saldo - monto
            this.saldo -= monto; 
            //nuevo saldo = 79
        } else {
            System.out.println("Fondos Insuficientes :(");
        }
    }



}