package main;

// Camioneta.java
public class Camion extends Vehiculo {
    private int capacidadCarga;

    public Camion(int idVehiculo, String marca, String modelo, int año, double costoDiario, int capacidadCarga) {
        super(idVehiculo, marca, modelo, año, costoDiario);
        this.capacidadCarga = capacidadCarga;
    }

    // Getters y Setters
    public int getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public String toString() {
        return super.toString() + " - Camioneta (" + capacidadCarga + "kg)";
    }
}
