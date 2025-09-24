package vehiculos.modelo;

public abstract class Vehiculo {
    private final String marca;
    private final String modelo;

    protected Vehiculo(String marca, String modelo) {
        if (marca == null || modelo == null) {
            throw new IllegalArgumentException("Marca y modelo no pueden ser null");
        }
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }

    public abstract void mover();

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{marca='" + marca + "', modelo='" + modelo + "'}";
    }
}
