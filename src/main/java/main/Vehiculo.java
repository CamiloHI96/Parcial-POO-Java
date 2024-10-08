package main;

public class Vehiculo {
    private int idVehiculo;
    private String marca;
    private String modelo;
    private int año;
    private double costoDiario;
    private boolean disponible;

    public Vehiculo(int idVehiculo, String marca, String modelo, int año, double costoDiario) {
        this.idVehiculo = idVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.costoDiario = costoDiario;
        this.disponible = true;
    }

    // Getters y Setters
    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
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

    public double calcularPrecio(int dias, boolean seguro, boolean gps) {
        double total = costoDiario * dias;
        if (seguro) {
            total += costoDiario * 0.10 * dias;
        }
        if (gps) {
            total += 5 * dias;
        }
        return total;
    }

    public double getCostoDiario() {
        return costoDiario;
    }

    public void setCostoDiario(double costoDiario) {
        this.costoDiario = costoDiario;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "ID: " + idVehiculo + ", Marca: " + marca + ", Modelo: " + modelo + ", Año: " + año + ", Costo Diario: $" + costoDiario + ", Disponible: " + disponible;
    }
}
