package run;

public class Ejercicio4 {
    public static void main(String[] args) {
        CuentaBancaria c = new CuentaBancaria();
        c.titular = "Ana";
        c.saldo = 1000;
        c.depositar(500);
        c.retirar(300);
        System.out.println("Titular: " + c.titular);
        System.out.println("Saldo: " + c.saldo);
    }
}
