package main;

public class Autobus extends Vehiculo {
    private int capacidadPasajeros;

    public Autobus(int idVehiculo, String marca, String modelo, int año, double costoDiario, int capacidadPasajeros) {
        super(idVehiculo, marca, modelo, año, costoDiario);
        this.capacidadPasajeros = capacidadPasajeros;
    }

    // Getters y Setters
    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    @Override
    public String toString() {
        return super.toString() + ", Capacidad de Pasajeros: " + capacidadPasajeros;
    }
}