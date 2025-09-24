package vehiculos.modelo;

import vehiculos.servicios.Combustible;

public class Carro extends Vehiculo implements Combustible {
    public Carro(String marca, String modelo) { super(marca, modelo); }

    @Override
    public void mover() {
        System.out.println(toString() + " avanza por carretera con 4 ruedas.");
    }

    @Override
    public void recargar(double litros) {
        System.out.println(toString() + " recarga " + litros + " litros de gasolina.");
    }
}
