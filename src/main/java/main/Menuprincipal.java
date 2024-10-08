package main;

import java.util.Scanner;

public class Menuprincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        Clientemenu mc = new Clientemenu();
        int opcion;
        do {
            System.out.println("\n--- Sistema de Gestión de Reservas ---");
            System.out.println("1. Iniciar Sesión como Cliente");
            System.out.println("2. Iniciar Sesión como Administrador");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mc.menuCliente();
                    break;
                case 2:
                    admin.login();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 3);
        scanner.close();
    }
}