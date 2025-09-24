package vehiculos.modelo;

import vehiculos.servicios.Combustible;

public class Camion extends Vehiculo implements Combustible {
    public Camion(String marca, String modelo) { super(marca, modelo); }

    @Override
    public void mover() {
        System.out.println(toString() + " transporta carga pesada por autopista.");
    }

    @Override
    public void recargar(double litros) {
        System.out.println(toString() + " recarga " + litros + " litros de diésel.");
    }
}
