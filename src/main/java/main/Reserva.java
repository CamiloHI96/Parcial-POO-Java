package main;

import java.time.LocalDate;

public class Reserva {
    private Cliente cliente;
    private Vehiculo vehiculo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean seguro;
    private boolean gps;
    private boolean confirmada;

    public Reserva(Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin, boolean seguro, boolean gps) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.seguro = seguro;
        this.gps = gps;
        this.confirmada = false;
    }

    // Getters y Setters
    public Cliente getCliente() {
        return cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public boolean isSeguro() {
        return seguro;
    }

    public boolean isGps() {
        return gps;
    }

    public boolean isConfirmada() {
        return confirmada;
    }

    public void confirmarReserva() {
        this.confirmada = true;
        this.vehiculo.setDisponible(false);
    }

    @Override
    public String toString() {
        return "Reserva [Cliente=" + cliente.getNombre() + ", Vehículo=" + vehiculo.getIdVehiculo() +
                ", Fecha Inicio=" + fechaInicio + ", Fecha Fin=" + fechaFin +
                ", Seguro=" + seguro + ", GPS=" + gps + ", Confirmada=" + confirmada + "]";
    }
}