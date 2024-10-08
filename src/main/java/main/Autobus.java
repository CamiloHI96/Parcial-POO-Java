package main;

// Autobus.java
public class Autobus extends Vehiculo {
    private int capacidadPasajeros;

    public Autobus(String idVehiculo, String marca, String modelo, int año, int capacidadPasajeros) {
        super(idVehiculo, marca, modelo, año);
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
        return super.toString() + " - Autobús (" + capacidadPasajeros + " pasajeros)";
    }
}
