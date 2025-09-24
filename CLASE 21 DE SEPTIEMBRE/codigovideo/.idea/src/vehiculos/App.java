package vehiculos;

import vehiculos.modelo.*;
import vehiculos.servicios.Combustible;

public class App {
    public static void main(String[] args) {
        Vehiculo[] flota = new Vehiculo[] {
            new Carro("Toyota", "Corolla"),
            new Moto("Yamaha", "MT-03"),
            new Camion("Volvo", "FH16"),
            new Carro("Honda", "Civic")
        };

        System.out.println("-Mover flota-");
        for (Vehiculo v : flota) {
            v.mover();
        }

        System.out.println("\n=== Recargar sólo los que usan combustible (interfaz) ===");
        for (Vehiculo v : flota) {
            if (v instanceof Combustible) {
                ((Combustible) v).recargar(30.0);
            } else {
                System.out.println(v + " no implementa recarga de combustible.");
            }
        }
    }
}
