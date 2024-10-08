package main;

public class Vehiculo {
    private String idVehiculo;
    private String marca;
    private String modelo;
    private int año;

    public Vehiculo(String idVehiculo, String marca, String modelo, int año) {
        this.idVehiculo = idVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
    }

    // Getters y Setters
    public String getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    @Override
    public String toString() {
        return idVehiculo + " - " + marca + " " + modelo + " (" + año + ")";
    }
}
