package main;

public class Auto extends Vehiculo {
    private String tipoCombustible;

    public Auto(int idVehiculo, String marca, String modelo, int año, double costoDiario, String tipoCombustible) {
        super(idVehiculo, marca, modelo, año, costoDiario);
        this.tipoCombustible = tipoCombustible;
    }

    // Getters y Setters
    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo de Combustible: " + tipoCombustible;
    }
}