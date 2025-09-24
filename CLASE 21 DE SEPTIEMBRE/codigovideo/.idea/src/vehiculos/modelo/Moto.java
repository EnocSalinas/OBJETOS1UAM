package vehiculos.modelo;

public class Moto extends Vehiculo {
    public Moto(String marca, String modelo) { super(marca, modelo); }

    @Override
    public void mover() {
        System.out.println(toString() + " se desplaza ágilmente entre el tráfico con 2 ruedas.");
    }
}
