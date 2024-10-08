package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Clientemenu {
    private Scanner scanner = new Scanner(System.in);
    private List<Cliente> clientesRegistrados = new ArrayList<>();
    private List<Reserva> reservas; // Compartir lista de reservas
    private List<Vehiculo> flotaVehiculos;
    private int opcion;

    public Clientemenu(List<Vehiculo> flotaVehiculos, List<Reserva> reservas) { // Constructor modificado
        this.flotaVehiculos = flotaVehiculos;
        this.reservas = reservas;
    }

    public void menuCliente(){
        do {
            System.out.println("\n--- Menú Cliente ---");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, ingresa un número.");
                scanner.nextLine();
                continue;
            }

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarCliente();
                    break;
                case 2:
                    iniciarSesion();
                    break;
                case 3:
                    System.out.println("Saliendo del menú del cliente...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 3);
    }

    private void registrarCliente() {
        System.out.print("Ingrese su ID de Cliente: ");
        String idCliente = scanner.nextLine().trim();
        System.out.print("Ingrese su Nombre: ");
        String nombre = scanner.nextLine().trim();

        if (idCliente.isEmpty() || nombre.isEmpty()) {
            System.out.println("El ID de Cliente y el Nombre no pueden estar vacíos.");
            return;
        }

        for (Cliente cliente : clientesRegistrados) {
            if (cliente.getIdCliente().equals(idCliente)) {
                System.out.println("El cliente ya está registrado.");
                return;
            }
        }

        Cliente nuevoCliente = new Cliente(idCliente, nombre);
        clientesRegistrados.add(nuevoCliente);
        System.out.println("Cliente registrado exitosamente.");
    }

    private void iniciarSesion() {
        System.out.print("Ingrese su ID de Cliente: ");
        String idCliente = scanner.nextLine().trim();

        if (idCliente.isEmpty()) {
            System.out.println("El ID de Cliente no puede estar vacío.");
            return;
        }

        Cliente cliente = null;
        for (Cliente c : clientesRegistrados) {
            if (c.getIdCliente().equals(idCliente)) {
                cliente = c;
                break;
            }
        }

        if (cliente == null) {
            System.out.println("Cliente no encontrado. Por favor, regístrese primero.");
            return;
        }

        System.out.println("Bienvenido, " + cliente.getNombre() + "!");
        menuReservas(cliente);
    }

    private void menuReservas(Cliente cliente) {
        while (true) {
            System.out.println("\n--- Menú de Reservas ---");
            System.out.println("1. Realizar Reserva");
            System.out.println("2. Ver Mis Reservas");
            System.out.println("3. Cancelar Reserva");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, ingresa un número.");
                scanner.nextLine();
                continue;
            }

            int opcionReserva = scanner.nextInt();
            scanner.nextLine();

            switch (opcionReserva) {
                case 1:
                    realizarReserva(cliente);
                    break;
                case 2:
                    verMisReservas(cliente);
                    break;
                case 3:
                    cancelarReserva(cliente);
                    break;
                case 4:
                    System.out.println("Volviendo al Menú Cliente...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private void realizarReserva(Cliente cliente) {
        List<Vehiculo> disponibles = listarVehiculosDisponibles();
        if (disponibles.isEmpty()) {
            System.out.println("No hay vehículos disponibles para reservar.");
            return;
        }

        System.out.println("\n--- Vehículos Disponibles ---");
        for (Vehiculo v : disponibles) {
            System.out.println(v);
        }

        System.out.print("Ingrese el ID del vehículo que desea reservar: ");
        String idVehiculoInput = scanner.nextLine().trim();
        int idVehiculo;
        try {
            idVehiculo = Integer.parseInt(idVehiculoInput);
        } catch (NumberFormatException e) {
            System.out.println("ID de vehículo inválido. Debe ser un número entero.");
            return;
        }

        Vehiculo vehiculoSeleccionado = null;
        for (Vehiculo v : flotaVehiculos) {
            if (v.getIdVehiculo() == idVehiculo) {
                vehiculoSeleccionado = v;
                break;
            }
        }

        if (vehiculoSeleccionado == null) {
            System.out.println("Vehículo no encontrado.");
            return;
        }

        if (!vehiculoSeleccionado.isDisponible()) {
            System.out.println("El vehículo no está disponible para la reserva.");
            return;
        }

        for (Reserva r : reservas) {
            if (r.getCliente().getIdCliente().equals(cliente.getIdCliente()) && r.isConfirmada()) {
                System.out.println("No puede realizar otra reserva mientras tenga una activa.");
                return;
            }
        }

        try {
            System.out.print("Ingrese la fecha de inicio (YYYY-MM-DD): ");
            String fechaInicioInput = scanner.nextLine().trim();
            LocalDate fechaInicio = LocalDate.parse(fechaInicioInput);

            System.out.print("Ingrese la fecha de fin (YYYY-MM-DD): ");
            String fechaFinInput = scanner.nextLine().trim();
            LocalDate fechaFin = LocalDate.parse(fechaFinInput);

            if (fechaFin.isBefore(fechaInicio)) {
                System.out.println("La fecha de fin no puede ser antes de la fecha de inicio.");
                return;
            }

            System.out.print("¿Desea incluir seguro? (true/false): ");
            boolean seguro = Boolean.parseBoolean(scanner.nextLine().trim());

            System.out.print("¿Desea incluir GPS? (true/false): ");
            boolean gps = Boolean.parseBoolean(scanner.nextLine().trim());

            Reserva reserva = new Reserva(cliente, vehiculoSeleccionado, fechaInicio, fechaFin, seguro, gps);
            reserva.confirmarReserva();
            reservas.add(reserva);
            System.out.println("Reserva realizada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al realizar la reserva: " + e.getMessage());
        }
    }

    private List<Vehiculo> listarVehiculosDisponibles() {
        List<Vehiculo> disponibles = new ArrayList<>();
        for (Vehiculo v : flotaVehiculos) {
            if (v.isDisponible()) {
                disponibles.add(v);
            }
        }
        return disponibles;
    }

    private void verMisReservas(Cliente cliente) {
        System.out.println("\n--- Mis Reservas ---");
        boolean tieneReservas = false;
        for (Reserva r : reservas) {
            if (r.getCliente().getIdCliente().equals(cliente.getIdCliente())) {
                System.out.println(r);
                tieneReservas = true;
            }
        }
        if (!tieneReservas) {
            System.out.println("No tienes reservas realizadas.");
        }
    }

    private void cancelarReserva(Cliente cliente) {
        System.out.println("\n--- Cancelar Reserva ---");
        List<Reserva> reservasCliente = new ArrayList<>();
        for (Reserva r : reservas) {
            if (r.getCliente().getIdCliente().equals(cliente.getIdCliente()) && r.isConfirmada()) {
                reservasCliente.add(r);
            }
        }

        if (reservasCliente.isEmpty()) {
            System.out.println("No tienes reservas activas para cancelar.");
            return;
        }

        System.out.println("Tus reservas activas:");
        for (int i = 0; i < reservasCliente.size(); i++) {
            System.out.println((i + 1) + ". " + reservasCliente.get(i));
        }

        System.out.print("Seleccione la reserva que desea cancelar (número): ");
        String seleccionInput = scanner.nextLine().trim();
        int seleccion;
        try {
            seleccion = Integer.parseInt(seleccionInput);
            if (seleccion < 1 || seleccion > reservasCliente.size()) {
                System.out.println("Selección inválida.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Selección inválida. Debe ser un número entero.");
            return;
        }

        Reserva reservaACancelar = reservasCliente.get(seleccion - 1);
        reservaACancelar.getVehiculo().setDisponible(true);
        reservas.remove(reservaACancelar);
        System.out.println("Reserva cancelada exitosamente.");
    }
}