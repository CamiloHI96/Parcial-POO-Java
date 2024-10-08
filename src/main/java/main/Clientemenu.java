package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Clientemenu {
    Scanner scanner = new Scanner(System.in);
    private List<Cliente> clientesRegistrados = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();
    private List<Vehiculo> flotaVehiculos;
    int opcion;

    public Clientemenu(List<Vehiculo> flotaVehiculos) {
        this.flotaVehiculos = flotaVehiculos;
    }

    public void menuCliente(){
        do {
            System.out.println("\n--- Menú Cliente ---");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    registrarCliente();
                    break;
                case 2:
                    iniciarSesion();
                    break;
                case 3:
                System.out.println("Saliendo del menú del administrador...");
                main.Menuprincipal.main(null);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 3);
        scanner.close();
    }

    private void registrarCliente() {
        scanner.nextLine();
        System.out.print("Ingrese su ID de Cliente: ");
        String idCliente = scanner.nextLine().trim();
        System.out.print("Ingrese su Nombre: ");
        String nombre = scanner.nextLine().trim();

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
        scanner.nextLine();
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
    }
}