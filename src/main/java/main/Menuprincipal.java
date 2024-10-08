package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menuprincipal {
    public static void main(String[] args) {
        List<Vehiculo> flotaVehiculos = new ArrayList<>();
        List<Reserva> reservas = new ArrayList<>(); // Añadido lista de reservas

        Admin admin = new Admin(flotaVehiculos, reservas); // Pasar lista de reservas al admin
        Clientemenu clienteMenu = new Clientemenu(flotaVehiculos, reservas); // Pasar lista de reservas al cliente

        Scanner scanner = new Scanner(System.in);
        int opcionMain = 0;
        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Administrador");
            System.out.println("2. Cliente");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, ingresa un número.");
                scanner.nextLine();
                continue;
            }

            opcionMain = scanner.nextInt();
            scanner.nextLine();

            switch (opcionMain) {
                case 1:
                    admin.login();
                    break;
                case 2:
                    clienteMenu.menuCliente();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcionMain != 3);
        scanner.close();
    }
}