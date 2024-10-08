package main;

public class Moto extends Vehiculo {
    private int cilindrada;

    public Moto(String idVehiculo, String marca, String modelo, int año, int cilindrada) {
        super(idVehiculo, marca, modelo, año);
        this.cilindrada = cilindrada;
    }

    // Getters y Setters
    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return super.toString() + " - Moto (" + cilindrada + "cc)";
    }
}